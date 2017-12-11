package com.taras.shortway.server.service;

import com.taras.shortway.server.entity.Trip;
import com.taras.shortway.server.entity.User;

import java.util.List;

public interface TripService {
    Trip getTripById(int id);

    List<Trip> getTrips();

    List<User> getPassengersForTrip(int id);

    User getDriverForTrip(int id);

    List<Trip> getTripsForCondition(Trip trip, int maxWaitTime);

    boolean addTrip(Trip trip, int userId);

    boolean acceptTrip(int userId, int tripId, String fromPoint, String toPoint);
}
