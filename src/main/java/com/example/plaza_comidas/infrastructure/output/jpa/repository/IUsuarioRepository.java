package com.example.plaza_comidas.infrastructure.output.jpa.repository;

import com.example.plaza_comidas.infrastructure.output.jpa.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    Optional<UsuarioEntity> findByNumeroDocumento(String numeroDocumento);
}
