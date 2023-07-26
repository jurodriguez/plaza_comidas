package com.example.user.services.infrastructure.output.jpa.repository;

import com.example.user.services.infrastructure.output.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findOneByEmail(String email);
}
