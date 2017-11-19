package com.taras.shortway.server.service;

import com.taras.shortway.server.entity.User;

public interface LoginPassService {
    User loginUser(String login, String password);
}
