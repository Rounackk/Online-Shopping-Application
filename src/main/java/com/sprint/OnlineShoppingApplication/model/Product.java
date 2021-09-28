package com.sprint.OnlineShoppingApplication.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer productId;
    private String productName;
    private double price;
    private String color;
    private String dimension;
    private String specification;
    private String manufacturer;
    private int quantity;

    @OneToOne
    @JoinColumn(name = "catId_fk", referencedColumnName = "catId")
    private Category category;

    /*@ManyToMany
    private List<Orders> orders;*/


}
