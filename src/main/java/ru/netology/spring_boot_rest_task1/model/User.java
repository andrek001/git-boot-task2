package ru.netology.spring_boot_rest_task1.model;

import jakarta.validation.constraints.NotEmpty;

public class User {
    @NotEmpty
    private String user;
    @NotEmpty
    private String password;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
