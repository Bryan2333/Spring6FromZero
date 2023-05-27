package com.bryan010.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test4 {
    public static void main(String[] args) throws Exception {
        String className = "com.bryan010.reflect.User";
        String propertyName = "age";

        Class<?> clazz = Class.forName(className);

        // 根据属性名获取属性类型
        Field field = clazz.getDeclaredField(propertyName);

        // 获取方法名
        String methodName = "set" + propertyName.toUpperCase().charAt(0) + propertyName.substring(1);

        // 获取方法
        // 通过getType方法动态获取属性类型
        Method setAge = clazz.getDeclaredMethod(methodName, field.getType());

        User user = (User) clazz.getConstructor().newInstance();

        setAge.invoke(user, 23);

        System.out.println(user);
    }
}
