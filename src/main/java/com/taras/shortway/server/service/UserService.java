package com.taras.shortway.server.service;

import com.taras.shortway.server.entity.User;

public interface UserService {
    User getUserByLoginAndPass(String login, String password);
}
