package com.example.march23.models;

public class LoginResponse {
    private String response;
    private Users users;

    public LoginResponse(String response, Users users) {
        this.response = response;
        this.users = users;
    }

    public String getResponse() {
        return response;
    }

    public Users getUsers() {
        return users;
    }
}
