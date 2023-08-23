package com.bryan017.spring6.service;

import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountService {
    // 目标方法
    // 转账业务方法
    public void transfer() {
        System.out.println("银行业务正在完成业务转账");
    }

    // 目标方法
    // 取款业务方法
    public void withdraw() {
        System.out.println("银行账户正在进行取款业务");
        throw new RuntimeException();
    }
}
