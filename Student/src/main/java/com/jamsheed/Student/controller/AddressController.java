package com.jamsheed.Student.controller;


import com.jamsheed.Student.model.Address;
import com.jamsheed.Student.service.AddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class AddressController {

    @Autowired
    AddressService addressService;

    @PostMapping("address")
    public String addAddress(@RequestBody @Valid Address newAddress){

        return addressService.addAddress(newAddress);
    }

    @PutMapping("address/id/{id}")
    public String updateAddressById(@PathVariable @Valid Long id, @RequestBody @Valid  Address updateAddress){
        return addressService.updateAddressById(id,updateAddress);
    }

    @DeleteMapping("address/id/{id}")
    public String deleteById(@PathVariable @Valid Long id){
        return addressService.deleteById(id);
    }

    @GetMapping("addresses")
    public List<Address> getAllAddresses(){
        return addressService.getAllAddresses();
    }


    @GetMapping("address/id/{id}")
    public Address getAddressById(@PathVariable @Valid Long id){
        return addressService.getAddressById(id);
    }

}
