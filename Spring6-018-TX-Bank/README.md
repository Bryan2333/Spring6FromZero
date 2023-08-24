# Spring事务

## Spring对事务的支持

Spring实现事务的两种方式：

1. 编程式事务
    1. 通过编写代码实现事务管理
2. 声明式事务
    1. 基于注解的方式
    2. 基于xml配置的方式

## Spring事务管理API

Spring对事务管理是基于AOP实现的，API的核心接口是 `PlatformTransactionManager`

- `PlatformTransactionManager`: Spring事务管理的核心接口，在Spring6中有两个实现类
    - `DataSourceTransactionManager`: 支持JdbcTemplate, MyBatis, Hibernate的ORM框架
    - `JtaTransactionManager`: 支持分布式事务管理

## Spring事务属性

### 事务传播行为

假设在Service类有 `a()` `b()` 两个方法，两者都被 `@Transactional` 注解标注，当`a()`执行过程中调用了`b()`
，两个方法的事务的关系称为事务传播行为

事务传播行为一共有七种，在Spring中以枚举形式存在：

1. `REQUIRED`: 支持当前事务，如果没有就新建一个 (默认)
2. `SUPPORTS`: 支持当前事务，如果没有就以非事务的方式执行
3. `MANDATORY`: 必须运行在一个事务之中，如果当前没有事务，则会抛出异常
4. `REQUIRES_NEW`: 开启一个新的事务，如果当前已经有事务了，则将该事务暂停
5. `NOT_SUPPORTED`: 以非事务的方式执行，如果当前存在事务,则将该事务暂停
6. `NEVER`: 以非事务的方式执行，如果当前存在事务，则会抛出异常
7. `NESTED`:
   如果当前存在事务，则该方法应当运行在一个嵌套的事务中。嵌套在其中的事务可以独立地进行提交和回滚。如果外层事务不存则，则行为同`REQUIRED`

### 事务隔离级别

- 脏读：读取到没有提交到数据库的数据
- 不可重复读：第一次读取的数据和第二次读取的数据不一致
- 幻读：读取到的数据是假的

| 隔离级别 | 脏读 | 不可重复读 | 幻读 |
|------|----|-------|----|
| 读未提交 | 有  | 有     | 有  |
| 读提交  | 无  | 有     | 有  |
| 可重复读 | 无  | 无     | 有  |
| 序列化  | 无  | 无     | 无  |

### 事务超时

事务超时指在规定时间内，该事务的所有DML语句没有执行完毕的话，事务会回滚。

超时时间指最后一条DML语句执行之前的时间间隔

### 只读事务

只读事务是指**只能执行查询操作，不允许执行增删改操作的事务**

该属性的特点：Spring会启动优化策略，提高性能

### 异常选择

示例：

- `@Transactional(rollbackFor = {RuntimeException.class})` 表示遇到`RuntimeException`或其子类异常则回滚
- `@Transactional(noRollbackFor = {NullPointerException.class})` 表示遇到`NullPointerException`或其子类异常不回滚

