package com.taras.shortway.server.service.impl;

import com.google.maps.*;
import com.google.maps.errors.ApiException;
import com.google.maps.model.*;
import com.taras.shortway.server.entity.Trip;
import com.taras.shortway.server.entity.User;
import com.taras.shortway.server.repository.TripRepository;
import com.taras.shortway.server.service.TripService;
import com.taras.shortway.server.service.UserTripRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TripServiceImpl implements TripService {

    private static final String API_KEY = "AIzaSyA6lK_fbfSoUkkwa5RcmoL8ZkoZNjrJLe4";

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

    @Override
    public List<Trip> getTripsForCondition(Trip trip) {
        List<Trip> trips = tripRepository.findAll();
        List<Trip> tripsAfterCurrentData = trips
                .stream()
                .filter(t -> t.getDate().compareTo(new Date()) >= 0)
                .filter(t -> t.getPassengersMaxCount() > userTripRelationService.getPassengersForTrip(t.getId()).size())
                .collect(Collectors.toList());

        return getSuitableTrips(tripsAfterCurrentData, trip);
    }

    @Override
    public boolean addTrip(Trip trip, int userId) {
        return userTripRelationService.addTrip(trip, userId);
    }

    @Override
    public boolean acceptTrip(int userId, int tripId, String fromPoint, String toPoint) {
        return userTripRelationService.acceptTrip(userId, tripId, fromPoint, toPoint);
    }


    private List<Trip> getSuitableTrips(List<Trip> tripsAfterCurrentData, Trip conditionTrip) {

        List<Trip> suitableTrips = new ArrayList<>();

        LatLng fromPoint = convertStringToPoint(conditionTrip.getFromPoint());
        LatLng toPoint = convertStringToPoint(conditionTrip.getToPoint());

        try {
            for (Trip trip : tripsAfterCurrentData) {

                LatLng tripFromPoint = convertStringToPoint(trip.getFromPoint());
                LatLng tripToPoint = convertStringToPoint(trip.getToPoint());
                LatLng[] transitionalPoints = convertStringsToPoints(trip.getTransitionals());

                DirectionsApiRequest directionsApiRequest = DirectionsApi
                        .newRequest(new GeoApiContext.Builder()
                                .apiKey(API_KEY)
                                .build())
                        .origin(tripFromPoint)
                        .destination(tripToPoint)
                        .waypoints(transitionalPoints)
                        .optimizeWaypoints(true)
                        .mode(TravelMode.DRIVING);
                DirectionsResult directionsResult = directionsApiRequest.await();
                LatLng[] routePoints = directionsResult.routes[0].overviewPolyline.decodePath().stream().toArray(LatLng[]::new);

                DistanceMatrixElement[] elements = getDistanceMatrixElementsForPoint(fromPoint, routePoints);

                boolean suitable = false;

                for (DistanceMatrixElement element : elements) {
                    if (element.distance.inMeters <= 500) {
                        suitable = true;
                        break;
                    }
                }

                if (!suitable) {
                    continue;
                }

                elements = getDistanceMatrixElementsForPoint(toPoint, routePoints);
                for (DistanceMatrixElement element : elements) {
                    if (element.distance.inMeters <= 500) {
                        suitableTrips.add(trip);
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return suitableTrips;
    }


    private LatLng convertStringToPoint(String pointString) {
        String[] pointStrings = pointString.split(",");
        double lat = Double.parseDouble(pointStrings[0]);
        double lng = Double.parseDouble(pointStrings[1]);
        return new LatLng(lat, lng);
    }

    private LatLng[] convertStringsToPoints(List<String> pointsStrings) {
        LatLng[] latLngs = new LatLng[pointsStrings.size()];
        for (int i = 0; i < pointsStrings.size(); i++) {
            latLngs[i] = convertStringToPoint(pointsStrings.get(i));
        }
        return latLngs;
    }

    private DistanceMatrixElement[] getDistanceMatrixElementsForPoint(LatLng point, LatLng[] routePoints) throws InterruptedException, ApiException, IOException {
        DistanceMatrixApiRequest distanceMatrixApiRequest = DistanceMatrixApi
                .newRequest(new GeoApiContext.Builder()
                        .apiKey(API_KEY)
                        .build())
                .origins(point)
                .destinations(routePoints)
                .mode(TravelMode.WALKING);
        DistanceMatrix distanceMatrix = distanceMatrixApiRequest.await();
        return distanceMatrix.rows[0].elements;
    }
}
