package com.bryan015.staticproxy.service;

public class OrderServiceImpl implements OrderService {
    // 目标方法
    @Override
    public void generate() {
        try {
            Thread.sleep(1234);
            System.out.println("订单已生成");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 目标方法
    @Override
    public void modify() {
        try {
            Thread.sleep(1111);
            System.out.println("订单已修改");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 目标方法
    @Override
    public void detail() {
        try {
            Thread.sleep(1221);
            System.out.println("以下是订单明细...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
