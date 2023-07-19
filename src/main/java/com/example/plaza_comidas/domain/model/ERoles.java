package com.example.plaza_comidas.domain.model;

public enum ERoles {
    ADMINISTRADOR(1L, "Administrador"),
    PROPIETARIO(2L, "Propietario"),
    EMPLEADO(3L, "Empleado"),
    CLIENTE(4L, "Cliente");

    private final Long id;

    private final String nombre;

    ERoles(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}
