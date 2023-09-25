package com.jamsheed.UserManagementSystem_Validation.repo;

import com.jamsheed.UserManagementSystem_Validation.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DataSource {

    @Bean
  public  List<User> getDataSource() {
        return new ArrayList<>();
    }
}
