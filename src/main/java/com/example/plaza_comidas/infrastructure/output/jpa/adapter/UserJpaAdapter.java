package com.example.plaza_comidas.infrastructure.output.jpa.adapter;

import com.example.plaza_comidas.domain.model.User;
import com.example.plaza_comidas.domain.spi.persistence.IUserPersistencePort;
import com.example.plaza_comidas.infrastructure.output.jpa.entity.UserEntity;
import com.example.plaza_comidas.infrastructure.output.jpa.mapper.UserEntityMapper;
import com.example.plaza_comidas.infrastructure.output.jpa.repository.IUserRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class UserJpaAdapter implements IUserPersistencePort {

    private final IUserRepository userRepository;

    private final UserEntityMapper userEntityMapper;

    @Override
    public void saveUser(User user) {
        userRepository.save(userEntityMapper.toEntity(user));
    }

    @Override
    public User getUserById(Long id) {
        Optional<UserEntity> usuarioEntityOptional = userRepository.findById(id);
        UserEntity userEntity = usuarioEntityOptional.orElse(null);
        return userEntityMapper.toUser(userEntity);
    }

}
