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
    @NotBlank(message = "Name field is required")
    private String nombre;
    @NotBlank(message = "Last name field is required")
    private String apellido;
    @NotBlank(message = "Number document field is required")
    private String numeroDocumento;
    @NotBlank(message = "Number phone field is required")
    @Size(max = 13)
    private String celular;
    @NotNull(message = "The date of birth field is required")
    private LocalDate fechaNacimiento;
    @NotBlank(message = "The email field is required")
    @Email(message = "The email doesn't have a valid structure")
    private String correo;
    @NotNull(message = "The password field is required")
    private String clave;
    private String nombreRol;
    private String descripcionRol;
}
