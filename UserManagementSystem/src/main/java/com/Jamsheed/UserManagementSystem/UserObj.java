package com.Jamsheed.UserManagementSystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class UserObj {

   @Bean
    public List<User> UserData(){

       return new ArrayList<>();
   }


}
