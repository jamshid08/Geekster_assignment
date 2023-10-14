package com.jamsheed.RestaurantManagement.service;

import com.jamsheed.RestaurantManagement.model.FoodItem;
import com.jamsheed.RestaurantManagement.repo.IFoodIteamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodIteamService {

    @Autowired
    IFoodIteamRepo foodIteamRepo;
    public List<FoodItem> getAllFoodItems() {


        return foodIteamRepo.findAll();
    }


    public String addFoodItem(FoodItem newFoodIteam) {
        foodIteamRepo.save(newFoodIteam);
        return "food Item added";
    }

    public String deleteFoodItemById(Integer id) {
        foodIteamRepo.deleteById(id);
        return "foodItem deleted";
    }


}
