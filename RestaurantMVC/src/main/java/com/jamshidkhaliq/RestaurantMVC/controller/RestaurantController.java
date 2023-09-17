package com.jamshidkhaliq.RestaurantMVC.controller;

import com.jamshidkhaliq.RestaurantMVC.entity.Restaurant;
import com.jamshidkhaliq.RestaurantMVC.service.ResService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestaurantController {

    @Autowired
    ResService restaurant_service;

    @GetMapping("restaurant/id/{id}")
    public Object getrestaurantById(@PathVariable Integer id) {
      return   restaurant_service.getrestaurantById(id);
    }

   @GetMapping("restaurants/all")
   public List<Restaurant> getAllRestaurants(){
        return restaurant_service.getAllRestaurants();

   }


    @PostMapping("restaurant")
    public String addRestaurant(@RequestBody Restaurant new_restaurant){
      return   restaurant_service.addRestaurant(new_restaurant);
    }


    @PutMapping("restaurant/update/id/{id}")
    public String setRestaurantInfoById(@PathVariable Integer id, @RequestBody Restaurant update_restaurant){
        return restaurant_service.setRestaurantInfoById(id,update_restaurant);
    }



    @DeleteMapping("restaurant/id/{id}/delete")
    public String removeRestaurantById(@PathVariable Integer id){
        return restaurant_service.removeRestaurantById(id);
    }
}
