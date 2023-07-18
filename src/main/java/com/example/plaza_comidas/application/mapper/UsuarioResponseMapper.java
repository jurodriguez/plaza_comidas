package com.example.plaza_comidas.application.mapper;

import com.example.plaza_comidas.application.dto.RolDto;
import com.example.plaza_comidas.application.dto.UsuarioResponse;
import com.example.plaza_comidas.domain.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        uses = RolDtoMapper.class)
public interface UsuarioResponseMapper {

    @Mapping(target = "rol.nombre", source = "rolDto.nombre")
    @Mapping(target = "rol.descripcion", source = "rolDto.descripcion")
    @Mapping(target = "nombre", source = "usuario.nombre")
    UsuarioResponse toResponse(Usuario usuario, RolDto rolDto);
}
