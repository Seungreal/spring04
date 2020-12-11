package com.example.demo.domains;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component @Data
public class FestivalDTO {
    private int fesNum;
    private String title,openDate,address,phoneNumber,content;
}
