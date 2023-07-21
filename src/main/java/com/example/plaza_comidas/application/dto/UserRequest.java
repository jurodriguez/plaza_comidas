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
public class UserRequest {
    @NotBlank(message = "Name field is required")
    private String name;
    @NotBlank(message = "Last name field is required")
    private String lastName;
    @NotBlank(message = "Document number field is required")
    private String documentNumber;
    @NotBlank(message = "Number phone field is required")
    @Size(max = 13)
    private String cellPhone;
    @NotNull(message = "The birth date field is required")
    private LocalDate birthDate;
    @NotBlank(message = "The email field is required")
    @Email(message = "The email doesn't have a valid structure")
    private String email;
    @NotNull(message = "The password field is required")
    private String password;
    private String roleName;
    private String roleDescription;
}
