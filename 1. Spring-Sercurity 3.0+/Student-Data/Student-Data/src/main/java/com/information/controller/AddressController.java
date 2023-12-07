package com.information.controller;

import com.information.entities.Address;
import com.information.repositories.AddressRepository;
import com.information.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    // save the address
    @PostMapping
    Address saveAddress(@RequestBody Address address){
        return addressService.saveAddress(address);
    }

    // get all
    @GetMapping
    List<Address> getAllAddres(){
        return addressService.getAllAddresses();
    }

    // get Address By id
    @GetMapping("/{id}")
    Address getAddressById(@PathVariable int id){
        return addressService.findAddressById(id);
    }
}
