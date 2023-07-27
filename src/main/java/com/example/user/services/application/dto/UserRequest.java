package com.example.user.services.application.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    private LocalDate birthDate;
    @NotBlank(message = "The email field is required")
    @Email(message = "The email doesn't have a valid structure")
    private String email;
    @NotNull(message = "The password field is required")
    private String password;
    private Long roleId;
}
