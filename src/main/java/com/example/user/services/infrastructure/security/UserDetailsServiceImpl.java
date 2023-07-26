package com.example.user.services.infrastructure.security;

import com.example.user.services.domain.model.User;
import com.example.user.services.infrastructure.output.jpa.entity.UserEntity;
import com.example.user.services.infrastructure.output.jpa.mapper.UserEntityMapper;
import com.example.user.services.infrastructure.output.jpa.repository.IUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {


    private final IUserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findOneByEmail(email).orElseThrow(() -> new UsernameNotFoundException("The user with email " + email + " doesn't exist."));
        User user = userEntityMapper.toUser(userEntity);
        return new UserDetailsImpl(user);
    }
}
