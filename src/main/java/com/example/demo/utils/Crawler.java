package com.example.demo.utils;

import com.example.demo.domains.FestivalDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

@Component
public class Crawler extends Proxy{
    @Autowired MyList<FestivalDTO> myList;
    public MyList<FestivalDTO> crawling(String url){
        try {
            Document rawData = Jsoup.connect(url).timeout(10*1000).get();
            Elements titles = rawData.select("div[class=col-sm-8] h3 text");
            for(int i=0;i<titles.size();i++){
                System.out.println(titles.get(i));
            }
            // Elements openDates = rawData.select("p[class=xs-text-center]");
            // Elements address;
            // Elements phoneNumbers;
            // Elements contents = rawData.select("div[class=col-sm-8] h3 p");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return myList;
    }
}
