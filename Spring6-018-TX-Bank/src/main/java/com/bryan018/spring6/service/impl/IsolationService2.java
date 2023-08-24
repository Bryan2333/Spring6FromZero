package com.bryan018.spring6.service.impl;

import com.bryan018.spring6.dao.AccountDao;
import com.bryan018.spring6.entity.Account;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service("i2")
public class IsolationService2 {
    @Resource(name = "accountDao")
    private AccountDao accountDao;

    // 负责插入数据
    // rollbackFor = {RuntimeException.class} 只要发生RuntimeException或子类异常就回滚
//    @Transactional(rollbackFor = {RuntimeException.class})
    @Transactional(noRollbackFor = {NullPointerException.class})
    public void save(Account act) throws IOException {
//        try {
//            Thread.sleep(1000 * 15);
//        } catch (InterruptedException e) {
//            System.out.println(e.getMessage());
//        }
        accountDao.insert(act);
        throw new NullPointerException();
    }

    @Transactional
    public void update(Account act) {
        accountDao.update(act);
    }
}
