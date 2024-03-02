package com.lemon.auth.content.user.adapter.rest.dto.out;

import com.lemon.auth.content.rol.adapter.rest.dto.out.RolOutDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

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
    private List<RolOutDto> roles;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
