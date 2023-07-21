package com.example.plaza_comidas.domain.spi.passwordencoder;

public interface IUserPasswordEncoderPort {

    String encode(String password);
}
