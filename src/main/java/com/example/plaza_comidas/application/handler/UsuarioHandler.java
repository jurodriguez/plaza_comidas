package com.example.plaza_comidas.application.handler;

import com.example.plaza_comidas.application.dto.UsuarioRequest;
import com.example.plaza_comidas.application.dto.UsuarioResponse;
import com.example.plaza_comidas.application.mapper.RolDtoMapper;
import com.example.plaza_comidas.application.mapper.UsuarioRequestMapper;
import com.example.plaza_comidas.application.mapper.UsuarioResponseMapper;
import com.example.plaza_comidas.domain.api.IRolServicePort;
import com.example.plaza_comidas.domain.api.IUsuarioServicePort;
import com.example.plaza_comidas.domain.model.Rol;
import com.example.plaza_comidas.domain.model.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Validated
public class UsuarioHandler implements IUsuarioHandler {

    private final IUsuarioServicePort usuarioServicePort;
    private final IRolServicePort rolServicePort;
    private final UsuarioRequestMapper usuarioRequestMapper;
    private final UsuarioResponseMapper usuarioResponseMapper;
    private final RolDtoMapper rolDtoMapper;

    @Override
    public void saveUsuarioInUsuarios(UsuarioRequest usuarioRequest) {
        Usuario usuario = usuarioRequestMapper.toUsuario(usuarioRequest);
        usuarioServicePort.saveUsuario(usuario);
    }

    @Override
    public List<UsuarioResponse> getAllUsuarioFromUsuarios() {
        return null;
    }

    @Override
    public UsuarioResponse getUsuarioFromUsuarios(String numeroDocumento) {
        Usuario usuario = usuarioServicePort.getUsuario(numeroDocumento);
        return usuarioResponseMapper.toResponse(usuario, rolDtoMapper.toDto(rolServicePort.getRol(usuario.getIdRol())));
    }
}
