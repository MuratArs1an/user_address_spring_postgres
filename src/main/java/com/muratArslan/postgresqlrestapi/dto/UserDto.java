package com.muratArslan.postgresqlrestapi.dto;


import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private int id;
    private String name;
    private String surname;
    private List<String> addressList;
}
