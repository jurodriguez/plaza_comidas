package com.example.user.services.domain.usecase;

import com.example.user.services.domain.api.IRoleServicePort;
import com.example.user.services.domain.model.Role;
import com.example.user.services.domain.spi.persistence.IRolePersistencePort;

import java.util.List;

public class RoleUseCase implements IRoleServicePort {

    private final IRolePersistencePort rolePersistencePort;

    public RoleUseCase(IRolePersistencePort rolePersistencePort) {
        this.rolePersistencePort = rolePersistencePort;
    }

    @Override
    public Role saveRole(Role role) {
        return rolePersistencePort.saveRole(role);
    }

    @Override
    public List<Role> getAllRole() {
        return rolePersistencePort.getAllRole();
    }

    @Override
    public Role getRole(Long id) {
        return rolePersistencePort.getRole(id);
    }
}
