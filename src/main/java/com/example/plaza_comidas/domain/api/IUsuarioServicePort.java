package com.example.plaza_comidas.domain.api;

import com.example.plaza_comidas.domain.model.Usuario;

import java.util.List;

public interface IUsuarioServicePort {

    void saveUsuario(Usuario usuario);

    List<Usuario> getAllUsuario();

    Usuario getUsuario(String numeroDocumento);
}
