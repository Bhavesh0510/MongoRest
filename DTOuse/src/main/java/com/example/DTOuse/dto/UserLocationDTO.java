package com.example.DTOuse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLocationDTO {
    private String userId;
    private String email;
    private String place;
    private double longitude;
    private double latitude;
}
