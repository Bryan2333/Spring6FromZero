package com.bryan012.reflect;

import com.bryan012.annotation.Component;

public class ReflectAnnotationTest {
    public static void main(String[] args) throws Exception {
        // 通过反射机制读取注解
        Class<?> aClass = Class.forName("com.bryan012.bean.User");

        // 判断类上有没有Component注解
        if (aClass.isAnnotationPresent(Component.class)) {
            // 获取类上的注解
            Component annotation = aClass.getAnnotation(Component.class);

            // 访问注解属性
            System.out.println(annotation.value());
        }
    }
}
