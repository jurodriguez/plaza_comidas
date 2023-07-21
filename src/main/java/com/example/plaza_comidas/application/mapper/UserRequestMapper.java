package com.example.plaza_comidas.application.mapper;


import com.example.plaza_comidas.application.dto.UserRequest;
import com.example.plaza_comidas.domain.model.Role;
import com.example.plaza_comidas.domain.model.User;
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
