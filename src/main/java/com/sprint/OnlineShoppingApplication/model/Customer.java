package com.sprint.OnlineShoppingApplication.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
//@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String customerId;
    private String firstName;
    private String lastName;
    private String mobileNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addressId_fk", referencedColumnName = "addressId")
    private Address address;


    private String email;
}
