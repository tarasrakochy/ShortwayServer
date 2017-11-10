package com.taras.shortway.server.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "trip")
@Getter
@Setter
@NoArgsConstructor
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String from;
    private String to;
    private Date date;
    private Date time;

    @OneToMany
    private List<User> users = new ArrayList<>();

    @OneToMany(cascade=CascadeType.ALL, mappedBy = "trip")
    private List<Transitional> transitionals = new ArrayList<>();
}
