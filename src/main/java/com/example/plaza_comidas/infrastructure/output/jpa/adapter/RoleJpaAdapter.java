package com.example.plaza_comidas.infrastructure.output.jpa.adapter;

import com.example.plaza_comidas.domain.model.Role;
import com.example.plaza_comidas.domain.spi.persistence.IRolePersistencePort;
import com.example.plaza_comidas.infrastructure.exception.RolNotFoundException;
import com.example.plaza_comidas.infrastructure.output.jpa.entity.RoleEntity;
import com.example.plaza_comidas.infrastructure.output.jpa.mapper.RoleEntityMapper;
import com.example.plaza_comidas.infrastructure.output.jpa.repository.IRoleRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class RoleJpaAdapter implements IRolePersistencePort {

    private final IRoleRepository roleRepository;

    private final RoleEntityMapper roleEntityMapper;

    @Override
    public Role saveRole(Role role) {
        return roleEntityMapper.toRole(roleRepository.save(roleEntityMapper.toEntity(role)));
    }

    @Override
    public List<Role> getAllRole() {
        List<RoleEntity> roleEntityList = roleRepository.findAll();
        if (roleEntityList.isEmpty()) {
            throw new RolNotFoundException();
        }

        return roleEntityMapper.toRoleList(roleEntityList);
    }

    @Override
    public Role getRole(Long id) {
        return roleEntityMapper.toRole(roleRepository.findById(id).orElseThrow(RolNotFoundException::new));
    }
}
