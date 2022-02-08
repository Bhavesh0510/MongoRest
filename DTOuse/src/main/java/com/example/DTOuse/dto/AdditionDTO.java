package com.example.DTOuse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdditionDTO {
    private String email;
    private String firstname;
    private String lastname;
    private String password;
    private String place;
    private String description;
    private double longitude;
    private double latitude;
}
