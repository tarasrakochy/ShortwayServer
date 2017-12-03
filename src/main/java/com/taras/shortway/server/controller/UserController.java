package com.taras.shortway.server.controller;

import com.taras.shortway.server.entity.Trip;
import com.taras.shortway.server.entity.User;
import com.taras.shortway.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @RequestMapping(value = "/{id}/trips", method = RequestMethod.GET)
    public List<Trip> getTripsForUser(@PathVariable int id, @RequestParam boolean isDriver) {
        return userService.getTripsForUser(id, isDriver);
    }

    @RequestMapping(value = "/newuser", method=RequestMethod.POST)
    public boolean addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.PUT)
    public boolean editUser(@RequestBody User user) {
        return userService.editUser(user);
    }
}
