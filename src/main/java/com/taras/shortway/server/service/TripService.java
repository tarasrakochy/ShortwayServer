package com.taras.shortway.server.service;

import com.taras.shortway.server.entity.Trip;
import com.taras.shortway.server.entity.User;

import java.util.List;

public interface TripService {
    Trip getTripById(int id);

    List<Trip> getTrips();

    List<User> getPassengersForTrip(int id);

    User getDriverForTrip(int id);
}
