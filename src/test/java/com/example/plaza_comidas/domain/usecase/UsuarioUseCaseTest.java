package com.example.plaza_comidas.domain.usecase;

import com.example.plaza_comidas.domain.model.Usuario;
import com.example.plaza_comidas.domain.spi.passwordencoder.IUsuarioPasswordEncoderPort;
import com.example.plaza_comidas.domain.spi.persistence.IUsuarioPersistencePort;
import com.example.plaza_comidas.factory.FactoryUsersDataTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class UsuarioUseCaseTest {

    @InjectMocks
    UsuarioUseCase usuarioUseCase;

    @Mock
    IUsuarioPersistencePort usuarioPersistencePort;

    @Mock
    IUsuarioPasswordEncoderPort usuarioPasswordEncoderPort;

    @Test
    void mustSaveUsuario() {
        Usuario usuario= FactoryUsersDataTest.getUsuario();

        Mockito.when(usuarioPasswordEncoderPort.encode(Mockito.any())).thenReturn("encodedPassword#gfdg23232");

        usuarioUseCase.saveUsuario(usuario);

        //Then
        Mockito.verify(usuarioPasswordEncoderPort).encode("password");
        Mockito.verify(usuarioPersistencePort).saveUsuario(Mockito.any(Usuario.class));
    }
}
