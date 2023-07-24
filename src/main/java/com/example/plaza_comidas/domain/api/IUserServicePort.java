package com.example.plaza_comidas.domain.api;

import com.example.plaza_comidas.domain.model.User;


public interface IUserServicePort {

    void saveUser(User user);

    User getUserById(Long id);
}
