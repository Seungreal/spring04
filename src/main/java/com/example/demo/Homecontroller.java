package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class Homecontroller {
    @GetMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("/forms/{dir}/{fname}")
    public String move(@PathVariable String dir,@PathVariable String fname){
        System.out.println("이동한 파일:"+fname);
        return String.format("%s/%s", dir,fname);
    }
}
