package com.information.services;

import com.information.entities.Address;

import java.util.List;

public interface AddressService {

    // Save Address
    Address saveAddress(Address address);

    // find all address
    List<Address> getAllAddresses();

    // find address By id
    Address findAddressById(int id);
}
