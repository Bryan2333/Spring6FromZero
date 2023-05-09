DefaultSingletonBeanRegistry中的重要缓存：

1. 三级缓存

    1. private final Map<String, Object> singletonObjects               一级缓存

    2. private final Map<String, Object> earlySingletonObjects          二级缓存

    3. private final Map<String, ObjectFactory<?>> singletonFactories   三级缓存

2. 作用

    1. 一级缓存：单例Bean对象，完整的单例Bean对象。也就是这个缓存中Bean对象的属性值已经被赋值了

    2. 二级缓存：早期的单例Bean对象，这级缓存中的Bean对象已经完成了实例化，但是还没有进行属性赋值

    3. 三级缓存：单例工厂对象，每一个单例Bean对象都会对应一个单例工厂对象。这个集合中存放的是创建单例对象时对应的工厂对象
