package com.bryan015.staticproxy.service;

public interface OrderService { // 目标对象和代理对象的公共接口
    // 生成订单
    void generate();

    // 修改订单
    void modify();

    // 查看订单明细
    void detail();
}
