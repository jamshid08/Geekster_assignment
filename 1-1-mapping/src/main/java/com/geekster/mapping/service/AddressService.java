package com.geekster.mapping.service;

import com.geekster.mapping.model.Address;
import com.geekster.mapping.repo.IAddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AddressService {


    @Autowired
    IAddressRepo addressRepo;

    public String saveAddress(Address newAddress) {

        addressRepo.save(newAddress);
        return "added";
    }

    public String updateAddress(Integer id,Address updateAdd) {

        Address add = addressRepo.findById(id).orElseThrow();
        addressRepo.save(updateAdd);
        return "updated";
    }

    public String deleteAddressById(Integer id) {
      addressRepo.findById(id).orElseThrow();
      addressRepo.deleteById(id);
      return "deleted";

    }

    public List<Address> getAllAddress() {
        return addressRepo.findAll();
    }

    public Address getAddressById(Integer id) {
        Address add = addressRepo.findById(id).orElseThrow();
      //  Address add1 = add;
        return add;
    }
}
