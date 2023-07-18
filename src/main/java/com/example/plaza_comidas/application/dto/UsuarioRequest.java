package com.example.plaza_comidas.application.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UsuarioRequest {
    @NotNull(message = "El campo nombre es requerido")
    private String nombre;
    @NotBlank(message = "El campo apellido es requerido")
    private String apellido;
    @NotNull(message = "El campo numero de documento es requerido")
    private String numeroDocumento;
    @NotNull(message = "El campo celular es requerido")
    @Size(max = 13)
    private String celular;
    @NotNull(message = "El campo fecha de nacimiento es requerido")
    private LocalDate fechaNacimiento;
    @NotNull(message = "El campo correo es requerido")
    @Email(message = "El correo no tiene una estructura valida")
    private String correo;
    @NotNull(message = "El campo clave es requerido")
    private String clave;
    private String nombreRol;
    private String descripcionRol;
}
