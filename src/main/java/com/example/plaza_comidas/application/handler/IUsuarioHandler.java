package com.example.plaza_comidas.application.handler;

import com.example.plaza_comidas.application.dto.UsuarioRequest;
import jakarta.validation.Valid;

public interface IUsuarioHandler {

    void saveUsuarioInUsuarios(@Valid UsuarioRequest usuarioRequest);

}
