package com.example.plaza_comidas.infrastructure.output.jpa.adapter;

import com.example.plaza_comidas.domain.model.Rol;
import com.example.plaza_comidas.domain.spi.persistence.IRolPersistencePort;
import com.example.plaza_comidas.infrastructure.exception.UserNumberDocumentIncorrectException;
import com.example.plaza_comidas.infrastructure.exception.RolNotFoundException;
import com.example.plaza_comidas.infrastructure.output.jpa.entity.RolEntity;
import com.example.plaza_comidas.infrastructure.output.jpa.mapper.RolEntityMapper;
import com.example.plaza_comidas.infrastructure.output.jpa.repository.IRolRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class RolJpaAdapter implements IRolPersistencePort {

    private final IRolRepository rolRepository;

    private final RolEntityMapper rolEntityMapper;

    @Override
    public Rol saveRol(Rol rol) {
        return rolEntityMapper.toRol(rolRepository.save(rolEntityMapper.toEntity(rol)));
    }

    @Override
    public List<Rol> getAllRol() {
        List<RolEntity> rolEntityList = rolRepository.findAll();
        if (rolEntityList.isEmpty()) {
            throw new UserNumberDocumentIncorrectException();
        }

        return rolEntityMapper.toRolList(rolEntityList);
    }

    @Override
    public Rol getRol(Long id) {
        return rolEntityMapper.toRol(rolRepository.findById(id).orElseThrow(RolNotFoundException::new));
    }
}
