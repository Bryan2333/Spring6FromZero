package com.bryan6.simple.factory;

/*
 *   具体产品角色
 *
 */
public class Fighter extends Weapon{
    @Override
    public void attack() {
        System.out.println("战斗机发射导弹");
    }
}
