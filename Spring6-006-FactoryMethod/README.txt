工厂方法模式: Factory Method Pattern

1. 工厂方法模式可以解决简单工厂模式中的OCP问题

   一个工厂生产一个产品

2. 工厂方法模式中的角色

    1. 抽象产品角色 Weapon

    2. 具体产品角色 Dagger Gun

    3. 抽象工厂角色 (多了一个) WeaponFactory

    4. 具体工厂角色 DaggerFactory GunFactory

3. 工厂方法模式的优点

    1. 拓展新产品时符合开闭原则 (添加具体产品类、具体工厂类)

4. 工厂方法模式的缺点

    1. 每增多一个产品，就需要增多对应的具体产品类和具体工厂类