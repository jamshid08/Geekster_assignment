package com.example.URLhitCounter.controller;

import com.example.URLhitCounter.service.UrlHitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/visitor-count-app")
public class UrlHitController {
    @Autowired
    private UrlHitService urlHitService;

    @GetMapping("count")
    public int getHitCount() {
        return urlHitService.getHitCount();
    }


    @GetMapping("username/{username}/count")
    public Map<String, Integer> getUserHitCount(@PathVariable String username) {
        return urlHitService.getUserHitCount(username);
    }


  /* I could have added put type of methods as mentioned by
     mainak sir, but it is not needed as per requirements of question*/

}
