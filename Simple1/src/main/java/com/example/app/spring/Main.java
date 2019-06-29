package com.example.app.spring;

import com.example.app.spring.context.SimpleApplicationContext;
import com.example.app.spring.service.OrderService;
import com.example.app.spring.util.SequenceGenerator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args ){
        ApplicationContext context
                = new AnnotationConfigApplicationContext(SimpleApplicationContext.class); //
        // Beans 지정. SimpleApplicationContext.class 부분->즉, 매개변수만 바꿔서 쓰면됨


        OrderService service = context.getBean(OrderService.class);
        service.addOrder("kangil-seo","0x12345678",100.0);

//        BaseSequenceGenerator generator = context.getBean(BaseSequenceGenerator.class); //bean을 가져옴
//        generator.setPrefix("Java");
//        generator.setSuffix("_BitCamp");
//        generator.setInitial(10000);

//        System.out.println( "Next sequence = "+ generator.getSequence() );
    }



}// class end