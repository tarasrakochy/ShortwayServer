package com.taras.shortway.server.controller;

import com.taras.shortway.server.entity.Auto;
import com.taras.shortway.server.entity.Trip;
import com.taras.shortway.server.service.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/autos")
public class AutoController {

    @Autowired
    private AutoService autoService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Auto getAutoById(@PathVariable int id) {
        return autoService.getAutoById(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Auto> getAutos() {
        return autoService.getAutos();
    }
}
