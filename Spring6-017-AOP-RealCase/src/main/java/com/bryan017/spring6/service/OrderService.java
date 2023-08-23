package com.bryan017.spring6.service;

import org.springframework.stereotype.Service;

@Service("orderService")
public class OrderService {
    // 目标方法
    public void generate() {
        System.out.println("正在生成订单");
    }

    // 目标方法
    public void cancel() {
        System.out.println("订单已取消");
    }
}
