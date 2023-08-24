package com.bryan018.spring6.service.impl;

import com.bryan018.spring6.dao.AccountDao;
import com.bryan018.spring6.entity.Account;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service("i1")
public class IsolationService1 {
    @Resource(name = "accountDao")
    private AccountDao accountDao;

    // 负责查询数据
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void getByActno(String actno) {
        Account account = accountDao.selectByActno(actno);
        System.out.println(account);

        // 测试可重复读
        try {
            Thread.sleep(20 * 1000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Account account1 = accountDao.selectByActno(actno);
        System.out.println(account1);
    }
}
