package com.sprint.OnlineShoppingApplication.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Entity
@Data
//@NoArgsConstructor
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderId;
    private String orderStatus;
    private LocalDate orderDate;

    @OneToOne(targetEntity = Address.class)
    @JoinColumn(name = "addressId_fk", referencedColumnName = "addressId")
    private Address address;

    @OneToOne(targetEntity = Customer.class)
    @JoinColumn(name = "customerId_fk", referencedColumnName = "customerId")
    private Customer customer;


    @ManyToMany
    private List<Product> products;
}
