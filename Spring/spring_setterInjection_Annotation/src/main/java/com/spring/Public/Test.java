package com.spring.Public;

// 설정자 주입 / Annotation
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
public class Test {
    public static void main(String[] args) {

        // ApplicationContext : spring 컨테이너에 대한 규격
        ApplicationContext
        context = new GenericXmlApplicationContext("applicationContext.xml");
        System.out.println("컨테이너 빌드가 완료.");

        Computer worker = context.getBean("worker", Worker.class);
        worker.doWork();
    }

}
