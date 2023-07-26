package com.example.user.services.infrastructure.output.passwordencoder;

import com.example.user.services.domain.spi.passwordencoder.IUserPasswordEncoderPort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class BCrypPasswordEncoderAdapter implements IUserPasswordEncoderPort {

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public String encode(String password) {
        return passwordEncoder.encode(password);
    }
}
