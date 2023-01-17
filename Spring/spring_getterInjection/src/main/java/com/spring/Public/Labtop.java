package com.spring.Public;

import com.spring.Public.Computer;

public class Labtop implements Computer {

    @Override
    public String getInfo() {
        return "노트북!";
    }
}
