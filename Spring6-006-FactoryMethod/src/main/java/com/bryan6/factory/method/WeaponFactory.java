package com.bryan6.factory.method;


/*
 *   抽象产品工厂
 */
public abstract class WeaponFactory {
    /*
    *   不是静态方法，是实例方法
    */
    public abstract Weapon get();

    public static WeaponFactory get (String weaponType) {
        if ("Gun".equals(weaponType)) {
            return new GunFactory();
        } else if ("Dagger".equals(weaponType)) {
            return new DaggerFactory();
        } else {
            throw new RuntimeException("无支持该产品生产");
        }
    }
}
