package com.example.user.services.domain.spi.persistence;

import com.example.user.services.domain.model.Role;

import java.util.List;

public interface IRolePersistencePort {

    Role saveRole(Role role);

    List<Role> getAllRole();

    Role getRole(Long id);
}
