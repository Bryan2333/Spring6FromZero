Spring容器只对单例(singleTon)的Bean进行完整的生命周期管理

如果是protoType(多例)的Bean，则Spring负责该Bean的初始化。等客户端接收到Bean后，Spring容器就不再管理Bean的生命周期

Bean的生命周期5步

    1. 实例化Bean，即调用Bean的无参构造函数

    2. 给Bean赋值，即set注入

    3. 初始化Bean，调用Bean的init方法，该方法需要程序员编写

    4. 使用Bean

    5. 销毁Bean，调用Bean的destroy方法，该方法需要程序员编写


Bean的生命周期7步 (Bean初始化的前和后)

    1. 实例化Bean，即调用Bean的无参构造函数

    2. 给Bean赋值，即set注入

    3. 执行Bean后处理器的before方法

    4. 初始化Bean，调用Bean的init方法，该方法需要程序员编写

    5. 执行Bean后处理器的after方法

    6. 使用Bean

    7. 销毁Bean，调用Bean的destroy方法，该方法需要程序员编写

Bean的生命周期10步

    1. 相较于7步多出来的三部

        1. 在Bean后置处理器Before之前

            1. 检查Bean是否实现了Aware相关接口

            2. 如果实现了这些接口，则调用这些接口中的方法

        2. 在Bean后置处理器Before之后

            1. 检查Bean是否实现类 InitializingBean 接口，如果实现类则调用这个接口中的方法

        3. 销毁Bean之前 (使用Bean之后)

            1. 检查Bean是否实现类 DisposalBean 接口

    2. 特点：

        1. 检查Bean是否实现了某些特定的接口