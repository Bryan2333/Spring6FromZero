package com.bryan6.factory.method;

public class Test {
    public static void main(String[] args) {

        WeaponFactory daggerFactory = WeaponFactory.get("Dagger");
        Weapon dagger = daggerFactory.get();
        dagger.attack();

        WeaponFactory gunFactory = WeaponFactory.get("Gun");
        Weapon gun = gunFactory.get();
        gun.attack();
    }
}
