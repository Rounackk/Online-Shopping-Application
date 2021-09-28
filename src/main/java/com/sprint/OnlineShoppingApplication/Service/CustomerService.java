package com.sprint.OnlineShoppingApplication.Service;

import com.sprint.OnlineShoppingApplication.Dto.CustomerDto;
import com.sprint.OnlineShoppingApplication.Exception.AddressNotFoundException;
import com.sprint.OnlineShoppingApplication.Exception.CustomerNotFoundException;
import com.sprint.OnlineShoppingApplication.model.Customer;

import java.util.List;

public interface CustomerService {
    public Customer addCustomer(CustomerDto cust);

    public Customer updateCustomer(CustomerDto cust) throws CustomerNotFoundException, AddressNotFoundException;


    public Integer removeCustomer(Integer customerId) throws CustomerNotFoundException;

    public Customer viewCustomer(Integer customerId);

    public List<Customer> viewAllCustomer(String location) throws CustomerNotFoundException;
}
