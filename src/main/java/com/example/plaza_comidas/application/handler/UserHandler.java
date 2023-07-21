package com.example.plaza_comidas.application.handler;

import com.example.plaza_comidas.application.dto.UserRequest;
import com.example.plaza_comidas.application.mapper.UserRequestMapper;
import com.example.plaza_comidas.domain.api.IUserServicePort;
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
    private final UserRequestMapper userRequestMapper;

    @Override
    public void saveUserInUsers(UserRequest userRequest) {
        User user = userRequestMapper.toUser(userRequest);
        userServicePort.saveUser(user);
    }

}
