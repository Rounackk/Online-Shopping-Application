package com.sprint.OnlineShoppingApplication.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "User_type")
public class User {
    @Id
    private Integer userId;
    private String password;
    private String role;

    @OneToOne(targetEntity = Customer.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "userId_fk", referencedColumnName = "customerId")
    @MapsId
    private Customer customer;

}
