package com.sprint.OnlineShoppingApplication.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
//@NoArgsConstructor

public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int addressId;
    private String streetNo;
    private String buildingName;
    private String city;
    private String state;
    private String country;
    private String pincode;





}
