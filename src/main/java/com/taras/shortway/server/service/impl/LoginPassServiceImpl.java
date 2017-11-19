package com.taras.shortway.server.service.impl;

import com.taras.shortway.server.entity.User;
import com.taras.shortway.server.repository.LoginPassRepository;
import com.taras.shortway.server.service.LoginPassService;
import com.taras.shortway.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginPassServiceImpl implements LoginPassService {

    @Autowired
    private LoginPassRepository loginPassRepository;

    @Autowired
    private UserService userService;

    @Override
    public User loginUser(String login, String password) {
        return userService.getUserByLoginAndPass(login, password);
    }
}
