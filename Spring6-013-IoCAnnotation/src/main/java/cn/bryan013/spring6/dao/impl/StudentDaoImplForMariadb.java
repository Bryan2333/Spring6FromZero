package cn.bryan013.spring6.dao.impl;

import cn.bryan013.spring6.dao.StudentDao;
import org.springframework.stereotype.Repository;

@Repository(value = "studentDaoImplForMariadb")
public class StudentDaoImplForMariadb implements StudentDao {
    @Override
    public void deleteById() {
        System.out.println("Mariadb数据库正在删除学生信息...");
    }
}
