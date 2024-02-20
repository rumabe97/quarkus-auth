package com.lemon.auth.content.user.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String name;
    private Date birthDate;
    private String email;
    private Integer phone;
    private Integer countryCode;
    private String password;
    private String userName;
}
