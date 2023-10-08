package com.jamsheed.Student.controller;

import com.jamsheed.Student.model.Laptop;
import com.jamsheed.Student.service.LaptopService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class LaptopController {

    @Autowired
    LaptopService laptopService;


    @PostMapping("laptop")
    public String addLaptop(@RequestBody @Valid Laptop newLaptop){

        return laptopService. addLaptop(newLaptop);
    }

    @PutMapping("laptop/id/{id}")
    public String updateLaptopById(@PathVariable @Valid String id, @RequestBody @Valid  Laptop updateLaptop){
        return laptopService. updateLaptopById(id,updateLaptop);
    }

    @DeleteMapping("laptop/id/{id}")
    public String deleteById(@PathVariable @Valid String  id){
        return laptopService.deleteById(id);
    }

    @GetMapping("laptops")
    public List<Laptop> getAllLaptops(){
        return laptopService.getAllLaptops();
    }


    @GetMapping("laptop/id/{id}")
    public Laptop getLaptopById(@PathVariable @Valid String  id){
        return laptopService.getLaptopById(id);
    }
}
