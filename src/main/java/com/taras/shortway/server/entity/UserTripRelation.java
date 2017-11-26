package com.taras.shortway.server.entity;

import com.taras.shortway.server.entity.enums.UserStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user_trip_relations")
@Getter
@Setter
@NoArgsConstructor
public class UserTripRelation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String fromPoint;

    private String toPoint;

    @Enumerated(value = EnumType.STRING)
    private UserStatus userStatus;

    @ManyToOne
    @JoinColumn
    private User user;

    @ManyToOne
    @JoinColumn
    private Trip trip;
}
