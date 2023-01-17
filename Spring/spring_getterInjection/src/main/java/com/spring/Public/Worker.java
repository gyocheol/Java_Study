package com.spring.Public;

public class Worker{
    private Computer computer;
    public Worker(Computer computer){
        System.out.println("Worker 생성자가 불렸습니다.");
        this.computer = computer;
    }

    // IoC
    public void setComputer(Computer computer) {
        this.computer = computer;
    }
    public void doWork(){
        System.out.println(this.computer.getInfo() + "로 일을 합니다." + this.age);
    }
    private int age;
    public void setHong(int value){         // set으로 시작하는 함수가 있으면 applicationContext의 property에 값이 잡힌다.
        this.age = value;
    }

}
