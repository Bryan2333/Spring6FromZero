package com.bryan020.spring6.service.impl;

import com.bryan020.spring6.entity.Account;
import com.bryan020.spring6.mapper.AccountMapper;
import com.bryan020.spring6.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("accountService")
@Transactional(isolation = Isolation.SERIALIZABLE)
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountMapper accountMapper;

    @Override
    public int save(Account account) {
        return accountMapper.insert(account);
    }

    @Override
    public int deleteByActno(String actno) {
        return accountMapper.deleteByActno(actno);
    }

    @Override
    public int modify(Account account) {
        return accountMapper.update(account);
    }

    @Override
    public Account getByActno(String actno) {
        return accountMapper.selectByActno(actno);
    }

    @Override
    public List<Account> getAll() {
        return accountMapper.selectAll();
    }

    @Override
    public void transfer(String fromActno, String toActno, double amount) {
        Account fromAccount = accountMapper.selectByActno(fromActno);

        if (fromAccount.getBalance() < amount) {
            throw new RuntimeException("余额不足！");
        }

        Account toAccount = accountMapper.selectByActno(toActno);
        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);

        int count = accountMapper.update(fromAccount);
        count = count + accountMapper.update(toAccount);

        if (count != 2) {
            throw new RuntimeException("转账失败");
        }
    }
}
