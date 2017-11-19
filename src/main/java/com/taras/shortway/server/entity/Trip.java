package com.taras.shortway.server.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.taras.shortway.server.customserializers.CustomUsersListSerializer;
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

    @Temporal(TemporalType.DATE)
    private Date date;

    @Temporal(TemporalType.TIME)
    private Date time;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_trip",
            joinColumns = @JoinColumn(name = "trip_id"),
            inverseJoinColumns = @JoinColumn(name = "passanger_id")
    )
    @JsonSerialize(using = CustomUsersListSerializer.class)
    private List<User> passangers = new ArrayList<>();

    @OneToOne
    private User driver;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "transitional")
    @Column(name = "point")
    private List<String> transitionals = new ArrayList<>();
}
