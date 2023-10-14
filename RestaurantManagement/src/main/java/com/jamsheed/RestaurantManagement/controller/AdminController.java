package com.jamsheed.RestaurantManagement.controller;

import com.jamsheed.RestaurantManagement.model.FoodItem;
import com.jamsheed.RestaurantManagement.service.AdminService;
import com.jamsheed.RestaurantManagement.service.FoodIteamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class AdminController {

    @Autowired
    AdminService adminService;
    @Autowired
    FoodIteamService foodIteamService;

    @PostMapping("foodItem")
    public String addFoodItem(@RequestBody @Valid FoodItem newFoodIteam){
        return foodIteamService.addFoodItem(newFoodIteam);
    }

    @GetMapping("foodItems/admin")
    public List<FoodItem> getAllFoodItems(){
        return foodIteamService.getAllFoodItems();
    }

    @DeleteMapping("foodItem/id/{id}")
    public String deleteFoodItemById(@PathVariable @Valid Integer id){
        return foodIteamService.deleteFoodItemById(id);
    }





}
