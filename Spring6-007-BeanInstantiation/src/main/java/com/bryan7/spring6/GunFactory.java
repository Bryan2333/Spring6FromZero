package com.bryan7.spring6;

// 工厂方法模式中的具体产品工厂
public class GunFactory {
    public Gun get() {
        return new Gun();
    }
}
