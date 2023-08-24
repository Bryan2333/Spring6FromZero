package com.bryan020.spring6.mapper;

import com.bryan020.spring6.entity.Account;
import org.apache.ibatis.annotations.*;

import java.util.List;

// 接口的实现类会由MyBatis通过动态代理自动生成

@Mapper
public interface AccountMapper {
    /**
     * 新增数据
     *
     * @param account
     * @return
     */
    @Insert("INSERT INTO t_act VALUES (#{actno}, #{balance})")
    int insert(Account account);

    /**
     * 删除账户
     *
     * @param actno
     * @return
     */
    @Delete("DELETE FROM t_act WHERE actno = #{actno}")
    int deleteByActno(String actno);

    /**
     * 更新账户数据
     *
     * @param account
     * @return
     */
    @Update("UPDATE t_act SET balance = #{balance} WHERE actno = #{actno}")
    int update(Account account);

    /**
     * 根据ID查询账户
     *
     * @param actno
     * @return
     */
    @Select("SELECT * FROM t_act WHERE actno = #{actno}")
    @ResultType(Account.class)
    Account selectByActno(String actno);

    /**
     * 查询所有数据
     *
     * @return
     */
    @Select("SELECT * FROM t_act")
    @ResultType(Account.class)
    List<Account> selectAll();
}
