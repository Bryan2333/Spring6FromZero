package com.bryan4.spring6.bean;

import java.util.Date;

// 测试简单类型
/*
* 	public static boolean isSimpleValueType(Class<?> type) {
		return (Void.class != type && void.class != type &&
				(ClassUtils.isPrimitiveOrWrapper(type) ||
				Enum.class.isAssignableFrom(type) ||
				CharSequence.class.isAssignableFrom(type) ||
				Number.class.isAssignableFrom(type) ||
				Date.class.isAssignableFrom(type) ||
				Temporal.class.isAssignableFrom(type) ||
				URI.class == type ||
				URL.class == type ||
				Locale.class == type ||
				Class.class == type));
	}
*/
public class SimpleValueType {
    private int age1;
    private Integer age2;

    private boolean flag1;
    private Boolean flag2;

    private char c1;
    private Character c2;

    private Season season;

    private String userName;

    private Class<?> clazz;

    private Date date;

    public void setAge1(int age1) {
        this.age1 = age1;
    }

    public void setAge2(Integer age2) {
        this.age2 = age2;
    }

    public void setFlag1(boolean flag1) {
        this.flag1 = flag1;
    }

    public void setFlag2(Boolean flag2) {
        this.flag2 = flag2;
    }

    public void setC1(char c1) {
        this.c1 = c1;
    }

    public void setC2(Character c2) {
        this.c2 = c2;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "SimpleValueType{" +
                "age1=" + age1 +
                ", age2=" + age2 +
                ", flag1=" + flag1 +
                ", flag2=" + flag2 +
                ", c1=" + c1 +
                ", c2=" + c2 +
                ", season=" + season +
                ", userName='" + userName + '\'' +
                ", clazz=" + clazz + '\'' +
                ", date=" + date + '\'' +
                '}';
    }
}
