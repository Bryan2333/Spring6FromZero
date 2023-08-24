package com.bryan018.spring6.service;

import com.bryan018.spring6.entity.Account;

/**
 * 业务接口
 * 事务就是在这个接口下控制的
 */
public interface AccountService {
    /**
     * 转账业务
     * @param actno1 从该账户转出
     * @param actno2 转入到该账户
     * @param amount 转账金额
     */
    void transfer(String actno1, String actno2, double amount);

    /**
     * 保存账号信息
     * @param account
     */
    void save(Account account);
}
