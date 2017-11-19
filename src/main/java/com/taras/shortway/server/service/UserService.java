package com.taras.shortway.server.service;

import com.taras.shortway.server.entity.User;

import java.util.List;

public interface UserService {
    User getUserByLoginAndPass(String login, String password);

    User getUserById(int id);

    List<User> getUsers();
}
