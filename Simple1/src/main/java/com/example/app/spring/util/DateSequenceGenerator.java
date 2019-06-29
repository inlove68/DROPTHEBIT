package com.example.app.spring.util;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

@Component // spring bean이다(일반클래스가 아닌게 됨) 다른방법은 context안에 bean 만드는 것
@Primary //얘를 먼저만들어 우선순위의 제일 우선 //priorty high than others
@Scope("singleton") //container안에 bean이 1개. getBean이 호출될때마다 새로 생성은-> prototype
public class DateSequenceGenerator implements BaseSequenceGenerator{

    private String format;
    private SimpleDateFormat simpleDateFormat; //final타입은 안됨
    private int initial;
    private final AtomicInteger counter = new AtomicInteger();

    public DateSequenceGenerator() { //생성자에서 setup해주면 됨
    }

    public void setFormat(String format) {
        this.format = format;
        this.simpleDateFormat = new SimpleDateFormat(format);
    }

    public void setInitial(int initial) {
        this.initial = initial;
    }

    public String getSequence() {
        Date date = new Date(); //자바의 util의 date를 써라. date를 now로 바꿔도됨 Date now = new Date();

        StringBuilder builder = new StringBuilder();
        builder.append(simpleDateFormat.format(date)) //date대신, now나 new Date가능 //객체없는데 참조하면 null
                .append("_")
                .append(initial + counter.getAndIncrement());
        return builder.toString();
    }
}