package com.example.plaza_comidas.domain.spi.persistence;

import com.example.plaza_comidas.domain.model.Role;

import java.util.List;

public interface IRolePersistencePort {

    Role saveRole(Role role);

    List<Role> getAllRole();

    Role getRole(Long id);
}
