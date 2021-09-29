package com.sprint.OnlineShoppingApplication.Service;

import com.sprint.OnlineShoppingApplication.Dto.OrdersDto;
import com.sprint.OnlineShoppingApplication.Exception.AddressNotFoundException;
import com.sprint.OnlineShoppingApplication.Exception.CustomerNotFoundException;
import com.sprint.OnlineShoppingApplication.Exception.ProductNotFoundException;
import com.sprint.OnlineShoppingApplication.Repository.AddressRepository;
import com.sprint.OnlineShoppingApplication.Repository.CustomerRepository;
import com.sprint.OnlineShoppingApplication.Repository.OrderRepository;
import com.sprint.OnlineShoppingApplication.Repository.ProductRepository;
import com.sprint.OnlineShoppingApplication.model.Address;
import com.sprint.OnlineShoppingApplication.model.Customer;
import com.sprint.OnlineShoppingApplication.model.Orders;
import com.sprint.OnlineShoppingApplication.model.Product;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderServiceImpl implements OrderService{

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public Orders addOrder(OrdersDto ordersDto) throws AddressNotFoundException, CustomerNotFoundException, ProductNotFoundException {
        Orders orders = new Orders();
        orders.setOrderDate(ordersDto.getOrderDate());
        orders.setOrderStatus(ordersDto.getOrderStatus());
        Optional<Address> optionalAddress = addressRepository.findById(ordersDto.getAddressId());
        if(!optionalAddress.isPresent()){
            throw new AddressNotFoundException("Wrong Address ID");
        }
        Address address = optionalAddress.get();
        orders.setAddress(address); //address is stored in orders


        Optional<Customer> optionalCustomer = customerRepository.findById(ordersDto.getCustomerId());
        if(!optionalCustomer.isPresent())
        {
            throw new CustomerNotFoundException("Wrong Customer ID");
        }
        Customer customer = optionalCustomer.get();
        orders.setCustomer(customer); //customer is stored in orders


        if(ordersDto.getProductIds().size()==0){
            throw new ProductNotFoundException("No Products provided");
        }
        List<Product> productsList = new ArrayList<>();
        Optional<Product> optionalProduct;
        for (Integer id: ordersDto.getProductIds()) {
            optionalProduct = productRepository.findById(id);
            if(!optionalProduct.isPresent()){
                throw new ProductNotFoundException("Wrong product id");
            }
            productsList.add(optionalProduct.get());
        }
        orders.setProducts(productsList);
        Orders orders1 = orderRepository.save(orders);
        return orders1;
    }

    @Override
    public Orders updateOrders(Orders orders) {
        return null;
    }

    @Override
    public Orders removeOrders(Orders orders) {
        return null;
    }

    @Override
    public Orders viewOrders(Orders orders) {
        return null;
    }

    @Override
    public List<Orders> viewAllOrders(LocalDate date) {
        return null;
    }

    @Override
    public Orders viewAllOrdersByLocation(String loc) {
        return null;
    }

    @Override
    public Orders viewAllOrdersByUserId(Integer userId) {
        return null;
    }
}
