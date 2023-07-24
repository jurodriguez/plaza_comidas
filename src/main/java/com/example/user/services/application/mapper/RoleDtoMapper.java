package com.example.user.services.application.mapper;

import com.example.user.services.application.dto.RoleDto;
import com.example.user.services.domain.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface RoleDtoMapper {

    RoleDto toDto(Role role);
}
