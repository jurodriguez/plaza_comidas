package com.example.user.services.application.handler;

import com.example.user.services.application.dto.UserRequest;
import com.example.user.services.application.dto.UserResponse;
import com.example.user.services.application.mapper.UserRequestMapper;
import com.example.user.services.application.mapper.UserResponseMapper;
import com.example.user.services.domain.api.IRoleServicePort;
import com.example.user.services.domain.api.IUserServicePort;
import com.example.user.services.domain.model.Role;
import com.example.user.services.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Service
@RequiredArgsConstructor
@Transactional
@Validated
public class UserHandler implements IUserHandler {

    private final IUserServicePort userServicePort;
    private final IRoleServicePort roleServicePort;
    private final UserRequestMapper userRequestMapper;
    private final UserResponseMapper userResponseMapper;

    @Override
    public void saveUserInUsers(UserRequest userRequest) {
        User user = userRequestMapper.toUser(userRequest);
        userServicePort.saveUser(user);
    }

    @Override
    public UserResponse getUserById(Long id) {
        User user = userServicePort.getUserById(id);
        Role role = new Role();
        if (user != null && user.getRoleId() != null) {
            role = roleServicePort.getRole(user.getRoleId());
        }
        return userResponseMapper.toResponse(user, role);
    }

    @Override
    public UserResponse getUserByEmail(String email) {
        User user = userServicePort.getUserByEmail(email);
        Role role = new Role();
        if (user != null && user.getRoleId() != null) {
            role = roleServicePort.getRole(user.getRoleId());
        }
        return userResponseMapper.toResponse(user, role);
    }

    @Override
    public void saveRestaurantEmployee(UserRequest userRequest) {
        User user = userRequestMapper.toUser(userRequest);
        userServicePort.saveRestaurantEmployee(user);
    }

}
