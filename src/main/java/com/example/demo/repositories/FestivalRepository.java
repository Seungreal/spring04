package com.example.demo.repositories;

import com.example.demo.domains.FestivalDTO;

import org.springframework.stereotype.Repository;

@Repository
public interface FestivalRepository {

	int insert(FestivalDTO f);
    
}
