package com.sprint.OnlineShoppingApplication.Service;

import com.sprint.OnlineShoppingApplication.Dto.OrdersDto;
import com.sprint.OnlineShoppingApplication.Exception.AddressNotFoundException;
import com.sprint.OnlineShoppingApplication.Exception.CustomerNotFoundException;
import com.sprint.OnlineShoppingApplication.Exception.ProductNotFoundException;
import com.sprint.OnlineShoppingApplication.model.Orders;

import java.time.LocalDate;
import java.util.List;

public interface OrderService {
    public Orders addOrder(OrdersDto odersDto) throws AddressNotFoundException, CustomerNotFoundException, ProductNotFoundException;
    public Orders updateOrders(Orders orders);
    public Orders removeOrders(Orders orders);
    public Orders viewOrders(Orders orders);
    public List<Orders> viewAllOrders(LocalDate date);
    public Orders viewAllOrdersByLocation(String loc);
    public Orders viewAllOrdersByUserId(Integer userId);

}
