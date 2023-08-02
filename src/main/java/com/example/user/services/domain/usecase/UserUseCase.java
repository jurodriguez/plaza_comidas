package com.example.user.services.domain.usecase;

import com.example.user.services.domain.api.IUserServicePort;
import com.example.user.services.domain.model.ERoles;
import com.example.user.services.domain.model.Restaurant;
import com.example.user.services.domain.model.RestaurantEmployee;
import com.example.user.services.domain.model.User;
import com.example.user.services.domain.spi.feignclients.IRestaurantEmployeeFeignClientPort;
import com.example.user.services.domain.spi.feignclients.IRestaurantFeignClientPort;
import com.example.user.services.domain.spi.passwordencoder.IUserPasswordEncoderPort;
import com.example.user.services.domain.spi.persistence.IUserPersistencePort;
import com.example.user.services.domain.spi.token.IToken;
import com.example.user.services.domain.util.UtilDateTime;
import com.example.user.services.domain.util.UtilNumbers;
import com.example.user.services.infrastructure.exception.OwnerNotAuthenticatedException;
import com.example.user.services.infrastructure.exception.RestaurantIdInvalidException;
import com.example.user.services.infrastructure.exception.PhoneNumberException;
import com.example.user.services.infrastructure.exception.UserIsNotLegalAgeException;
import com.example.user.services.infrastructure.exception.UserNumberDocumentIncorrectException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserUseCase implements IUserServicePort {

    private final IUserPersistencePort userPersistencePort;

    private final IUserPasswordEncoderPort userPasswordEncoderPort;

    private final IToken token;

    private final IRestaurantEmployeeFeignClientPort restaurantEmployeeFeignClientPort;

    private final IRestaurantFeignClientPort restaurantFeignClientPort;

    public UserUseCase(IUserPersistencePort userPersistencePort, IUserPasswordEncoderPort userPasswordEncoderPort, IToken token, IRestaurantEmployeeFeignClientPort restaurantEmployeeFeignClientPort, IRestaurantFeignClientPort restaurantFeignClientPort) {
        this.userPersistencePort = userPersistencePort;
        this.userPasswordEncoderPort = userPasswordEncoderPort;
        this.token = token;
        this.restaurantEmployeeFeignClientPort = restaurantEmployeeFeignClientPort;
        this.restaurantFeignClientPort = restaurantFeignClientPort;
    }

    @Override
    public void saveUser(User user) {
        //Encrypt the key
        user.setPassword(userPasswordEncoderPort.encode(user.getPassword()));

        assignRole(user);
        saveValidations(user);

        userPersistencePort.saveUser(user);
    }

    private void assignRole(User user) {
        String role = getAuthenticatedRole();

        if (role == null) {
            user.setRoleId(ERoles.CUSTOMER.getId());
        } else {
            if (role.equals(ERoles.ADMINISTRATOR.getName())) {
                user.setRoleId(ERoles.OWNER.getId());
            } else if (role.equals(ERoles.OWNER.getName())) {
                user.setRoleId(ERoles.EMPLOYEE.getId());
            } else {
                user.setRoleId(null);
            }
        }
    }

    private String getAuthenticatedRole() {
        String bearerToken = token.getBearerToken();
        String rol = bearerToken != null ? token.getAuthenticatedUserRole(bearerToken) : null;
        return rol;
    }

    private void saveValidations(User user) {
        //Validate that the document number only contains numbers
        if (!UtilNumbers.onlyNumbers(user.getDocumentNumber())) {
            throw new UserNumberDocumentIncorrectException();
        }
        phoneValidation(user.getCellPhone());
        if (user.getRoleId() != null && user.getRoleId().longValue() == ERoles.OWNER.getId().longValue())
            validateUserAge(user);
    }


    private static void phoneValidation(String phone) {
        String regex = "^(\\+?\\d{1,3})?\\d{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phone);

        if (!matcher.matches()) {
            throw new PhoneNumberException();
        }
    }

    private static void validateUserAge(User user) {
        int adult = 18;
        if (user.getBirthDate() == null || UtilDateTime.calculateAge(user.getBirthDate()) < adult) {
            throw new UserIsNotLegalAgeException();
        }
    }

    @Override
    public User getUserById(Long id) {
        return userPersistencePort.getUserById(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return userPersistencePort.getUserByEmail(email);
    }

    @Override
    public void saveRestaurantEmployee(User user) {
        RestaurantEmployee restaurantEmployee = setRestaurantEmployeeObject(user);
        restaurantEmployeeFeignClientPort.saveRestaurantEmployee(restaurantEmployee);
    }

    private RestaurantEmployee setRestaurantEmployeeObject(User user) {
        RestaurantEmployee restaurantEmployee = new RestaurantEmployee();
        restaurantEmployee.setRestaurantId(getRestaurantId());
        restaurantEmployee.setEmployeeId(getEmployeeId(user.getEmail()));

        return restaurantEmployee;
    }

    private Long getEmployeeId(String email) {
        User user = userPersistencePort.getUserByEmail(email);
        return user.getId();
    }

    private Long getRestaurantId() {
        Long idOwnerAuth = getOwnerAuth();

        Restaurant restaurant = restaurantFeignClientPort.getRestaurantByOwnerId(idOwnerAuth);
        if (restaurant == null) throw new RestaurantIdInvalidException();
        return restaurant.getOwnerId();
    }

    private Long getOwnerAuth() {
        String bearerToken = token.getBearerToken();
        if (bearerToken == null) throw new OwnerNotAuthenticatedException();
        return token.getAuthenticatedUserId(bearerToken);
    }

}
