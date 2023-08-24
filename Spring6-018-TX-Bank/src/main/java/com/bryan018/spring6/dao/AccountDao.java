package com.bryan018.spring6.dao;

import com.bryan018.spring6.entity.Account;

/**
 * 专门负责账户信息CRUD的Dao
 */
public interface AccountDao {

    /**
     * 根据账号查询账户信息
     * @param actno
     * @return
     */
    Account selectByActno(String actno);

    /**
     * 更新账户信息
     * @param account
     * @return
     */
    int update(Account account);

    /**
     * 保存账号信息
     * @param account
     * @return
     */
    int insert(Account account);
}
