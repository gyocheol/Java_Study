package com.spring.Public;

// 생성자 주입
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

// 메이븐 : intelliJ라서 시작할때 spring > maven, sdk11, java11(gradle로 시작하면 spring boot)
// 스프링 설정파일(applicationContext) 만들고 객체(bean) 등록하기/의존관계 설정
// 스프링 컨테이너 객체 빌드 사용

public class Test {
    public static void main(String[] args) {

        // ApplicationContext : spring 컨테이너에 대한 규격
        ApplicationContext
        context = new GenericXmlApplicationContext("applicationContext.xml");
        System.out.println("컨테이너 빌드가 완료.");
        // 컨테이너로부터 내가 사용할 객체를 받아온다.
    //    Worker worker = (Worker) context.getBean("worker");
        // 형변환 가능
        Worker worker = context.getBean("worker", Worker.class);
//        Computer computer = context.getBean("desktop", Computer.class);
//        System.out.println("두개의 갯빈을 완료");
//        worker.setComputer(computer);
        worker.doWork();
        // 스프링 컨테이너는, 빈 객체들을 언제만들까?
        //1. 컨테이너가 만들어질때
        // 확인하는 방법은?


        //2. getBean 달라그럴때
        Worker worker2 = (Worker) context.getBean("worker");
        // worker2 객체가 하나더 만들어질까? 놉. 기본적인 정책은 singleton이다.
        //lazy-init을 주면 처음 getbean 시에 객체 생성된다.(가벼워짐)
        // scope의 기본은 singleton이지만, prototype으로 지정하면 달라고 할때마다 주기 때문에 아래 값이 false가 됨
        System.out.println(worker == worker2);
    }
}
