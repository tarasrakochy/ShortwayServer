package com.taras.shortway.server.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "transitional")
@Getter
@Setter
@NoArgsConstructor
public class Transitional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String point;

    @ManyToOne
    private Trip trip;
}
