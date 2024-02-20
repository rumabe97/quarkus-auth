package com.lemon.auth.shared.search;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchClass {
    private String order;
    private Integer page;
    private Integer quantity;
}
