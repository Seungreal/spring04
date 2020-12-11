package com.example.demo.controllers;

import java.util.HashMap;
import java.util.Map;

import com.example.demo.domains.FestivalDTO;
import com.example.demo.services.FestivalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FestivalController {
    @Autowired FestivalService festivalService;
    @PostMapping("/festival")
    public Map<?,?> add(@RequestBody FestivalDTO f){
        var map = new HashMap<>();
        map.put("message", festivalService.add(f)==1?"SUCCESS":"FAILURE");
        return map;
    }
    @GetMapping("/festival/crawling/{url}")
    public Map<?,?> crawling(@PathVariable String url){
        var map = new HashMap<>();
        int count = festivalService.count();
        if(count<10){
            switch(url){
                case "koreatriptips":
                count=festivalService.crawling("http://www.koreatriptips.com/festivals-events-performances.html");
                break;
            }
        }
        map.put("count", count);
        return map;
    }
    @GetMapping("/festival")
    public Map<?,?> list(){
        var map = new HashMap<>();
        map.put("list", festivalService.list());
        map.put("count",festivalService.count());
        return map;
    }
    @GetMapping("/festival/detail/{fesNum}")
    public FestivalDTO detail(@PathVariable String fesNum){
        FestivalDTO f = festivalService.detail(fesNum);
        return f;
    }
}
