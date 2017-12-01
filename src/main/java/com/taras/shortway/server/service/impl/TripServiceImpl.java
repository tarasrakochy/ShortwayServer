package com.taras.shortway.server.service.impl;

import com.taras.shortway.server.entity.Trip;
import com.taras.shortway.server.entity.User;
import com.taras.shortway.server.repository.TripRepository;
import com.taras.shortway.server.service.TripService;
import com.taras.shortway.server.service.UserTripRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripServiceImpl implements TripService {

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private UserTripRelationService userTripRelationService;

    @Override
    public Trip getTripById(int id) {
        return tripRepository.findOne(id);
    }

    @Override
    public List<Trip> getTrips() {
        return tripRepository.findAll();
    }

    @Override
    public List<User> getPassengersForTrip(int id) {
        return userTripRelationService.getPassengersForTrip(id);
    }

    @Override
    public User getDriverForTrip(int id) {
        return userTripRelationService.getDriverForTrip(id);
    }
}
