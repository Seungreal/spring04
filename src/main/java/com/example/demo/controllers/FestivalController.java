package com.example.demo.controllers;

import java.util.HashMap;
import java.util.Map;

import com.example.demo.domains.FestivalDTO;
import com.example.demo.services.FestivalService;
import com.example.demo.utils.Crawler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FestivalController {
    @Autowired FestivalService festivalService;
    @Autowired Crawler crawler;
    @PostMapping("/festival")
    public Map<?,?> add(@RequestBody FestivalDTO f){
        var map = new HashMap<>();
        int result = festivalService.add(f);
        map.put("message", result==1?"SUCCESS":"FAILURE");
        return map;
    }
    @GetMapping("/festival/crawling/{url}")
    public Map<?,?> crawling(@PathVariable String url){
        var map = new HashMap<>();
        if(url.equals("koreatriptips")){
            crawler.crawling("http://www.koreatriptips.com/festivals-events-performances.html");
        }
        return map;
    }
}
