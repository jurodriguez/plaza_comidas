package com.example.plaza_comidas.domain.usecase;

import com.example.plaza_comidas.domain.api.IRolServicePort;
import com.example.plaza_comidas.domain.model.Rol;
import com.example.plaza_comidas.domain.spi.persistence.IRolPersistencePort;

import java.util.List;

public class RolUseCase implements IRolServicePort {

    private final IRolPersistencePort rolPersistencePort;

    public RolUseCase(IRolPersistencePort rolPersistencePort) {
        this.rolPersistencePort = rolPersistencePort;
    }

    @Override
    public Rol saveRol(Rol rol) {
        return rolPersistencePort.saveRol(rol);
    }

    @Override
    public List<Rol> getAllRol() {
        return rolPersistencePort.getAllRol();
    }

    @Override
    public Rol getRol(Long id) {
        return rolPersistencePort.getRol(id);
    }
}
