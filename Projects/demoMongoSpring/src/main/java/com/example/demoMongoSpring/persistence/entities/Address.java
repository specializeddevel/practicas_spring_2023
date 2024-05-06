package com.example.demoMongoSpring.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Address {
    private String country;
    private String postCode;
    private String city;
    private String doorColor;
}
