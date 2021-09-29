package com.sprint.OnlineShoppingApplication.Dto;

import lombok.Data;

@Data
public class ProductDto {
    private Integer productId;
    private  String productName;
    private double price;
    private String color;
    private String dimension;
    private String specification;
    private String manufacturer;
    private int quantity;
}
