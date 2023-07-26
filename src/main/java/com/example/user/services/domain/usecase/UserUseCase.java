package com.example.user.services.domain.usecase;

import com.example.user.services.domain.api.IUserServicePort;
import com.example.user.services.domain.model.ERoles;
import com.example.user.services.domain.model.User;
import com.example.user.services.domain.spi.passwordencoder.IUserPasswordEncoderPort;
import com.example.user.services.domain.spi.persistence.IUserPersistencePort;
import com.example.user.services.domain.util.UtilDateTime;
import com.example.user.services.domain.util.UtilNumbers;
import com.example.user.services.infrastructure.exception.PhoneNumberException;
import com.example.user.services.infrastructure.exception.UserIsNotLegalAgeException;
import com.example.user.services.infrastructure.exception.UserNumberDocumentIncorrectException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserUseCase implements IUserServicePort {

    private final IUserPersistencePort userPersistencePort;

    private final IUserPasswordEncoderPort userPasswordEncoderPort;

    public UserUseCase(IUserPersistencePort userPersistencePort, IUserPasswordEncoderPort userPasswordEncoderPort) {
        this.userPersistencePort = userPersistencePort;
        this.userPasswordEncoderPort = userPasswordEncoderPort;
    }

    @Override
    public void saveUser(User user) {
        //Encrypt the key
        user.setPassword(userPasswordEncoderPort.encode(user.getPassword()));

        //A role is assigned by default if you don't have a role assigned
        if (user.getRoleId() == null) {
            user.setRoleId(ERoles.OWNER.getId());
        }

        saveValidations(user);

        userPersistencePort.saveUser(user);
    }

    private void saveValidations(User user) {
        //Validate that the document number only contains numbers
        if (!UtilNumbers.onlyNumbers(user.getDocumentNumber())) {
            throw new UserNumberDocumentIncorrectException();
        }

        phoneValidation(user.getCellPhone());
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

}
