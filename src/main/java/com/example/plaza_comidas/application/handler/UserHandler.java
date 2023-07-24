package com.example.plaza_comidas.application.handler;

import com.example.plaza_comidas.application.dto.UserRequest;
import com.example.plaza_comidas.application.dto.UserResponse;
import com.example.plaza_comidas.application.mapper.UserRequestMapper;
import com.example.plaza_comidas.application.mapper.UserResponseMapper;
import com.example.plaza_comidas.domain.api.IRoleServicePort;
import com.example.plaza_comidas.domain.api.IUserServicePort;
import com.example.plaza_comidas.domain.model.Role;
import com.example.plaza_comidas.domain.model.User;
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

}
