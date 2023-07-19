package com.example.plaza_comidas.infrastructure.output.jpa.repository;

import com.example.plaza_comidas.infrastructure.output.jpa.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

}
