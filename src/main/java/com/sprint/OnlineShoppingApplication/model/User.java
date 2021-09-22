package com.sprint.OnlineShoppingApplication.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
//@NoArgsConstructor
@Table(name = "User_type")
public class User {
    @Id
    private String userId;
    private String Password;
    private String role;

    @OneToOne(targetEntity = Customer.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "userId_fk", referencedColumnName = "customerId")
    @MapsId
    private Customer customer;

}
