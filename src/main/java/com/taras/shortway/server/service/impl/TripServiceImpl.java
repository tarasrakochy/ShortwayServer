package com.taras.shortway.server.service.impl;

import com.taras.shortway.server.entity.Trip;
import com.taras.shortway.server.repository.TripRepository;
import com.taras.shortway.server.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripServiceImpl implements TripService {

    @Autowired
    private TripRepository tripRepository;

    @Override
    public Trip getTripById(int id) {
        return tripRepository.findOne(id);
    }

    @Override
    public List<Trip> getTrips() {
        return tripRepository.findAll();
    }
}
