package com.jamshidkhaliq.RestaurantMVC.entity;


import lombok.Data;

@Data
public class Restaurant {

    private Integer id;
    private String name;
    private String address;
    private String phoneNumber;
    private String specialty;
    private int totalStaff;
    private double averageRating;
    private Boolean open ;
    private Category restaurantcategory;



}
