package com.geekster.mapping.controller;

import com.geekster.mapping.model.Address;
import com.geekster.mapping.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class AddressController {


    @Autowired
    AddressService addressService;

    @PostMapping("address")
    public String addAddress(@RequestBody Address newAddress)
    {
        return addressService.saveAddress(newAddress);
    }


    @PutMapping("address/{id}")
    public String addAddress(@PathVariable Integer id, @RequestBody Address updateAdd)
    {
        return addressService.updateAddress(id,updateAdd);
    }

    @DeleteMapping("address/id/{id}")
    public String deleteAddressById(@PathVariable Integer id){

        return addressService.deleteAddressById(id);
    }

    @GetMapping("addresses")
    public List<Address> getAllAddress(){
        return addressService.getAllAddress();
    }


    @GetMapping("address/id/{id}")
    public Address getAddressById(@PathVariable Integer id){
        return addressService.getAddressById(id);
    }
}
