package com.example.app.spring.util;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component //context가 얘를 spring bean으로 인식하도록 해줌 (그냥 클래스가 아니라)
@Scope("singleton")
//singleton(default-> 인스턴스가 1개 외에는 getBean이라고 할때마다 만들어야됨), prototype,여기부터는 웹에서 request, session, application
public class SequenceGenerator implements BaseSequenceGenerator{
    private String prefix; //property만듦 generate 해서 만들면 됨 밑에 setter들은..!
    private String suffix;
    private int initial;
    private final AtomicInteger counter = new AtomicInteger(); //private final AtonicInteger counter; 과제 관련

    public SequenceGenerator() { //디버깅용으로 constructor만들어 주면 됨
        //this.AtomicInteger = new AtomicInteger(); //과제 관련
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public void setInitial(int initial) {
        this.initial = initial;
    }

    @Override
    public String getSequence() { //Generate-> implement하면 됨
        StringBuilder builder = new StringBuilder(); //그냥 add하는 것 보다 더 빨라서 StringBuilder로 만듦
        builder.append(prefix)//Builder패턴(Builder패턴 없으면 생성자, parameter가 많을 때 객체를 생성하는 경우에 씀)-> this
                .append(initial + counter.getAndIncrement())
                //.append(initial)
                //.append(counter.getAndIncrement())
                .append(suffix);
        return builder.toString();
    }
}
