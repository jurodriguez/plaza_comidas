package com.example.plaza_comidas.domain.api;

import com.example.plaza_comidas.domain.model.Role;

import java.util.List;

public interface IRoleServicePort {

    Role saveRole(Role role);

    List<Role> getAllRole();

    Role getRole(Long id);
}
