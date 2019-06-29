package com.example.app.spring.service;


import com.example.app.spring.util.BaseSequenceGenerator;
import com.example.app.spring.util.SequenceGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service  //Beans의 서비스.
public class OrderServiceImpl implements OrderService{
    @Autowired//////////////////////////////////////////////////////////////////////////////////////
    private BaseSequenceGenerator sequenceGenerator;

    public OrderServiceImpl(){

    }

    public OrderServiceImpl(BaseSequenceGenerator sequenceGenerator){
        this.sequenceGenerator = sequenceGenerator;

    }

    public void setSequenceGenerator(BaseSequenceGenerator sequenceGenerator){
        this.sequenceGenerator = sequenceGenerator;
    }

    //    public OrderService(SequenceGenerator sequenceGenerator){ // 이 방식을 쓰려면 컨피큐레이션에서 @
//        this.sequenceGenerator = sequenceGenerator;
//    }
    @Override //??????
    public void addOrder(String userId, String productId, Double quantity) {
        System.out.println("Added a new order");

    }


}