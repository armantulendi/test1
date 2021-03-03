package com.example.securedemo.model;

public enum Permission {
    SOTRUDNIKI_READ("sotrudniki:read"),
    SOTRUDNIKI_WRITE("sotrudniki:write");

    private final String permission;
    Permission(String permission) {
        this.permission=permission;
    }

    public String getPermission() {
        return permission;
    }
}
