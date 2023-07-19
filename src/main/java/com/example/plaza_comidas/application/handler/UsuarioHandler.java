package com.example.plaza_comidas.application.handler;

import com.example.plaza_comidas.application.dto.UsuarioRequest;
import com.example.plaza_comidas.application.mapper.UsuarioRequestMapper;
import com.example.plaza_comidas.domain.api.IUsuarioServicePort;
import com.example.plaza_comidas.domain.model.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Service
@RequiredArgsConstructor
@Transactional
@Validated
public class UsuarioHandler implements IUsuarioHandler {

    private final IUsuarioServicePort usuarioServicePort;
    private final UsuarioRequestMapper usuarioRequestMapper;

    @Override
    public void saveUsuarioInUsuarios(UsuarioRequest usuarioRequest) {
        Usuario usuario = usuarioRequestMapper.toUsuario(usuarioRequest);
        usuarioServicePort.saveUsuario(usuario);
    }

}
