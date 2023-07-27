package com.example.user.services.application.handler;

import com.example.user.services.application.dto.UserRequest;
import com.example.user.services.application.dto.UserResponse;

import javax.validation.Valid;

public interface IUserHandler {

    void saveUserInUsers(@Valid UserRequest userRequest);

    UserResponse getUserById(Long id);

    UserResponse getUserByEmail(String email);

    void saveRestaurantEmployee(UserRequest userRequest);

}
