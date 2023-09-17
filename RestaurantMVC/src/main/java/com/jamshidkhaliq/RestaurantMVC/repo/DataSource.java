package com.jamshidkhaliq.RestaurantMVC.repo;

import com.jamshidkhaliq.RestaurantMVC.entity.Restaurant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DataSource {

    @Bean
    List<Restaurant> getDataSource(){
        return new ArrayList<>();
    }
}
