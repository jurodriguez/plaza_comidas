package com.example.plaza_comidas.infrastructure.output.passwordencoder;

import com.example.plaza_comidas.domain.spi.passwordencoder.IUsuarioPasswordEncoderPort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class BCrypPasswordEncoderAdapter implements IUsuarioPasswordEncoderPort {

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public String encode(String password) {
        return passwordEncoder.encode(password);
    }
}
