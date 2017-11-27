package com.taras.shortway.server.service.impl;

import com.taras.shortway.server.entity.Trip;
import com.taras.shortway.server.entity.UserTripRelation;
import com.taras.shortway.server.entity.enums.UserStatus;
import com.taras.shortway.server.repository.UserTripRelationRepository;
import com.taras.shortway.server.service.UserTripRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserTripRelationServiceImpl implements UserTripRelationService {

    @Autowired
    private UserTripRelationRepository userTripRelationRepository;

    @Override
    public List<Trip> getTripsForUser(int id, boolean isDriver) {
        final List<UserTripRelation> relations = userTripRelationRepository.findAll();
        final List<UserTripRelation> relationsWithUser = relations
                .stream()
                .filter(r -> r.getUser().getId() == id)
                .filter(r -> r.getUserStatus() == (isDriver ? UserStatus.DRIVER : UserStatus.PASSENGER))
                .collect(Collectors.toList());
        List<Trip> trips = new ArrayList<>();
        for (UserTripRelation userTripRelation : relationsWithUser) {
            trips.add(userTripRelation.getTrip());
        }
        return trips;
    }
}
