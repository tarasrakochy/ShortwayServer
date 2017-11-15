package com.taras.shortway.server.service.impl;

import com.taras.shortway.server.repository.TripRepository;
import com.taras.shortway.server.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripServiceImpl implements TripService {

    @Autowired
    private TripRepository tripRepository;
}
