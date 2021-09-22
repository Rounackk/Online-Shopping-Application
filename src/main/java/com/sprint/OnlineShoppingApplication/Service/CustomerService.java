package com.sprint.OnlineShoppingApplication.Service;

import com.sprint.OnlineShoppingApplication.model.Customer;

import java.util.List;

public interface CustomerService {
    public Customer addCustomer(Customer cust);

    public Customer updatCustomer(Customer cust);

    public Customer removeCustomer(Customer cust);

    public Customer viewCustomer(Customer cust);

    public List<Customer> viewAllCustomer(String location);
}
