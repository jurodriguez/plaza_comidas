package com.example.plaza_comidas.domain.spi;

import com.example.plaza_comidas.domain.model.Usuario;

import java.util.List;

public interface IUsuarioPersistencePort {

    void saveUsuario(Usuario usuario);

    List<Usuario> getAllUsuario();

    Usuario getUsuario(String numeroDocumento);
}
