package com.example.user.services.domain.model;

public enum ERoles {
    ADMINISTRATOR(1L, "Administrator"),
    OWNER(2L, "OWNER"),
    EMPLOYEE(3L, "Employee"),
    CUSTOMER(4L, "Customer");

    private final Long id;

    private final String name;

    ERoles(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static String getRoleNameById(long id) {
        for (ERoles rol : ERoles.values()) {
            if (rol.getId().equals(id)) {
                return rol.name().toUpperCase();
            }
        }
        return null;
    }
}
