package com.taras.shortway.server.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Auto {
    private int id;
    private String country;
    private String number;
    private String brand;
    private String type;
    private String model;
    private String color;
    private byte[] photo;
}
