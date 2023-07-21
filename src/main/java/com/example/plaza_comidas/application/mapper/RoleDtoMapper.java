package com.example.plaza_comidas.application.mapper;

import com.example.plaza_comidas.application.dto.RoleDto;
import com.example.plaza_comidas.domain.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface RoleDtoMapper {

    RoleDto toDto(Role role);
}
