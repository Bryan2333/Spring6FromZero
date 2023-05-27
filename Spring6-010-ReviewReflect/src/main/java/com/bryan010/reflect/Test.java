package com.bryan010.reflect;

public class Test {
    public static void main(String[] args) {
        // 不使用反射机制调用方法
        SomeService someService = new SomeService();

        /*
        *   调用方法的要素
        *
        *   1. 第一要素：调用哪个对象
        *
        *   2. 第二要素：调用该对象的哪个方法
        *
        *   3. 第三要素：给这方法传递什么参数
        *
        *   4. 第四要素：这个方法的返回值
        *
        *   即使是通过反射机制来调用方法，也需要这四个要素
        *
        */
        someService.doSome();

        String str1 = someService.doSome("test");
        System.out.println(str1);

        String str2 = someService.doSome("test", 2);
        System.out.println(str2);
    }
}
