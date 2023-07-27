package com.example.user.services.domain.model;

public enum ERoles {
    ADMINISTRATOR(1L, "ADMINISTRATOR"),
    OWNER(2L, "OWNER"),
    EMPLOYEE(3L, "EMPLOYEE"),
    CUSTOMER(4L, "CUSTOMER");

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

    public static Long getIdByRoleName(String roleName) {
        for (ERoles rol : ERoles.values()) {
            if (rol.getName().equals(roleName)) {
                return rol.getId();
            }
        }
        return null;
    }
}
