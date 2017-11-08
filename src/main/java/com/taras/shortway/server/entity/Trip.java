package com.taras.shortway.server.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Trip {
    private int id;
    private String from;
    private String to;
    private Date date;
    private Date time;
}
