package com.example.plaza_comidas.infrastructure.output.passwordencoder;

import com.example.plaza_comidas.domain.spi.passwordencoder.IUsuarioPasswordEncoderPort;
import org.mindrot.jbcrypt.BCrypt;

public class BCrypPasswordEncoderAdapter implements IUsuarioPasswordEncoderPort {

    @Override
    public String encode(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
}
