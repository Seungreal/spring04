package com.example.demo.imples;

import com.example.demo.domains.FestivalDTO;
import com.example.demo.repositories.FestivalRepository;
import com.example.demo.services.FestivalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FestivalServiceImpl implements FestivalService {
    @Autowired FestivalRepository festivalRepository;
    @Override
    public int add(FestivalDTO f) {
        return festivalRepository.insert(f);
    }
    
}
