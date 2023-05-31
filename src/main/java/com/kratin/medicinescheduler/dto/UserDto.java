package com.kratin.medicinescheduler.dto;

import javax.validation.constraints.NotEmpty;

public class UserDto {
    private int id;
    private @NotEmpty(
            message = "username should not be empty"
    ) String username;
    private @NotEmpty(
            message = "Password should not be empty"
    ) String password;
    private @NotEmpty(
            message = "email should not be empty"
    ) String email;

    public UserDto() {
    }

    public UserDto(int id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return "Userdto{id=" + this.id + ", username='" + this.username + "', password='" + this.password + "', email='" + this.email + "'}";
    }
}