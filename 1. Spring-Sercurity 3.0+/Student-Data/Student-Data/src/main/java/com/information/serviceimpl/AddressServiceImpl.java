package com.information.serviceimpl;

import com.information.entities.Address;
import com.information.repositories.AddressRepository;
import com.information.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public Address findAddressById(int id) {
        return addressRepository.findById(id).orElseThrow(()-> new RuntimeException("Address Not found"));
    }
}
