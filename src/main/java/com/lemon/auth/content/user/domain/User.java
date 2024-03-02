package com.lemon.auth.content.user.domain;

import com.lemon.auth.content.rol.domain.Rol;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

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
    private List<Rol> roles;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
