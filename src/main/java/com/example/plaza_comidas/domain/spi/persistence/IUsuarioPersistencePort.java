package com.example.plaza_comidas.domain.spi.persistence;

import com.example.plaza_comidas.domain.model.Usuario;

public interface IUsuarioPersistencePort {

    void saveUsuario(Usuario usuario);

}
