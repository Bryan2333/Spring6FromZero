package com.bryan7.spring6;

import java.util.Date;

public class Student {
    // java.util.Date在Spring中被当成简单类，但是注入时有固定的格式要求
    // 因此在实际开发中，我们通常不当它为普通类，而是使用ref来注入
    private Date birth;

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Date getBirth() {
        return birth;
    }

    @Override
    public String toString() {
        return "Student{" +
                "birth=" + birth +
                '}';
    }
}
