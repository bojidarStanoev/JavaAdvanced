package com.example.json_demo.services;

import com.example.json_demo.model.Entity.User;

import java.io.IOException;

public interface UserService {
    void seedUser() throws IOException;
    User findRandomUser();
}
