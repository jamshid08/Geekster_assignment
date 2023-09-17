package com.jamshidkhaliq.RestaurantMVC.service;

import com.jamshidkhaliq.RestaurantMVC.entity.Restaurant;
import com.jamshidkhaliq.RestaurantMVC.repo.ResRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResService {
    @Autowired
    ResRepo restaurant_repo;
// get restaurant by id.
    public Object getrestaurantById(Integer id) {

        for(Restaurant restaurant : restaurant_repo.getRestaurant_list()){
            if(restaurant.getId().equals(id)){
                return restaurant;
            }
        }

        String str = "invalid  retaurant id";
        Object ob = str;
        return  ob;
    }



    //get all restaurants
    public List<Restaurant> getAllRestaurants() {

        return restaurant_repo.getRestaurant_list();
    }




    // add a new restaurant to the list
    public String addRestaurant(Restaurant newRestaurant) {
        restaurant_repo.getRestaurant_list().add(newRestaurant);
        return "new reataurant added";
    }


    // update info of restaurant by id
    public String setRestaurantInfoById(Integer id, Restaurant updateRestaurant) {

        for(Restaurant restaurant : restaurant_repo.getRestaurant_list()){
            if(restaurant.getId().equals(id)){
                restaurant.setId(updateRestaurant.getId());
                restaurant.setName(updateRestaurant.getName());
                restaurant.setAddress(updateRestaurant.getAddress());
                restaurant.setPhoneNumber(updateRestaurant.getPhoneNumber());
                restaurant.setSpecialty(updateRestaurant.getSpecialty());
                restaurant.setTotalStaff(updateRestaurant.getTotalStaff());
                restaurant.setAverageRating(updateRestaurant.getAverageRating());
                restaurant.setOpen(updateRestaurant.isOpen());
                restaurant.setRestaurantcategory(updateRestaurant.getRestaurantcategory());

                return "Restaurant info updated";
            }
        }

        return "invalid id";
    }



    // delete restaurant by id
    public String removeRestaurantById(Integer id) {
        for(Restaurant restaurant : restaurant_repo.getRestaurant_list()){
            if(restaurant.getId().equals(id)) {
                restaurant_repo.getRestaurant_list().remove(restaurant);
                return "Restaurant: " + id + " deleted";
            }
            }
        return "invalid id";
    }
}
