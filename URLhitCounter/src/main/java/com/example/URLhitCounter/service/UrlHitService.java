package com.example.URLhitCounter.service;


import com.example.URLhitCounter.repo.UrlRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UrlHitService {

    @Autowired
    UrlRepo urlrepo;


    private int hitCount = 0;

    public int getHitCount() {
        hitCount++;
        return hitCount;
    }




   // private Map<String, Integer> userHitCounts = new HashMap<>();

    public Map<String, Integer>  getUserHitCount(String username) {
         urlrepo.userHitCounts.put(username, urlrepo.userHitCounts.getOrDefault(username, 0) + 1);
        Map<String, Integer>  ansMap = new HashMap<>();
        ansMap.put(username,urlrepo.userHitCounts.get(username));
        return ansMap;

    }


}



