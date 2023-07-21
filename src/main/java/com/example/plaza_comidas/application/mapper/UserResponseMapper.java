package com.example.plaza_comidas.application.mapper;

import com.example.plaza_comidas.application.dto.RoleDto;
import com.example.plaza_comidas.application.dto.UserResponse;
import com.example.plaza_comidas.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        uses = RoleDtoMapper.class)
public interface UserResponseMapper {

    @Mapping(target = "role.name", source = "roleDto.name")
    @Mapping(target = "role.description", source = "roleDto.description")
    @Mapping(target = "name", source = "user.name")
    UserResponse toResponse(User user, RoleDto roleDto);
}
