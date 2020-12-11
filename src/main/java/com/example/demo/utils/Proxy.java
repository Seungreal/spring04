package com.example.demo.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import org.springframework.stereotype.Component;

@Component("px")
public class Proxy {
    public Map<Object,Object> hashMap(){
        Supplier<Map<Object,Object>> s = HashMap::new;
        return s.get();
    }
}
