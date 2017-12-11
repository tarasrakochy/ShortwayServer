package com.taras.shortway.server.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "trips")
@Getter
@Setter
@NoArgsConstructor
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String fromPoint;
    private String toPoint;

    private int passengersMaxCount;

    private int price;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "transitional")
    @Column(name = "point")
    private List<String> transitionals = new ArrayList<>();
}
