package com.example.user.services.infrastructure.output.jpa.mapper;

import com.example.user.services.domain.model.Role;
import com.example.user.services.infrastructure.output.jpa.entity.RoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface RoleEntityMapper {

    RoleEntity toEntity(Role role);

    Role toRole(RoleEntity roleEntity);

    List<Role> toRoleList(List<RoleEntity> roleEntityList);
}
