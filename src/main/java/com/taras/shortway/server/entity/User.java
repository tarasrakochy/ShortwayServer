package com.taras.shortway.server.entity;

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

    @OneToOne(fetch = FetchType.LAZY)
    private LoginPass loginPass;

    @OneToOne(fetch = FetchType.LAZY)
    private Auto auto;

    @OneToOne(fetch = FetchType.LAZY)
    private UserInfo userInfo;

    @ManyToMany(mappedBy = "passangers")
    private List<Trip> trips = new ArrayList<>();
}
