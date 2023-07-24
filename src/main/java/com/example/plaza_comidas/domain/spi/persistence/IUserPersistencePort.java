package com.example.plaza_comidas.domain.spi.persistence;

import com.example.plaza_comidas.domain.model.User;

public interface IUserPersistencePort {

    void saveUser(User user);

    User getUserById(Long id);

}
