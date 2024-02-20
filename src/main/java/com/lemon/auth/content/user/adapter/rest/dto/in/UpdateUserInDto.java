package com.lemon.auth.content.user.adapter.rest.dto.in;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UpdateUserInDto {
    private String name;
    private Date birthDate;
    private String email;
    private Integer phone;
    private Integer countryCode;
    private String userName;
}
