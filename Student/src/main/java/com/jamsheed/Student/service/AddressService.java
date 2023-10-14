package com.jamsheed.Student.service;

import com.jamsheed.Student.model.Address;
import com.jamsheed.Student.repo.IAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    IAddress addressRepo;

    public String addAddress(Address newAddress) {

        addressRepo.save(newAddress);
        return "address saved";
    }

    public String updateAddressById(Long id, Address updateAddress) {
        addressRepo.findById(id).orElseThrow();
        addressRepo.save(updateAddress);
        return "address with ID : " +id +" updated";

    }


    public String deleteById(Long id) {
        addressRepo.findById(id).orElseThrow();
        addressRepo.deleteById(id);
        return "address with ID : " +id + " deleted";
    }

    public List<Address> getAllAddresses() {
        return addressRepo.findAll();
    }

    public Address getAddressById(Long id) {
       return addressRepo.findById(id).orElseThrow();

    }
}
