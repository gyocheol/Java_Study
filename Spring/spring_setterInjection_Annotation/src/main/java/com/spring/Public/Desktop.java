package com.spring.Public;

import org.springframework.stereotype.Component;

@Component          // 낙인(자동으로 bean으로 등록됨)
public class Desktop implements Computer {
    @Override
    public String getInfo(){
        return "데스크탑!";
    }
}
