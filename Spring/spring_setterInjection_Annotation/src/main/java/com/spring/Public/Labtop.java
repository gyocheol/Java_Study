package com.spring.Public;

import com.spring.Public.Computer;
import org.springframework.stereotype.Component;

@Component("computer")      // 낙인을 찍을 때 그냥 찍으면 클래스명 첫글자 소문자 / 이름을 정해주면 정해준 이름으로 빈이 등록된다.
public class Labtop implements Computer {

    @Override
    public String getInfo() {
        return "노트북!";
    }
}
