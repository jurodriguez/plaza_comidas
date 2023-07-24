package com.example.user.services.infrastructure.output.passwordencoder;

import com.example.user.services.domain.spi.passwordencoder.IUserPasswordEncoderPort;
import org.mindrot.jbcrypt.BCrypt;

public class BCrypPasswordEncoderAdapter implements IUserPasswordEncoderPort {

    @Override
    public String encode(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
}
