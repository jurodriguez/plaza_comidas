package com.example.user.services.domain.spi.persistence;

import com.example.user.services.domain.model.User;

public interface IUserPersistencePort {

    void saveUser(User user);

    User getUserById(Long id);

}
