package com.taras.shortway.server.service;

import com.taras.shortway.server.entity.Trip;
import com.taras.shortway.server.entity.User;

import java.util.List;

public interface UserTripRelationService {
    List<Trip> getTripsForUser(int id, boolean isDriver);

    List<User> getPassengersForTrip(int id);

    User getDriverForTrip(int id);

    boolean addTrip(Trip trip, int userId);

    boolean acceptTrip(int userId, int tripId, String fromPoint, String toPoint);
}
