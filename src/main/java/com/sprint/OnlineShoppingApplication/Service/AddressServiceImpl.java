package com.sprint.OnlineShoppingApplication.Service;

import com.sprint.OnlineShoppingApplication.Repository.AddressRepository;
import com.sprint.OnlineShoppingApplication.model.Address;
import com.sprint.OnlineShoppingApplication.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService{

    @Autowired
    private AddressRepository addressRepository;
    @Override
    public Address addAddress(Address add) {
        Address address = addressRepository.save(add);
        return address;
    }

    @Override
    public Address updateAddress(Address add) {

        return null;
    }

    @Override
    public Address removeAddress(Integer addressId) {
        Optional<Address> optionalAddress = addressRepository.findById(addressId);
        addressRepository.delete(optionalAddress.get());
        return null;
    }

    @Override
    public Address viewAllAddress(String id) {
        return null;
    }

    @Override
    public Address viewAddress(Address add) {
        return null;
    }
}
