package com.bryan6.simple.factory;

// 客户端程序
public class Test {
    public static void main(String[] args) {
       /*
        客户端不需要知道坦克的生产细节，只管向工厂索要。因此简单工厂模式达到了职责分离的效果

        客户端负责消费，工厂负责生产。一个负责生产，一个负责消。这样实现类消费者和生产者的分离

        这就是简单工厂模式的作用
       */

        // 需要坦克
        Weapon tank = WeaponFactory.get("Tank");
        tank.attack();

        // 需要匕首
        Weapon dagger = WeaponFactory.get("Dagger");
        dagger.attack();

        // 需要战斗机
        Weapon fighter = WeaponFactory.get("Fighter");
        fighter.attack();


    }
}
