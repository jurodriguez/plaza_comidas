package com.example.plaza_comidas.application.mapper;


import com.example.plaza_comidas.application.dto.UsuarioRequest;
import com.example.plaza_comidas.domain.model.Rol;
import com.example.plaza_comidas.domain.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
unmappedTargetPolicy = ReportingPolicy.IGNORE,
unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UsuarioRequestMapper {
    Usuario toUsuario(UsuarioRequest usuarioRequest);

    @Mapping(source = "usuarioRequest.nombreRol", target = "nombre")
    @Mapping(source = "usuarioRequest.descripcionRol", target = "descripcion")
    Rol toRol(UsuarioRequest usuarioRequest);

}
