package com.example.plaza_comidas.domain.usecase;

import com.example.plaza_comidas.domain.model.User;
import com.example.plaza_comidas.domain.spi.passwordencoder.IUserPasswordEncoderPort;
import com.example.plaza_comidas.domain.spi.persistence.IUserPersistencePort;
import com.example.plaza_comidas.factory.FactoryUsersDataTest;
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
        User user = FactoryUsersDataTest.getUsuario();

        Mockito.when(userPasswordEncoderPort.encode(Mockito.any())).thenReturn("encodedPassword#gfdg23232");

        userUseCase.saveUser(user);

        //Then
        Mockito.verify(userPasswordEncoderPort).encode("password");
        Mockito.verify(userPersistencePort).saveUser(Mockito.any(User.class));
    }
}
