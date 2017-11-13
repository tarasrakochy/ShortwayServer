package com.taras.shortway.server.repository;

import com.taras.shortway.server.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip, Integer> {

}
