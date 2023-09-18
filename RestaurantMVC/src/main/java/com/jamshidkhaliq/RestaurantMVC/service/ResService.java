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

        Object object;
        object = "invalid restaurant id";
        return  object;
    }



    //get all restaurants
    public List<Restaurant> getAllRestaurants() {

        return restaurant_repo.getRestaurant_list();
    }




    // add a new restaurant to the list
    public String addRestaurant(Restaurant newRestaurant) {
        restaurant_repo.getRestaurant_list().add(newRestaurant);
        return "new restaurant added";
    }


    // update info of restaurant by id
    public String setRestaurantInfoById(Integer id, Restaurant updateRestaurant) {

        for(Restaurant restaurant : restaurant_repo.getRestaurant_list()){
            if(restaurant.getId().equals(id)){
       /*         restaurant.setId(updateRestaurant.getId());
                restaurant.setName(updateRestaurant.getName());
                restaurant.setAddress(updateRestaurant.getAddress());
                restaurant.setPhoneNumber(updateRestaurant.getPhoneNumber());
                restaurant.setSpecialty(updateRestaurant.getSpecialty());
                restaurant.setTotalStaff(updateRestaurant.getTotalStaff());
                restaurant.setAverageRating(updateRestaurant.getAverageRating());
                restaurant.setOpen(updateRestaurant.isOpen());
                restaurant.setRestaurantcategory(updateRestaurant.getRestaurantcategory());

                return "Restaurant info updated"; */


                if (updateRestaurant.getId() != null) {
                    restaurant.setId(updateRestaurant.getId());
                }
                if (updateRestaurant.getName() != null) {
                    restaurant.setName(updateRestaurant.getName());
                }
                if (updateRestaurant.getAddress() != null) {
                    restaurant.setAddress(updateRestaurant.getAddress());
                }
                if (updateRestaurant.getPhoneNumber() != null) {
                    restaurant.setPhoneNumber(updateRestaurant.getPhoneNumber());
                }
                if (updateRestaurant.getSpecialty() != null) {
                    restaurant.setSpecialty(updateRestaurant.getSpecialty());
                }
                if (updateRestaurant.getTotalStaff() != 0) {
                    restaurant.setTotalStaff(updateRestaurant.getTotalStaff());
                }
                if (updateRestaurant.getAverageRating() != 0.0) {
                    restaurant.setAverageRating(updateRestaurant.getAverageRating());
                }
                if (updateRestaurant.getOpen() != null) {
                    restaurant.setOpen(updateRestaurant.getOpen());
                }
                if (updateRestaurant.getRestaurantcategory() != null) {
                    restaurant.setRestaurantcategory(updateRestaurant.getRestaurantcategory());
                }

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
