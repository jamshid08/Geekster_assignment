package com.jamsheed.Student.service;


import com.jamsheed.Student.model.Laptop;
import com.jamsheed.Student.repo.ILaptop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaptopService {

    @Autowired
    ILaptop laptopRepo;

    public String addLaptop(Laptop newLaptop) {
        laptopRepo.save(newLaptop);
        return "laptop added";
    }

    public String updateLaptopById(String id, Laptop updateLaptop) {
        laptopRepo.findById(id).orElseThrow();
        laptopRepo.save(updateLaptop);
        return "laptop with ID : "+ id+" updated";
    }

    public String deleteById(String id) {
        laptopRepo.findById(id).orElseThrow();
        laptopRepo.deleteById(id);
        return "laptop with ID: "+id+ " deleted";
    }

    public List<Laptop> getAllLaptops() {
        return laptopRepo.findAll();
    }

    public Laptop getLaptopById(String id) {
        return laptopRepo.findById(id).orElseThrow();
    }
}
