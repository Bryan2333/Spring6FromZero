package com.bryan018.spring6.service.impl;

import com.bryan018.spring6.dao.AccountDao;
import com.bryan018.spring6.entity.Account;
import com.bryan018.spring6.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("accountService2")
public class AccountServiceImpl2 implements AccountService {
    @Resource(name = "accountDao")
    private AccountDao accountDao;

    @Override
    public void transfer(String actno1, String actno2, double amount) {
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void save(Account account) {
        accountDao.insert(account);

        // 模拟异常
        int a = 10 / 0;

        // 后续的业务可能还有DML语句
    }
}
