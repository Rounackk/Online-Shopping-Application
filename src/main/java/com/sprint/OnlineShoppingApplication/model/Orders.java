package com.sprint.OnlineShoppingApplication.model;

import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Entity
//@NoArgsConstructor
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String orderId;
    private String orderStatus;
    private LocalDate orderDate;

    @OneToOne(targetEntity = Address.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "addressId_fk", referencedColumnName = "addressId")
    private Address address;

    @OneToOne(targetEntity = Customer.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "customerId_fk", referencedColumnName = "customerId")
    private Customer customer;


    @ManyToMany
    private List<Product> products;
}
