package com.taras.shortway.server.service.impl;

import com.taras.shortway.server.entity.Trip;
import com.taras.shortway.server.entity.User;
import com.taras.shortway.server.entity.UserTripRelation;
import com.taras.shortway.server.entity.enums.UserStatus;
import com.taras.shortway.server.repository.UserTripRelationRepository;
import com.taras.shortway.server.service.TripService;
import com.taras.shortway.server.service.UserService;
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

    @Autowired
    private UserService userService;

    @Autowired
    private TripService tripService;

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

    @Override
    public List<User> getPassengersForTrip(int id) {
        final List<UserTripRelation> relations = userTripRelationRepository.findAll();
        final List<UserTripRelation> relationsWithTrip = relations
                .stream()
                .filter(r -> r.getTrip().getId() == id)
                .filter(r -> r.getUserStatus() == UserStatus.PASSENGER)
                .collect(Collectors.toList());
        List<User> users = new ArrayList<>();
        for (UserTripRelation userTripRelation : relationsWithTrip) {
            users.add(userTripRelation.getUser());
        }
        return users;
    }

    @Override
    public User getDriverForTrip(int id) {
        final List<UserTripRelation> relations = userTripRelationRepository.findAll();
        for (UserTripRelation relation : relations) {
            if (relation.getTrip().getId() == id && relation.getUserStatus() == UserStatus.DRIVER) {
                return relation.getUser();
            }
        }
        return null;
    }

    @Override
    public boolean addTrip(Trip trip, int userId) {
        UserTripRelation relation = new UserTripRelation();
        relation.setFromPoint(trip.getFromPoint());
        relation.setToPoint(trip.getToPoint());
        relation.setUser(userService.getUserById(userId));
        relation.setUserStatus(UserStatus.DRIVER);
        relation.setTrip(trip);
        UserTripRelation userTripRelation = userTripRelationRepository.save(relation);
        return userTripRelation.getId() != 0;
    }

    @Override
    public boolean acceptTrip(int userId, int tripId, String fromPoint, String toPoint) {
        UserTripRelation relation = new UserTripRelation();
        relation.setFromPoint(fromPoint);
        relation.setToPoint(toPoint);
        relation.setUser(userService.getUserById(userId));
        relation.setUserStatus(UserStatus.PASSENGER);
        relation.setTrip(tripService.getTripById(tripId));
        UserTripRelation userTripRelation = userTripRelationRepository.save(relation);
        return userTripRelation.getId() != 0;
    }
}
