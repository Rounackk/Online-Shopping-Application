package com.sprint.OnlineShoppingApplication.Controller;

import com.sprint.OnlineShoppingApplication.Dto.CustomerDto;
import com.sprint.OnlineShoppingApplication.Exception.AddressNotFoundException;
import com.sprint.OnlineShoppingApplication.Exception.CustomerNotFoundException;
import com.sprint.OnlineShoppingApplication.Exception.ValidateCustomer;
import com.sprint.OnlineShoppingApplication.Service.CustomerService;
import com.sprint.OnlineShoppingApplication.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/createcustomer")
    public ResponseEntity<Customer> addCustomer(@Valid @RequestBody CustomerDto customerDto, BindingResult br) throws ValidateCustomer {
        if(br.hasErrors())
        {
            throw new ValidateCustomer(br.getFieldErrors());
        }
        Customer cust1 = customerService.addCustomer(customerDto);
        return new ResponseEntity<>(cust1, HttpStatus.CREATED);
    }

    @DeleteMapping("/deletecustomer/{customerId}")
    public ResponseEntity<String> removeCustomer(@PathVariable int customerId) throws CustomerNotFoundException {
        customerService.removeCustomer(customerId);

        return new ResponseEntity<>("Deleted Customer customerId "+customerId, HttpStatus.OK);
    }

    @GetMapping("/viewcustomerbyid/{customerId}")
    public ResponseEntity<Customer> viewCustomer(@PathVariable int customerId){
        return new ResponseEntity<>(customerService.viewCustomer(customerId), HttpStatus.FOUND);
    }

    @PutMapping("/updatecustomer")
    public ResponseEntity<Customer> updateCustomer(@RequestBody CustomerDto customerDto) throws CustomerNotFoundException, AddressNotFoundException {
        Customer customer = customerService.updateCustomer(customerDto);
        return  new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @GetMapping("/viewbylocation/{city}")
    public List<Customer> viewCustomerByLocation(@PathVariable("city") String location) throws CustomerNotFoundException {
        List<Customer> customerList = customerService.viewAllCustomer(location);
        return customerList;
    }
}
