package cn.bryan013.spring6.service;

import cn.bryan013.spring6.dao.StudentDao;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service(value = "studentService")
public class StudentService {

    private StudentDao studentDao;

    @Resource(name = "studentDaoImplForMariadb")
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public void deleteStudent() {
        studentDao.deleteById();
    }
}
