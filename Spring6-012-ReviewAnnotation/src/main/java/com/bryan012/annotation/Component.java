package com.bryan012.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
    1. 标注注解的注解，叫做元注解 @Target用来修饰@Component可以出现的位置

    2. 表示@Component可以出现在类上

    3. 使用注解时，如果注解的属性名是value的话，value可以省略

    4. 使用注解时，如果注解的属性值是数组的话，并且数组中只有一个元素，则大括号可以省略
*/

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Component {

    // 定义注解的属性
    // String是属性类型
    // value是属性名
    String value();

//    String[] names();
}