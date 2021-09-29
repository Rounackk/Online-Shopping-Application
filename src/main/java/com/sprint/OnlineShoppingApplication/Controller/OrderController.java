package com.sprint.OnlineShoppingApplication.Controller;

import com.sprint.OnlineShoppingApplication.Service.OrderService;
import com.sprint.OnlineShoppingApplication.model.Orders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/Order")
public class OrderController {
    @PostMapping("/addorder")
    public Orders addOrder(@RequestBody Orders orders){
  //      Orders orders1= OrderService.addOrder(orders);
        return orders;
    }
}
