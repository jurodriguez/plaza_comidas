package com.example.plaza_comidas.infrastructure.output.jpa.repository;

import com.example.plaza_comidas.infrastructure.output.jpa.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<RoleEntity, Long> {
}
