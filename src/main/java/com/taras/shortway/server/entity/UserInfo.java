package com.taras.shortway.server.entity;

import com.taras.shortway.server.entity.enums.Gender;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfo {
    private int id;
    private Gender gender;
    private String information;
    private int year;
}
