package com.jamsheed.RestaurantManagement.repo;

import com.jamsheed.RestaurantManagement.model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFoodIteamRepo extends JpaRepository<FoodItem,Integer> {
}
