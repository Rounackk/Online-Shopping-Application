package com.sprint.OnlineShoppingApplication.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
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

    @JsonIgnore
    @OneToOne(mappedBy = "address")
    private Customer customer;





}
