package com.taras.shortway.server.entity;

import com.taras.shortway.server.entity.enums.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

//@Entity
//@Table(name = "trip_status")
@Getter
@Setter
@NoArgsConstructor
public class TripStatus {

    @EmbeddedId
    private TripStatusId id;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("userId")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("tripId")
    private Trip trip;

    @Enumerated(value = EnumType.STRING)
    private Status status;
}
