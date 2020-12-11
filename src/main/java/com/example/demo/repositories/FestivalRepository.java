package com.example.demo.repositories;

import java.util.List;

import com.example.demo.domains.FestivalDTO;

import org.springframework.stereotype.Repository;

@Repository
public interface FestivalRepository {

	public int insert(FestivalDTO f);

	public int selectCount();

	public List<FestivalDTO> selectAll();

	public FestivalDTO select(String fesNum);

	public int delete(FestivalDTO f);
    
}
