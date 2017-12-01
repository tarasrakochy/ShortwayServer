package com.taras.shortway.server.controller;

import com.taras.shortway.server.entity.Trip;
import com.taras.shortway.server.entity.User;
import com.taras.shortway.server.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/trips")
public class TripController {

    @Autowired
    private TripService tripService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Trip getTripById(@PathVariable int id) {
        return tripService.getTripById(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Trip> getTrips() {
        return tripService.getTrips();
    }

    @RequestMapping(value = "/{id}/passengers", method = RequestMethod.GET)
    public List<User> getPassengersForTrip(@PathVariable int id) {
        return tripService.getPassengersForTrip(id);
    }

    @RequestMapping(value = "/{id}/driver", method = RequestMethod.GET)
    public User getDriverForTrip(@PathVariable int id) {
        return tripService.getDriverForTrip(id);
    }

}
