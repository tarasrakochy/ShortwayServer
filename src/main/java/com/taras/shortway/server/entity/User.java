package com.taras.shortway.server.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.taras.shortway.server.customserializers.CustomTripsListSerializer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Lob
    private byte[] avatar;

    private String phone;
    private String email;

    @OneToOne
    private LoginPass loginPass;

    @OneToOne
    private Auto auto;

    @OneToOne
    private UserInfo userInfo;

    @ManyToMany(mappedBy = "passangers", fetch = FetchType.EAGER)
    @JsonSerialize(using = CustomTripsListSerializer.class)
    private List<Trip> trips = new ArrayList<>();
}
