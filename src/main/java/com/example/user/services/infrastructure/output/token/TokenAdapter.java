package com.example.user.services.infrastructure.output.token;

import com.example.user.services.domain.spi.token.IToken;
import com.example.user.services.infrastructure.exception.NoDataFoundException;
import com.example.user.services.infrastructure.security.TokenUtils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class TokenAdapter implements IToken {

    private final static String BEARER = "Bearer ";

    @Override
    public String getBearerToken() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("Authorization");
    }

    @Override
    public String getEmail(String token) {
        if (token == (null)) throw new NoDataFoundException();
        return TokenUtils.getEmail(token.replace(BEARER, ""));
    }

    @Override
    public Long getAuthenticatedUserId(String token) {
        if (token == (null)) throw new NoDataFoundException();
        return TokenUtils.getAuthenticatedUserId(token.replace(BEARER, ""));
    }

    @Override
    public String getAuthenticatedUserRole(String token) {
        if (token == (null)) throw new NoDataFoundException();
        return TokenUtils.getAuthenticatedUserRole(token.replace(BEARER, ""));
    }
}
