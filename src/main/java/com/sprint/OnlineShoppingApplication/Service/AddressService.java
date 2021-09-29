package com.sprint.OnlineShoppingApplication.Service;

import com.sprint.OnlineShoppingApplication.model.Address;

public interface AddressService {
    public Address addAddress(Address add);

    public Address updateAddress(Address add);

    public Address removeAddress(Integer addressId);

    public Address viewAllAddress(String id);

    public Address viewAddress(Address add);
}
