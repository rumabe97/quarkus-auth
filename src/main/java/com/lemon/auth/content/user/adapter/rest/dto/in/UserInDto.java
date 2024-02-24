package com.lemon.auth.content.user.adapter.rest.dto.in;

import com.lemon.auth.shared.password.validator.ValidationUserDto;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@ValidationUserDto
public class UserInDto {
    private String name;
    private Date birthDate;
    private String email;
    private Integer phone;
    private Integer countryCode;
    private String password;
    private String userName;
}
