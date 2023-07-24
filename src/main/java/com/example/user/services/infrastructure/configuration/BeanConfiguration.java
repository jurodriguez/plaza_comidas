package com.example.user.services.infrastructure.configuration;

import com.example.user.services.domain.api.IRoleServicePort;
import com.example.user.services.domain.api.IUserServicePort;
import com.example.user.services.domain.spi.passwordencoder.IUserPasswordEncoderPort;
import com.example.user.services.domain.spi.persistence.IRolePersistencePort;
import com.example.user.services.domain.spi.persistence.IUserPersistencePort;
import com.example.user.services.domain.usecase.RoleUseCase;
import com.example.user.services.domain.usecase.UserUseCase;
import com.example.user.services.infrastructure.output.jpa.adapter.RoleJpaAdapter;
import com.example.user.services.infrastructure.output.jpa.adapter.UserJpaAdapter;
import com.example.user.services.infrastructure.output.jpa.mapper.RoleEntityMapper;
import com.example.user.services.infrastructure.output.jpa.mapper.UserEntityMapper;
import com.example.user.services.infrastructure.output.jpa.repository.IRoleRepository;
import com.example.user.services.infrastructure.output.jpa.repository.IUserRepository;
import com.example.user.services.infrastructure.output.passwordencoder.BCrypPasswordEncoderAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final IUserRepository userRepository;
    private final UserEntityMapper userEntityMapper;
    private final IRoleRepository roleRepository;
    private final RoleEntityMapper roleEntityMapper;


    @Bean
    public IUserPasswordEncoderPort userPasswordEncoderPort() {
        return new BCrypPasswordEncoderAdapter();
    }

    @Bean
    public IUserPersistencePort userPersistencePort() {
        return new UserJpaAdapter(userRepository, userEntityMapper);
    }

    @Bean
    public IUserServicePort userServicePort() {
        return new UserUseCase(userPersistencePort(), userPasswordEncoderPort());
    }

    @Bean
    public IRolePersistencePort rolePersistencePort() {
        return new RoleJpaAdapter(roleRepository, roleEntityMapper);
    }

    @Bean
    public IRoleServicePort roleServicePort() {
        return new RoleUseCase(rolePersistencePort());
    }
}
