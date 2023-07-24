package com.example.user.services.domain.api;

import com.example.user.services.domain.model.Role;

import java.util.List;

public interface IRoleServicePort {

    Role saveRole(Role role);

    List<Role> getAllRole();

    Role getRole(Long id);
}
