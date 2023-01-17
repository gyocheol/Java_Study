# Java_Study

# Spring

## 10/11

+ spring framework 특징 - 객체 관리 컨테이너 / 의존성 주입과 제어역전이 가장 중요함
  + POJO(Plain Old Java Object) : EJB가 기능 작성을 위해서 인터페이스를 구현하거나 상속하는 것에 비해 일반적인 자바 객체를 이용해서 그대로 사용할 수 있음을 의미한다.
  + 의존성(new, 객체 생성) 주입(DI, Dependency Injection)을 통한 객체 관계 구성 : 프레임워크 내부에서 사용되는 객체간 의존성이 존재할 경우, 개발자는 의존성에 관련한 설정만 해주면 실제 의존성 생성은 프레임워크가 담당한다.
    + 내가 사용할 **객체를 다른게 만들어** 주는 것
  + 관점지향 프로그래밍(AOP, Aspect Oriented Progeamming) 지원 : 트랜잭션, 로깅 등 여러 모듈에서 공통적으로 사용하는 기능에 대해서 별도로 분리하여 작성, 관리할 수 있는 기능을 제공한다.
  + 제어 역전(IoC, inversion of Control) : 내가 사용할 **객체를 프레임워크가 만들어**준다. 의존성 주입과 비슷한 개념
  + 높은 확장성과 다양한 라이브러리 지원 : 영속성 관련하여 Mybatis나 Hibernate 등 완성도 높은 데이터 베이스 라이브러리와 연결가능한 인터페이스를 제공한다.
    + ORM(Mybatis, Hibernate) : 이름과 타입을 알아서 지정해줌(DTO를 알아서 지정)



##### 중요

1. Framework에 대한 이해
2. DI, IoC 개념
3. Spring 개발 환경
4. Spring 환경설정
   + 컨테이너에 객체 등록, 의존 관계



### IntelliJ 단축키

+ alt + insert : Generate(get, set 등등)
+ ctrl + d : 한 줄씩 아래로 복사
+ alt + shift + 방향키 : 커서 있는 줄 잡고 방향키 방향으로 이동





### IntelliJ Spring Boot Framework 오류

FAILURE: Build failed with an exception.

1. Gradle 상위 폴더 우클릭 후 Open Gradle config 열고 pulgins 안에 두번째 줄에 version을 2.7.7로 바꿔주기

2. sourceCompatibility를 11로 바꿔주기



### Spring Framework 시작

+ spring누르고 Maven 선택...



### resource 폴더

* bean 태그만들기

  * ```
    <bean class="com.spring.Public.Desktop" id="desktop"></bean>
    
    // 위 대문자 Desktop이 아래의 new 다음 Desktop
    // 위 id가 아래의 desktop
    
    Desktop desktop = new Desktop();
    ```





### 설정자 주입과 생성자 주입의 차이

##### 설정자 주입

+ 중간에 의존관계를 자바코드 딴에서 동적으로 바꿔 끼울수 있다.
+ 생성자 주입보다 자유도가 높다



##### 생성자 주입

+ 주입을 하지 않고는 절대로 객체를 생성할 수 없다.
+ 설정자 주입보다 엄격함



##### spring archeitecture

+ Core : Ioc - 가장 기본의 컨테이너 기능

+ DAO : JDBC Support
  + 쓰기 힘든 이유
    + 자원관리
    + 파라미터 매핑
    + 결과 매핑
+ ORM : 외부 ORM 연동
+ Web : MVC
+ AOP



##### context

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/context http://www.springframework.org/schema/beans/spring-beans.xsd">
<!--    component-scan : 지정된 패키지에서 낙인이 찍힌 클래스를 모두 bean으로 등록한다.-->
    <context:component-scan base-pakage="com.spring.Public"/>

</beans>
```

+ 낙인의 종류

  + ```
    @Component  
    ```

  + ```
    @Autowired (Spring에서 권장)
    // 한개일때 자동으로 타입이 일치하는 bean을 찾아서 context로 넣어줌
    // private도 뚫어줌 : 내부 구현의 reflection 기술을 활용해서 가능
    // 두개 이상이면 에러남
    // 여러개일지라도 하나의 빈이 자신과 이름이 같다면 이름이 같은 빈을 의존설정한다.
    ```

  + ```
    @Component("원하는 이름") 
    // 낙인을 찍을 때 그냥 찍으면 클래스명 첫글자 소문자 / 이름을 정해주면 정해준 이름으로 빈이 등록된다.
    ```

  + ```
    Qualifier("원하는 이름") 
    // @Autowired와 비슷
    // 두개 이상일 때 하나의 빈이 자신과 이름이 같다면 이름이 같은 빈을 의존설정한다.
    ```



### 최종 정리 - 편한거 써라

+ 설정자 주입
  + property
    + value
    + ref : 빈 객체
+ 생성자 주입
  + constructor-arg
+ 설정자 주입_Annotation
  + context:component-scan
    + base-package
  + 낙인을 찍고 낙인에 이름도 넣을 수 있다.



##### 추가

+ 아래 개념 설명 및 예시 코드

  + https://velog.io/@leesomyoung/Java-DAO-DTO-VO%EC%9D%98-%EA%B0%9C%EB%85%90

+ DAO?

  + Data Access Object의 약자로, 데이터베이스의 데이터에 접근하기 위해 생성하는 객체이다.

    데이터베이스에 접근하기 위한 로직과 비즈니스 로직을 분리하기 위해 사용한다.

    간단하게, DB에 접속하여 데이터의 CRUD(생성, 읽기, 갱신, 삭제) 작업을 시행하는 클래스이다.

    JSP 및 Servlet 페이지 내에 로직을 기술하여 사용할 수 있지만, 코드의 간결화 및 모듈화, 유지보수 등의 목적을 위해 별도의 DAO 클래스를 생성하여 사용하는 것이 좋다.

    한 줄 요약 : DAO는 DB를 사용하여 데이터의 조회 및 조작하는 기능을 전담하는 오브젝트이다.

+ DTO

  + Data Transfer Object의 약자로, 계층간 데이터 교환을 위한 자바빈즈를 뜻한다.

    또한 DTO는 VO(Value Object)와 용어를 혼용해서 많이 사용하는데, VO는 읽기만 가능한 read only 속성을 가져 DTO와의 차이점이 존재한다.

    일반적으로 DTO는 로직을 가지고 있지 않은 순수한 데이터의 객체이며 객체의 속성과 그 속성의 접근을 위한 getter 및 setter 메소드만을 가지고 있다.

    한 줄 요약 : DTO는 VO와 혼용하여 사용하며, 순수한 데이터의 객체이다.

+ VO

  + VO는 Value Object의 약자로, `Read-Only` 속성을 가진 `값 오브젝트`이다. 자바에서 단순히 값 타입을 표현하기 위하여 불변 클래스(Read-Only)를 만들어 사용한다. 따라서 `getter`기능만 존재한다.





## 10/12

https://edu.ssafy.com/edu/board/free/detail.do?brdItmSeq=51149&listMenu=&lctCd=null&lctrRepId=null&lctrBrdSeq=null&pageIndex=9&searchBrdFilter=Lv5&searchBrdItmCdVal=4&searchMyItm=&searchOpenYn=&searchWord=&_csrf=9769989c-9400-483a-b939-7c5fa3b68ed6

















