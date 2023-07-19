package com.example.plaza_comidas.infrastructure.output.jpa.adapter;

import com.example.plaza_comidas.domain.model.Usuario;
import com.example.plaza_comidas.domain.spi.persistence.IUsuarioPersistencePort;
import com.example.plaza_comidas.infrastructure.output.jpa.mapper.UsuarioEntityMapper;
import com.example.plaza_comidas.infrastructure.output.jpa.repository.IUsuarioRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UsuarioJpaAdapter implements IUsuarioPersistencePort {

    private final IUsuarioRepository usuarioRepository;

    private final UsuarioEntityMapper usuarioEntityMapper;

    @Override
    public void saveUsuario(Usuario usuario) {
        usuarioRepository.save(usuarioEntityMapper.toEntity(usuario));
    }

}
