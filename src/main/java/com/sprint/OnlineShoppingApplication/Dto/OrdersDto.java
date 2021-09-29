package com.sprint.OnlineShoppingApplication.Dto;

import com.sprint.OnlineShoppingApplication.model.Address;
import com.sprint.OnlineShoppingApplication.model.Customer;
import com.sprint.OnlineShoppingApplication.model.Product;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class OrdersDto {
    private Integer orderId;
    private String orderStatus;
    private LocalDate orderDate;
    private Integer addressId;
    private Integer customerId;
    private List<Integer> productIds;
}
