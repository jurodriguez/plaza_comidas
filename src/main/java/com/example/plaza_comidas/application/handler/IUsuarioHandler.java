package com.example.plaza_comidas.application.handler;

import com.example.plaza_comidas.application.dto.UsuarioRequest;
import com.example.plaza_comidas.application.dto.UsuarioResponse;
import jakarta.validation.Valid;

import java.util.List;

public interface IUsuarioHandler {

    void saveUsuarioInUsuarios(@Valid UsuarioRequest usuarioRequest);

    List<UsuarioResponse> getAllUsuarioFromUsuarios();

    UsuarioResponse getUsuarioFromUsuarios(String numeroDocumento);
}
