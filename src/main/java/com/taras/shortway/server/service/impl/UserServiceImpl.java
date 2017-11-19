package com.taras.shortway.server.service.impl;

import com.taras.shortway.server.entity.LoginPass;
import com.taras.shortway.server.entity.User;
import com.taras.shortway.server.repository.UserRepository;
import com.taras.shortway.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserByLoginAndPass(String login, String password) {
        List<User> users = userRepository.findAll();
        for (User user : users) {
            LoginPass loginPass = user.getLoginPass();
            if (login.equals(loginPass.getLogin())
                    && password.equals(loginPass.getPassword())) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findOne(id);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
