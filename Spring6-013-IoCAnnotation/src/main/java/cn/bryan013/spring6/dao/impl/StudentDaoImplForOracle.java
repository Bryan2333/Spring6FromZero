package cn.bryan013.spring6.dao.impl;

import cn.bryan013.spring6.dao.StudentDao;
import org.springframework.stereotype.Repository;

@Repository(value = "studentDaoImplForOracle")
public class StudentDaoImplForOracle implements StudentDao {
    @Override
    public void deleteById() {
        System.out.println("Oracle数据库正在删除学生信息...");
    }
}
