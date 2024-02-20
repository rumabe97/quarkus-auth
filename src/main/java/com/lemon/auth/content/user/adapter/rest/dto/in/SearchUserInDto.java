package com.lemon.auth.content.user.adapter.rest.dto.in;

import com.lemon.auth.shared.search.SearchClass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SearchUserInDto {
    private String name;
    private Date birthDate;
    private String email;
    private Integer phone;
    private Integer countryCode;
}
