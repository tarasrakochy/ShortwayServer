package com.taras.shortway.server.service.impl;

import com.taras.shortway.server.repository.UserRepository;
import com.taras.shortway.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
}
