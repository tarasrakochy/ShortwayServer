package com.taras.shortway.server.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private int id;
    private byte[] avatar;
    private String phone;
    private String email;
}
