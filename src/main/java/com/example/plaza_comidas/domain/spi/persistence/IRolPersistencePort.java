package com.example.plaza_comidas.domain.spi.persistence;

import com.example.plaza_comidas.domain.model.Rol;

import java.util.List;

public interface IRolPersistencePort {

    Rol saveRol(Rol rol);

    List<Rol> getAllRol();

    Rol getRol(Long id);
}
