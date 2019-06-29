package com.example.app.spring.context;


import com.example.app.spring.service.OrderService;
import com.example.app.spring.service.OrderServiceImpl;
import com.example.app.spring.util.BaseSequenceGenerator;
import com.example.app.spring.util.DateSequenceGenerator;
import com.example.app.spring.util.SequenceGenerator;
//import com.sun.tools.corba.se.idl.constExpr.Or;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration //어떻게 bean을 찾을거냐
@ComponentScan(basePackages = {"com.example.app.spring"})  //어느 패키지 아래에서 찾겠다.-> groupId를 ""안에 넣음
public class SimpleApplicationContext { //1. @Component->pring bean이다 2.다른방법은 context안에 bean 만드는 것

    @Bean // 컨피규레이션이 필요하다면!, 여기서 빈즈라고 선언하기 떄문에 @컴포넌트가 필요가 없다(여기서 안하면 xml에서 함)
    // ->따라서 이 클래스는 Bean이 됨
    public BaseSequenceGenerator getSequenceGenerator(){ //interface임
//        SequenceGenerator generator = new SequenceGenerator();
//        generator.setPrefix("Java");
//        generator.setSuffix("_BitCamp");
//        generator.setInitial(10000);
//        return generator;
        DateSequenceGenerator generator = new DateSequenceGenerator(); //generator쓰려면 setup과정 있는 경우, 없는경우 있음
        generator.setFormat("yyyyMMdd");
        generator.setInitial(10000);
        return generator;
    }


//    @Bean
//    public OrderService getOrderService(){
//        // 1. by constructor
////        return new OrderServiceImpl(getSequenceGenerator());
//
//        // 2. by setter
////        OrderServiceImpl orderService = new OrderServiceImpl();
//////        orderService.setSequenceGenerator(getSequenceGenerator());
//////        return orderService;
//
//        return new OrderServiceImpl();
//    }

}// class end