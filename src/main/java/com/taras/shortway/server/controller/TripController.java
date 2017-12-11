package com.taras.shortway.server.controller;

import com.taras.shortway.server.entity.Trip;
import com.taras.shortway.server.entity.User;
import com.taras.shortway.server.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/suitable", method = RequestMethod.POST)
    public List<Trip> getTripsForConditions(@RequestBody Trip trip, @RequestParam int maxWaitTime) {
        return tripService.getTripsForCondition(trip, maxWaitTime);
    }

    @RequestMapping(value = "/newtrip", method = RequestMethod.POST)
    public boolean addTrip(@RequestBody Trip trip, @RequestParam int userId) {
        return tripService.addTrip(trip, userId);
    }

    @RequestMapping(value = "/{id}/accept", method = RequestMethod.PUT)
    public boolean acceptTrip(@RequestParam int userId, @PathVariable int id, @RequestParam String fromPoint, @RequestParam String toPoint) {
        return tripService.acceptTrip(userId, id, fromPoint, toPoint);
    }

}
