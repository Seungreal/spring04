package com.example.demo.utils;

import com.example.demo.domains.FestivalDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

@Component
public class Crawler extends Proxy{
    @Autowired MyList<FestivalDTO> myList;
    @Autowired FestivalDTO festivalDTO;
    public MyList<FestivalDTO> crawling(String url){
        try {
            Document rawData = Jsoup.connect(url).timeout(10*1000).get();
            Elements titles = rawData.select("div[class=col-sm-8]>h3>a");
            Elements infos = rawData.select("div[class=col-sm-8]>p");
            for(int i=0;i<titles.size();i++){
                festivalDTO = new FestivalDTO();
                festivalDTO.setTitle(titles.get(i).text());
                String str = infos.get(i*3).text();
                int from = str.indexOf(' ');
                festivalDTO.setOpenDate(str.substring(from+1));
                str = infos.get(i*3+1).text();
                from = str.indexOf('0');
                if(from==-1)
                from=6;
                festivalDTO.setAddress(str.substring(0, from-1));
                festivalDTO.setPhoneNumber(str.substring(from));
                festivalDTO.setContent(infos.get(i*3+2).text());
                myList.add(festivalDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return myList;
    }
}
