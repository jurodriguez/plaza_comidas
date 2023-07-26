package com.example.user.services.domain.spi.token;

public interface IToken {
    String getBearerToken();

    String getEmail(String token);

    Long getAuthenticatedUserId(String token);

    String getAuthenticatedUserRole(String token);
}
