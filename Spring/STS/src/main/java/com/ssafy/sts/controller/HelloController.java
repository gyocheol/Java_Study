package com.ssafy.sts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("/")
    public String hello(){
        System.out.println("여기 왔니?");
        return "hello";
    }
}
