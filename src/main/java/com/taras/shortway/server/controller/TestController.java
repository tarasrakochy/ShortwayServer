package com.taras.shortway.server.controller;

import com.taras.shortway.server.entity.Auto;
import com.taras.shortway.server.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@ResponseBody
public class TestController {

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public User get() {
        Auto auto = new Auto();
        auto.setId(1);
        auto.setBrand("Mazda");
        auto.setColor("Red");
        auto.setCountry("Japan");
        auto.setModel("RX-7");
        auto.setNumber("333");
        auto.setType("light");

        User user = new User();
        user.setAuto(auto);
        user.setEmail("email");
        user.setId(2);
        user.setPhone("47-232");
        return user;
    }
}
