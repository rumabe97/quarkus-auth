package com.lemon.auth.content.user.adapter.rest.dto.in;

import com.lemon.auth.shared.password.validator.ValidationUserDto;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@ValidationUserDto
public class UserInDto {
    @NotBlank(message = "Name can not be empty")
    @Size(min = 1, max = 50, message = "Name must be between 1 and 50 characters")
    private String name;
    @PastOrPresent(message = "The birth date must be in the past or present")
    private Date birthDate;
    @NotBlank
    @Email(message = "Invalid email format")
    private String email;
    private Integer phone;
    @Digits(integer = 5, fraction = 0, message = "Country code must be between 1 and 3 characters")
    private Integer countryCode;
    private String password;
    @NotBlank
    @Size(min = 1, max = 20, message = "Username must be between 1 and 20 characters")
    @Pattern(regexp = "^[a-zA-Z0-9_-]*$", message = "Username can only contain letters, numbers, underscores, and hyphens")
    private String userName;
}
