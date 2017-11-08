package com.taras.shortway.server.entity;

import com.taras.shortway.server.entity.enums.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TripStatus {
    private int userId;
    private int tripId;
    private Status status;
}
