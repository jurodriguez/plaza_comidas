package com.example.user.services.domain.spi.passwordencoder;

public interface IUserPasswordEncoderPort {

    String encode(String password);
}
