package com.example.user.services.application.mapper;

import com.example.user.services.application.dto.UserResponse;
import com.example.user.services.domain.model.Role;
import com.example.user.services.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        uses = RoleDtoMapper.class)
public interface UserResponseMapper {

    @Mapping(target = "role.id", source = "role.id")
    @Mapping(target = "role.name", source = "role.name")
    @Mapping(target = "role.description", source = "role.description")
    @Mapping(target = "name", source = "user.name")
    UserResponse toResponse(User user, Role role);
}
