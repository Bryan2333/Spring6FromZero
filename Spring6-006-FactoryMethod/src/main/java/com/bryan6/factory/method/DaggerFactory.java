package com.bryan6.factory.method;

/*
*   具体产品工厂
*/
public class DaggerFactory extends WeaponFactory{
    @Override
    public Weapon get() {
        return new Dagger();
    }
}
