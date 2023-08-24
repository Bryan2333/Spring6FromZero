package com.bryan020.spring6.service;

import com.bryan020.spring6.entity.Account;

import java.util.List;

public interface AccountService {
    /**
     * 开户
     *
     * @param account
     * @return
     */
    int save(Account account);

    /**
     * 销户
     *
     * @param actno
     * @return
     */
    int deleteByActno(String actno);

    /**
     * 修改账户
     *
     * @param account
     * @return
     */
    int modify(Account account);

    /**
     * 查询账户
     *
     * @param actno
     * @return
     */
    Account getByActno(String actno);

    /**
     * 查询所有账户
     *
     * @param actno
     * @return
     */
    List<Account> getAll();

    /**
     * 转账
     *
     * @param fromActno
     * @param toActno
     * @param amount
     */
    void transfer(String fromActno, String toActno, double amount);
}
