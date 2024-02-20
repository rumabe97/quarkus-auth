package com.lemon.auth.content.user.adapter.rest.dto.out;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserOutDto {
    private Long id;
    private String name;
    private Date birthDate;
    private String email;
    private Integer phone;
    private Integer countryCode;
    private String userName;
}
