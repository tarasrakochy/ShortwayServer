package com.taras.shortway.server.controller;

import com.taras.shortway.server.entity.User;
import com.taras.shortway.server.service.LoginPassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/loginpass")
public class LoginPassController {

    @Autowired
    private LoginPassService loginPassService;

    @RequestMapping(method = RequestMethod.GET)
    public User logInUser(@RequestParam String login, @RequestParam String password) {
        return loginPassService.loginUser(login, password);
    }
}
