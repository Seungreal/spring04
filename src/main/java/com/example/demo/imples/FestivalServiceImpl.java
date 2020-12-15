package com.example.demo.imples;

import java.util.List;

import com.example.demo.domains.FestivalDTO;
import com.example.demo.repositories.FestivalRepository;
import com.example.demo.services.FestivalService;
import com.example.demo.utils.Crawler;
import com.example.demo.utils.MyList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FestivalServiceImpl implements FestivalService {
    @Autowired FestivalRepository festivalRepository;
    @Autowired Crawler crawler;
    @Override
    public int add(FestivalDTO f) {
        return festivalRepository.insert(f);
    }

    @Override
    public int count() {
        return festivalRepository.selectCount();
    }

    @Override
    public int crawling(String url) {
        MyList<FestivalDTO> list = crawler.crawling(url);
        for(int i=0;i<list.size();i++){
            add(list.get(i));
        }
        return count();
    }

    @Override
    public List<FestivalDTO> list() {
        return festivalRepository.selectAll();
    }

    @Override
    public FestivalDTO detail(String fesNum) {
        return festivalRepository.select(fesNum);
    }

    @Override
    public int delete(FestivalDTO f) {
        return festivalRepository.delete(f);
    }

    @Override
    public int update(FestivalDTO f) {
        return festivalRepository.update(f);
    }
    
}
