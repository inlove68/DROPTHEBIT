package com.example.app.spring.service;

public interface OrderService { //비즈니스 로직이 실행되는것
    void addOrder(String userId, String productId, Double quantity);


}
