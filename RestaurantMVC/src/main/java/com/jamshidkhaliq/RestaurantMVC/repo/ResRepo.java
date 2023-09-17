package com.jamshidkhaliq.RestaurantMVC.repo;

import com.jamshidkhaliq.RestaurantMVC.entity.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ResRepo {
   @Autowired
   private List<Restaurant> restaurant_list;

   public List<Restaurant> getRestaurant_list(){
return restaurant_list;
   }
}
