package com.example.plaza_comidas.factory;

import com.example.plaza_comidas.domain.model.Usuario;

import java.time.LocalDate;

public class FactoryUsersDataTest {

    public static Usuario getUsuario(){
        Usuario usuario= new Usuario();
        usuario.setId(1L);
        usuario.setNombre("David");
        usuario.setApellido("Ballesteros");
        usuario.setCelular("+573238123367");
        usuario.setNumeroDocumento("1006287478");
        usuario.setFechaNacimiento(LocalDate.of(2005, 07, 18));
        usuario.setCorreo("david@pragma.com");
        usuario.setClave("password");
        //usuario.setIdRol(2L);
        return usuario;
    }
}
