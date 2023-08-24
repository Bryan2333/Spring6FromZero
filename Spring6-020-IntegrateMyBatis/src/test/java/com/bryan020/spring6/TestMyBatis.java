package com.bryan020.spring6;

import com.bryan020.spring6.config.SpringConfig;
import com.bryan020.spring6.entity.Account;
import com.bryan020.spring6.service.AccountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringConfig.class})
public class TestMyBatis {
    @Autowired
    private AccountService accountService;

    /**
     * 测试转账功能
     */
    @Test
    public void testTransfer() {
        try {
            accountService.transfer("act-001", "act-002", 10000);
            System.out.println("转账成功");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 测试保存账户功能
     */
    @Test
    public void testSave() {
        Account act010 = new Account("act-010", 105.0);
        try {
            accountService.save(act010);
            System.out.println("保存账户信息成功");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 测试按ID删除账户功能
     */
    @Test
    public void testDeleteByActno() {
        int count = accountService.deleteByActno("act-010");
        System.out.println(count == 1 ? "删除账户成功" : "删除账户失败");
    }

    /**
     * 测试修改账户功能
     */
    @Test
    public void testModify() {
        Account account = new Account("act-007", 1919.0);
        int count = accountService.modify(account);
        System.out.println(count == 1 ? "修改账户成功" : "修改账户失败");
    }

    /**
     * 测试按ID查询账户功能
     */
    @Test
    public void testSelectByActno() {
        Account byActno = accountService.getByActno("act-003");
        System.out.println(byActno);
    }

    /**
     * 测试查询所有用户功能
     */
    @Test
    public void testGetAll() {
        List<Account> accounts = accountService.getAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }
}
