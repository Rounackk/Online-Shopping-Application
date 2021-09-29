package com.sprint.OnlineShoppingApplication.Controller;

import com.sprint.OnlineShoppingApplication.Service.AddressService;
import com.sprint.OnlineShoppingApplication.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/addaddress")
    public ResponseEntity<Address> addAddress(@RequestBody Address address){
        Address address1 = addressService.addAddress(address);
        return new ResponseEntity<>(address1, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteaddress/{addressId}")
    public ResponseEntity<Address> deleteAddress(@PathVariable Integer addressId){
        addressService.removeAddress(addressId);
        return new ResponseEntity<>(HttpStatus.GONE);
    }
}
