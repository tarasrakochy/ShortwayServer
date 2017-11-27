package com.taras.shortway.server.service;

import com.taras.shortway.server.entity.Trip;

import java.util.List;

public interface UserTripRelationService {
    List<Trip> getTripsForUser(int id, boolean isDriver);
}
