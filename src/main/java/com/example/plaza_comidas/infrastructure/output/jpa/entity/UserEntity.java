package com.example.plaza_comidas.infrastructure.output.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String documentNumber;
    private String cellPhone;
    private LocalDate birthDate;
    private String email;
    private String password;
    private Long roleId;
}
