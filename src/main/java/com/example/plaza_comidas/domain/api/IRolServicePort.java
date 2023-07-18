package com.example.plaza_comidas.domain.api;

import com.example.plaza_comidas.domain.model.Rol;

import java.util.List;

public interface IRolServicePort {

    Rol saveRol(Rol rol);

    List<Rol> getAllRol();

    Rol getRol(Long id);
}
