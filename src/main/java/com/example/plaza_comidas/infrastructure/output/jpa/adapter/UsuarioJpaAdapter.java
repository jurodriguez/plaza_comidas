package com.example.plaza_comidas.infrastructure.output.jpa.adapter;

import com.example.plaza_comidas.domain.model.Usuario;
import com.example.plaza_comidas.domain.spi.IUsuarioPersistencePort;
import com.example.plaza_comidas.infrastructure.exception.NoDataFoundException;
import com.example.plaza_comidas.infrastructure.exception.UsuarioAlreadyExistsException;
import com.example.plaza_comidas.infrastructure.exception.UsuarioNotFoundException;
import com.example.plaza_comidas.infrastructure.output.jpa.entity.UsuarioEntity;
import com.example.plaza_comidas.infrastructure.output.jpa.mapper.UsuarioEntityMapper;
import com.example.plaza_comidas.infrastructure.output.jpa.repository.IUsuarioRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class UsuarioJpaAdapter implements IUsuarioPersistencePort {

    private final IUsuarioRepository usuarioRepository;

    private final UsuarioEntityMapper usuarioEntityMapper;

    @Override
    public void saveUsuario(Usuario usuario) {
        if (usuarioRepository.findByNumeroDocumento(usuario.getNumeroDocumento()).isPresent()) {
            throw new UsuarioAlreadyExistsException();
        }
        usuarioRepository.save(usuarioEntityMapper.toEntity(usuario));
    }

    @Override
    public List<Usuario> getAllUsuario() {
        List<UsuarioEntity> usuarioEntityList = usuarioRepository.findAll();
        if (usuarioEntityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return usuarioEntityMapper.toUsuarioList(usuarioEntityList);
    }

    @Override
    public Usuario getUsuario(String numeroDocumento) {
        return usuarioEntityMapper.toUsuario(usuarioRepository.findByNumeroDocumento(numeroDocumento).orElseThrow(UsuarioNotFoundException::new));
    }
}
