package com.bryan010.reflect;

public class SomeService {
    public void doSome() {
        System.out.println("doSome方法执行");
    }

    public String doSome(String s) {
        System.out.println("public String doSome(String s)被执行");
        return s;
    }

    public String doSome(String s, int x) {
        System.out.println("public String doSome(String s, int x)被执行");
        return s + x;
    }
}
