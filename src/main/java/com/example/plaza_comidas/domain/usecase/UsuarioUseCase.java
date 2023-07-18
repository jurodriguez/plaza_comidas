package com.example.plaza_comidas.domain.usecase;

import com.example.plaza_comidas.domain.api.IUsuarioServicePort;
import com.example.plaza_comidas.domain.exception.RequestException;
import com.example.plaza_comidas.domain.model.Usuario;
import com.example.plaza_comidas.domain.spi.IUsuarioPersistencePort;
import com.example.plaza_comidas.domain.util.UtilFechaHora;
import com.example.plaza_comidas.domain.util.UtilNumeros;
import org.mindrot.jbcrypt.BCrypt;

import java.util.List;

public class UsuarioUseCase implements IUsuarioServicePort {

    private final IUsuarioPersistencePort usuarioPersistencePort;

    public UsuarioUseCase(IUsuarioPersistencePort usuarioPersistencePort) {
        this.usuarioPersistencePort = usuarioPersistencePort;
    }

    @Override
    public void saveUsuario(Usuario usuario) {
        //Encriptar la clave con bcrypt
        usuario.setClave(BCrypt.hashpw(usuario.getClave(), BCrypt.gensalt()));

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
            throw new RequestException("001", "El numero de documento es incorrecto");
        }

        //validar que el usuario sea mayor de edad
        int adult = 18;
        if (usuario.getFechaNacimiento() == null || UtilFechaHora.calcularEdad(usuario.getFechaNacimiento()) < adult) {
            throw new RequestException("002", "El usuario no es mayor de edad");
        }
    }

    @Override
    public List<Usuario> getAllUsuario() {
        return usuarioPersistencePort.getAllUsuario();
    }

    @Override
    public Usuario getUsuario(String numeroDocumento) {
        return usuarioPersistencePort.getUsuario(numeroDocumento);
    }
}
