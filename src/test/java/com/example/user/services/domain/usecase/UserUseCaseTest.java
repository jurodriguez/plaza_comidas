package com.example.user.services.domain.usecase;

import com.example.user.services.domain.model.Restaurant;
import com.example.user.services.domain.model.RestaurantEmployee;
import com.example.user.services.domain.model.User;
import com.example.user.services.domain.spi.feignclients.IRestaurantEmployeeFeignClientPort;
import com.example.user.services.domain.spi.feignclients.IRestaurantFeignClientPort;
import com.example.user.services.domain.spi.passwordencoder.IUserPasswordEncoderPort;
import com.example.user.services.domain.spi.persistence.IUserPersistencePort;
import com.example.user.services.domain.spi.token.IToken;
import com.example.user.services.factory.FactoryUsersDataTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class UserUseCaseTest {

    @InjectMocks
    UserUseCase userUseCase;

    @Mock
    IUserPersistencePort userPersistencePort;

    @Mock
    IUserPasswordEncoderPort userPasswordEncoderPort;

    @Mock
    IToken token;

    @Mock
    IRestaurantFeignClientPort restaurantFeignClientPort;

    @Mock
    IRestaurantEmployeeFeignClientPort restaurantEmployeeFeignClientPort;

    @Test
    void mustSaveUserOwner() {
        User user = FactoryUsersDataTest.getUser();

        Mockito.when(token.getBearerToken()).thenReturn("Bearer token");
        Mockito.when(token.getAuthenticatedUserRole("Bearer token")).thenReturn("ADMINISTRATOR");
        Mockito.when(userPasswordEncoderPort.encode(Mockito.any())).thenReturn("encodedPassword#gfdg23232");

        userUseCase.saveUser(user);

        //Then
        Mockito.verify(userPasswordEncoderPort).encode("password");
        Mockito.verify(userPersistencePort).saveUser(Mockito.any(User.class));
    }

    @Test
    void mustSaveUserEmployee() {
        User user = FactoryUsersDataTest.getEmployeeUser();

        Mockito.when(token.getBearerToken()).thenReturn("Bearer token");
        Mockito.when(token.getAuthenticatedUserRole("Bearer token")).thenReturn("OWNER");
        Mockito.when(userPasswordEncoderPort.encode(Mockito.any())).thenReturn("encodedPassword#gfdg23232");

        userUseCase.saveUser(user);

        //Then
        Mockito.verify(userPasswordEncoderPort).encode("password");
        Mockito.verify(userPersistencePort).saveUser(Mockito.any(User.class));
    }

    @Test
    public void mustSaveRestaurantEmployee() {
        User user = new User();
        user.setEmail(FactoryUsersDataTest.getEmployeeUser().getEmail());

        Restaurant restaurant = new Restaurant();
        restaurant.setId(789L);

        User userModel = new User();
        user.setId(123L);

        Mockito.when(token.getBearerToken()).thenReturn("Bearer token");
        Mockito.when(token.getAuthenticatedUserId("Bearer token")).thenReturn(456L);
        Mockito.when(restaurantFeignClientPort.getRestaurantByOwnerId(456L)).thenReturn(restaurant);
        Mockito.when(userPersistencePort.getUserByEmail(user.getEmail())).thenReturn(userModel);

        // Execute the method to be tested
        userUseCase.saveRestaurantEmployee(user);

        // Verify the expected behavior
        ArgumentCaptor<RestaurantEmployee> argument = ArgumentCaptor.forClass(RestaurantEmployee.class);
        Mockito.verify(restaurantEmployeeFeignClientPort, Mockito.times(1)).saveRestaurantEmployee(argument.capture());

        RestaurantEmployee savedRestaurantEmployee = argument.getValue();
        //assertEquals(savedRestaurantEmployee.getRestaurantId(), Mockito.anyLong());
        //assertEquals(savedRestaurantEmployee.getEmployeeId(), Mockito.anyLong());
    }

    @Test
    void mustSaveUserCustomer() {
        User user = FactoryUsersDataTest.getCustomerUser();

        Mockito.when(token.getBearerToken()).thenReturn(null);
        Mockito.when(userPasswordEncoderPort.encode(Mockito.any())).thenReturn("encodedPassword#gfdg23232");

        userUseCase.saveUser(user);

        //Then
        Mockito.verify(userPasswordEncoderPort).encode("password");
        Mockito.verify(userPersistencePort).saveUser(Mockito.any(User.class));
    }

    @Test
    void mustGetAUserById() {
        User user = FactoryUsersDataTest.getUser();

        Mockito.when(userPersistencePort.getUserById(Mockito.anyLong())).thenReturn(user);

        userUseCase.getUserById(user.getId());
        Mockito.verify(userPersistencePort).getUserById(Mockito.anyLong());
    }

    @Test
    void mustGetAUserByEmail() {
        User user = FactoryUsersDataTest.getUser();

        Mockito.when(userPersistencePort.getUserById(Mockito.anyLong())).thenReturn(user);

        userUseCase.getUserByEmail(user.getEmail());
        Mockito.verify(userPersistencePort).getUserByEmail(Mockito.any());
    }
}
