package com.example.plaza_comidas.infrastructure.output.jpa.repository;

import com.example.plaza_comidas.infrastructure.output.jpa.entity.RolEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRolRepository extends JpaRepository<RolEntity, Long> {
}
