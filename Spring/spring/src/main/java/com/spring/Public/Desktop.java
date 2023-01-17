package com.spring.Public;

import com.spring.Public.Computer;

public class Desktop implements Computer {
    @Override
    public String getInfo(){
        return "데스크탑!";
    }
}
