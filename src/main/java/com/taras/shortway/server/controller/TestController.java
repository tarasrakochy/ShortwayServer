package com.taras.shortway.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
@ResponseBody
public class TestController {

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String get() {
        return "Hello, get";
    }
}
