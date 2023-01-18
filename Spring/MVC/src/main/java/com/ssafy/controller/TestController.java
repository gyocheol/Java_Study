package com.ssafy.controller;

@Controller
@RequestMapping("/rest1")
public class TestController{
    @Getmapping("/test1")
    public String test1(){
        return "hi rest"
    }
}