package com.bryan010.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Test2 {
    public static void main(String[] args) throws Exception {
        // 使用反射机制
        // 获取类对应的类对象
        Class<?> clazz = Class.forName("com.bryan010.reflect.SomeService");

        // 通过类对象获取方法
        Method doSome = clazz.getDeclaredMethod("doSome", String.class, int.class);

        Constructor<?> declaredConstructor = clazz.getDeclaredConstructor();
        SomeService someService = (SomeService) declaredConstructor.newInstance();

        // 调用方法
        // 四要素： 哪个对象，     什么方法，  传什么参数，    返回值是什么
        //       someService    doSome     "test",2        test
        String test = (String) doSome.invoke(someService, "test", 2);
        System.out.println(test);
    }
}
