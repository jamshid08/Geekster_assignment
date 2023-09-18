package com.example.URLhitCounter.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class UrlRepo {

    @Autowired
    public Map<String, Integer> userHitCounts;
}
