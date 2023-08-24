package com.bryan018.spring6.service.impl;

import com.bryan018.spring6.dao.AccountDao;
import com.bryan018.spring6.entity.Account;
import com.bryan018.spring6.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("accountService")
//@Transactional 可以写在类上，表示对该类的所有方法开启事务
public class AccountServiceImpl implements AccountService {
    @Resource(name = "accountDao")
    private AccountDao accountDao;

    @Resource(name = "accountService2")
    private AccountService accountService2;

    @Override
    @Transactional
    public void transfer(String actno1, String actno2, double amount) {
        // 查询转出账户的余额是否充足
        Account fromAct = accountDao.selectByActno(actno1);
        if (fromAct.getBalance() < amount) {
            throw new RuntimeException("余额不足!");
        }

        // 余额充足
        Account toAct = accountDao.selectByActno(actno2);

        // 更新内存中账号的数据
        fromAct.setBalance(fromAct.getBalance() - amount);
        toAct.setBalance(toAct.getBalance() + amount);

        // 更新数据
        int count = accountDao.update(fromAct);

        // 模拟异常
        // int a = 10 / 0;

        count = accountDao.update(toAct) + count;

        // 判断是否转账成功
        if (count != 2) {
            throw new RuntimeException("转账失败!");
        }
    }


    @Transactional(propagation = Propagation.REQUIRED)
    public void withDraw() {
        System.out.println("正在进行取款业务");
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void save(Account account) {
        // 调用Dao的insert方法
        accountDao.insert(account);
        Account act2 = new Account("act-004", 1000);
        try {
            accountService2.save(act2);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
//        accountService2.save(act2);

        // 可以继续accountService的业务
    }
}
