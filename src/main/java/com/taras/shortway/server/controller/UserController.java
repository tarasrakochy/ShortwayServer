package com.taras.shortway.server.controller;

import com.taras.shortway.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserController {

    @Autowired
    private UserService userService;
}
