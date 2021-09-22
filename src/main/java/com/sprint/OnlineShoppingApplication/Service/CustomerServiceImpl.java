package com.sprint.OnlineShoppingApplication.Service;

import com.sprint.OnlineShoppingApplication.Repository.CustomerRepository;
import com.sprint.OnlineShoppingApplication.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {


    private CustomerRepository customerRepository;
    @Override
    public Customer addCustomer(Customer cust) {
        customerRepository.save(cust);
        return cust;
    }

    @Override
    public Customer updatCustomer(Customer cust) {
        return null;
    }

    @Override
    public Customer removeCustomer(Customer cust) {
        customerRepository.delete(cust);
        return cust;
    }

    @Override
    public Customer viewCustomer(Customer cust) {
        return null;
    }

    @Override
    public List<Customer> viewAllCustomer(String location) {
        return null;
    }
}
