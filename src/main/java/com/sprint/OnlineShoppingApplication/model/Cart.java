package com.sprint.OnlineShoppingApplication.model;



import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String cartId;

    @OneToOne(targetEntity = Customer.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "customerId_fk", referencedColumnName = "customerId")
    private Customer customer;

    @ManyToMany
    private List<Product> products;
}
