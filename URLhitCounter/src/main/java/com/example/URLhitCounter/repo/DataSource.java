package com.example.URLhitCounter.repo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSource {
@Bean
    public Map<String, Integer> data_source(){
        return new HashMap<>();
    }


}
