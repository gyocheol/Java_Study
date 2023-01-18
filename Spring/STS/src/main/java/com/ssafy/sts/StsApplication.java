package com.ssafy.sts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StsApplication {
    public static void main(String[] args) {
        SpringApplication.run(StsApplication.class, args);
//        // Bean 출력
//        ApplicationContext context = SpringApplication.run(StsApplication.class, args);
//
//        String[] names =  context.getBeanDefinitionNames();
//
//        for(String name : names){
//            System.out.println(name);
//        }
    }

}
