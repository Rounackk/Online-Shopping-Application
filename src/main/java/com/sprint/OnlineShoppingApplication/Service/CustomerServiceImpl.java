package com.sprint.OnlineShoppingApplication.Service;

import com.sprint.OnlineShoppingApplication.Dto.CustomerDto;
import com.sprint.OnlineShoppingApplication.Exception.AddressNotFoundException;
import com.sprint.OnlineShoppingApplication.Exception.CustomerNotFoundException;
import com.sprint.OnlineShoppingApplication.Repository.AddressRepository;
import com.sprint.OnlineShoppingApplication.Repository.CustomerRepository;
import com.sprint.OnlineShoppingApplication.Repository.UserRepository;
import com.sprint.OnlineShoppingApplication.model.Address;
import com.sprint.OnlineShoppingApplication.model.Customer;
import com.sprint.OnlineShoppingApplication.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {


    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Customer addCustomer(CustomerDto cust) {
        Customer customer = new Customer();
        customer.setFirstName(cust.getFirstName());
        customer.setLastName(cust.getLastName());
        Optional<Address> optionalAddress = addressRepository.findById(cust.getAddressId());
        customer.setAddress(optionalAddress.get());
        customer.setMobileNumber(cust.getMobileNumber());
        customer.setEmail(cust.getEmail());

        Customer customer1 = customerRepository.save(customer);
        customerRepository.flush(); // for commiting

        User user = new User();
        user.setPassword(cust.getPassword());
        user.setRole(cust.getRole());
        user.setCustomer(customer1);
        userRepository.save(user); //saving the data
        return customer1;
    }

    @Override
    public Customer updateCustomer(CustomerDto cust) throws CustomerNotFoundException, AddressNotFoundException {
        Customer customer = new Customer();
        Optional<Customer> optionalCustomer = customerRepository.findById(cust.getCustomerId());
        if(optionalCustomer.isPresent()){
            customer = optionalCustomer.get();
            customer.setFirstName(cust.getFirstName());
            customer.setLastName(cust.getLastName());
            customer.setMobileNumber(cust.getMobileNumber());
            customer.setEmail(cust.getEmail());
            Optional<Address> optionalAddress = addressRepository.findById(cust.getAddressId());
            if(!optionalAddress.isPresent()){
                throw new AddressNotFoundException();
            }
            customer.setAddress(optionalAddress.get());
            Customer c1 = customerRepository.save(customer);
            customerRepository.flush();
            return c1;
        }
        else
            throw new CustomerNotFoundException();

    }

    @Override
    public Integer removeCustomer(Integer customerId) throws CustomerNotFoundException {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        Optional<User> optionalUser = userRepository.findById(customerId);
        if(!optionalCustomer.isPresent()){
            throw new CustomerNotFoundException();
        }
        userRepository.delete(optionalUser.get());
        userRepository.flush();
        customerRepository.delete(optionalCustomer.get());

        return customerId;
    }

    @Override
    public Customer viewCustomer(Integer customerId) {
        Customer customer = null;
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if (optionalCustomer.isPresent())
            customer = optionalCustomer.get();
        return customer;
    }

    @Override
    public List<Customer> viewAllCustomer(String location) throws CustomerNotFoundException {
        List<Customer> customerList = customerRepository.findByLocation(location);
        if(customerList.isEmpty()){
            throw new CustomerNotFoundException("Customer not found in this location");
        }
        customerList.sort((c1, c2)->c1.getFirstName().compareTo(c2.getFirstName()));
        return customerList;
    }
}
