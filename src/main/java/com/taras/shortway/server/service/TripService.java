package com.taras.shortway.server.service;

import com.taras.shortway.server.entity.Trip;

import java.util.List;

public interface TripService {
    Trip getTripById(int id);

    List<Trip> getTrips();
}
