package com.example.plaza_comidas.application.mapper;

import com.example.plaza_comidas.application.dto.RolDto;
import com.example.plaza_comidas.domain.model.Rol;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface RolDtoMapper {

    RolDto toDto(Rol rol);
}
