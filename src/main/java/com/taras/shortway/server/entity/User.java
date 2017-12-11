package com.taras.shortway.server.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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

    private String name;

    private String surname;

    private String phone;

    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    private LoginPass loginPass;

    @OneToOne(cascade = CascadeType.ALL)
    private UserInfo userInfo;
}
