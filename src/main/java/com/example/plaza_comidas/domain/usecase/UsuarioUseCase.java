package com.example.plaza_comidas.domain.usecase;

import com.example.plaza_comidas.domain.api.IUsuarioServicePort;
import com.example.plaza_comidas.domain.model.Usuario;
import com.example.plaza_comidas.domain.spi.passwordencoder.IUsuarioPasswordEncoderPort;
import com.example.plaza_comidas.domain.spi.persistence.IUsuarioPersistencePort;
import com.example.plaza_comidas.domain.util.UtilFechaHora;
import com.example.plaza_comidas.domain.util.UtilNumeros;
import com.example.plaza_comidas.infrastructure.exception.UserIsNotLegalAgeException;
import com.example.plaza_comidas.infrastructure.exception.UserNumberDocumentIncorrectException;

public class UsuarioUseCase implements IUsuarioServicePort {

    private final IUsuarioPersistencePort usuarioPersistencePort;

    private final IUsuarioPasswordEncoderPort usuarioPasswordEncoderPort;

    public UsuarioUseCase(IUsuarioPersistencePort usuarioPersistencePort, IUsuarioPasswordEncoderPort usuarioPasswordEncoderPort) {
        this.usuarioPersistencePort = usuarioPersistencePort;
        this.usuarioPasswordEncoderPort = usuarioPasswordEncoderPort;
    }

    @Override
    public void saveUsuario(Usuario usuario) {
        //Encriptar la clave
        usuario.setClave(usuarioPasswordEncoderPort.encode(usuario.getClave()));

        //Se asigna un rol por defecto si no trae rol asignado
        if (usuario.getIdRol() == null) {
            Long idRol = 2L;
            usuario.setIdRol(idRol);
        }

        saveValidations(usuario);

        usuarioPersistencePort.saveUsuario(usuario);
    }

    private void saveValidations(Usuario usuario) {
        //Validar que el numero de documento solo contenga numeros
        if (!UtilNumeros.esSoloNumero(usuario.getNumeroDocumento())) {
            throw new UserNumberDocumentIncorrectException();
        }

        //validar que el usuario sea mayor de edad
        int adult = 18;
        if (usuario.getFechaNacimiento() == null || UtilFechaHora.calcularEdad(usuario.getFechaNacimiento()) < adult) {
            throw new UserIsNotLegalAgeException();
        }
    }

}
