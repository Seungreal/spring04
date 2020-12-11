package com.example.demo.services;

import com.example.demo.domains.FestivalDTO;

import org.springframework.stereotype.Component;

@Component
public interface FestivalService {

	public int add(FestivalDTO f);
    
}
