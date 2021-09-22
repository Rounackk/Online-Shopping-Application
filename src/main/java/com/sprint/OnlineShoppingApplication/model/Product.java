package com.sprint.OnlineShoppingApplication.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String productId;
    private String productName;
    private double price;
    private String color;
    private String dimension;
    private String specification;
    private String manufacturer;
    private int quantity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "catId_fk", referencedColumnName = "catId")
    private Category category;

    /*@ManyToMany
    private List<Orders> orders;*/


}
