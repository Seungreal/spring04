package com.example.demo.services;

import java.util.List;

import com.example.demo.domains.FestivalDTO;

import org.springframework.stereotype.Component;

@Component
public interface FestivalService {

	public int add(FestivalDTO f);
	
	public int count();

	public int crawling(String url);

	public List<FestivalDTO> list();

	public FestivalDTO detail(String fesNum);
}
