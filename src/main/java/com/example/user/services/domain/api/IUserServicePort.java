package com.example.user.services.domain.api;

import com.example.user.services.domain.model.User;


public interface IUserServicePort {

    void saveUser(User user);

    User getUserById(Long id);

    User getUserByEmail(String email);

    void saveRestaurantEmployee(User user);
}
