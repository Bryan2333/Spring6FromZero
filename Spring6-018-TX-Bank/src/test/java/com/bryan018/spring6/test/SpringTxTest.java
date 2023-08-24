package com.bryan018.spring6.test;

import com.bryan018.spring6.config.SpringConfig;
import com.bryan018.spring6.entity.Account;
import com.bryan018.spring6.service.AccountService;
import com.bryan018.spring6.service.impl.IsolationService1;
import com.bryan018.spring6.service.impl.IsolationService2;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class SpringTxTest {
    @Test
    public void testSpringTx() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        AccountService accountService = context.getBean("accountService", AccountService.class);
        try {
            accountService.transfer("act-001", "act-002", 10000);
            System.out.println("转账成功");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("转账失败");
        }
    }

    @Test
    public void testSpringTxPropagation() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        AccountService accountService = context.getBean("accountService", AccountService.class);
        Account account = new Account("act-003", 2000);
        accountService.save(account);
    }

    @Test
    public void testSpringTxIsolation2() throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        IsolationService2 i2 = context.getBean("i2", IsolationService2.class);
        // 测试读未提交
        i2.save(new Account("act-007", 1000.0));
        // 测试不可重复读
//        i2.update(new Account("act-006", 150.0));
    }

    @Test
    public void testSpringTxIsolation1() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        IsolationService1 i1 = context.getBean("i1", IsolationService1.class);
        i1.getByActno("act-005");
    }
}
