package com.lemon.auth.content.user.adapter.persistence.entity;

import com.lemon.auth.config.CustomPasswordProvider;
import io.quarkus.security.jpa.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
@UserDefinition
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "birthDate")
    private Date birthDate;

    @Column(name = "email")
    @NotNull
    private String email;

    @Column(name = "phone")
    private Integer phone;

    @Column(name = "countryCode")
    private Integer countryCode;

    @Column(name = "password")
    @Password(value = PasswordType.CUSTOM, provider = CustomPasswordProvider.class)
    private String password;

    @Column(name = "userName")
    @Username
    private String userName;

    @Roles
    public String role;
}
