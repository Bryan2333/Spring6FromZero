package com.bryan4.spring6.bean;

import java.util.Arrays;

public class ZhangSan {
    private String[] hobbies;

    private Woman[] women;

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    public void setWomen(Woman[] women) {
        this.women = women;
    }

    @Override
    public String toString() {
        return "ZhangSan{" +
                "hobbies=" + Arrays.toString(hobbies) +
                ", women=" + Arrays.toString(women) +
                '}';
    }
}
