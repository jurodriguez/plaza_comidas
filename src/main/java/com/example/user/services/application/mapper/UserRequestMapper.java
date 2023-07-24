package com.example.user.services.application.mapper;


import com.example.user.services.application.dto.UserRequest;
import com.example.user.services.domain.model.Role;
import com.example.user.services.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserRequestMapper {
    User toUser(UserRequest userRequest);

    @Mapping(source = "userRequest.roleName", target = "name")
    @Mapping(source = "userRequest.roleDescription", target = "description")
    Role toRole(UserRequest userRequest);

}
