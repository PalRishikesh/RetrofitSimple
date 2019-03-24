package com.example.march23.models;

import java.util.List;

public class UsersAllResponse {
    private String response;
    private List<Users> users;

    public UsersAllResponse(String response, List<Users> users) {
        this.response = response;
        this.users = users;
    }

    public String getResponse() {
        return response;
    }

    public List<Users> getUsers() {
        return users;
    }
}
