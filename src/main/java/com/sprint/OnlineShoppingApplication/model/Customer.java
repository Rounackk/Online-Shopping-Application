package com.sprint.OnlineShoppingApplication.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer customerId;
    private String firstName;
    private String lastName;
    private String mobileNumber;


    @OneToOne
    @JoinColumn(name = "addressId_fk", referencedColumnName = "addressId")
    private Address address;


    private String email;
}
