package com.bryan7.spring6;

/*
*   简单工厂模式：工厂类角色
*
* */
public class StarFactory {
    public static Star get() {
        // Star对象实际上还是我们负责创建
        return new Star();
    }
}
