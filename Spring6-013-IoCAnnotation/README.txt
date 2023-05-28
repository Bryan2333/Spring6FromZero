1. 实例化Bean的注解

    1. @Component 实体类

    2. @Controller 表示层

    3. @Service 业务层

    4. @Repository 持久层

2. 依赖注入

    1. @Value 简单类型注入

    2. @Autowired和@Resource 复杂类型注入

        1. @Autowired默认根据类型进行自动装配，如果需要根据名称进行装配，则需要配合@Qualifier注解使用

        2. @Resource默认根据名称进行装配，如果没有指定名称，则根据属性名进行装配，最后才根据类型进行装配