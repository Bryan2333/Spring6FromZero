package com.bryan6.simple.factory;

public class WeaponFactory {

    /*
    *   参数值决定返回的产品
    *
    *   简单工厂模式中有一个静态方法，所以被称为[静态]工厂方法模式
    */
    public static Weapon get(String weaponType) {
        if ("Tank".equals(weaponType)) {
            return new Tank();
        } else if ("Dagger".equals(weaponType)) {
            return new Dagger();
        } else if ("Fighter".equals(weaponType)) {
            return new Fighter();
        } else {
            throw new RuntimeException("不支持该武器的生产");
        }
    }
}
