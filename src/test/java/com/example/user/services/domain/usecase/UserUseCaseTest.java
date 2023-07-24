package com.example.user.services.domain.usecase;

import com.example.user.services.domain.model.User;
import com.example.user.services.domain.spi.passwordencoder.IUserPasswordEncoderPort;
import com.example.user.services.domain.spi.persistence.IUserPersistencePort;
import com.example.user.services.factory.FactoryUsersDataTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class UserUseCaseTest {

    @InjectMocks
    UserUseCase userUseCase;

    @Mock
    IUserPersistencePort userPersistencePort;

    @Mock
    IUserPasswordEncoderPort userPasswordEncoderPort;

    @Test
    void mustSaveUser() {
        User user = FactoryUsersDataTest.getUser();

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
}
