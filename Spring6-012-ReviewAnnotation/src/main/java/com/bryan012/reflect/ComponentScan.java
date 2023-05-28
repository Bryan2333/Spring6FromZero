package com.bryan012.reflect;

import com.bryan012.annotation.Component;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class ComponentScan {
    public static final Map<String, Object> beanMap = new HashMap<>();
    public static void main(String[] args) {
        // 扫描给定包的所有类，实例化所有具有@Component的类，并将其实例放到Map集合中
        String packageName = "com.bryan012.bean";

        // 开始编写扫描程序
        // . 在正则表达式中表示一个普通的字符
        String packagePath = packageName.replaceAll("\\.", "/");
        System.out.println(packagePath);

        // com是类根路径下的一个目录
        URL url = ClassLoader.getSystemClassLoader().getResource(packagePath);
        String path = url.getPath();
        System.out.println(path);

        // 获取一个绝对路径下的所有文件
        File file = new File(path);
        File[] files = file.listFiles();
        for (File f : files) {
            try {
                // System.out.println(f.getName());
                // System.out.println(f.getName().split("\\.")[0]);
                // 获取类名
                String className = packageName + "." + f.getName().split("\\.")[0];

                // 通过反射机制解析注解
                Class<?> aClass = Class.forName(className);

                // 判断类上是否有对应注解
                if (aClass.isAnnotationPresent(Component.class)) {
                    // 获取注解
                    Component annotation = aClass.getAnnotation(Component.class);
                    String id = annotation.value();

                    // 有对应注解的类创建对象
                    Object obj = aClass.getConstructor().newInstance();

                    // 将对象放入到集合中
                    beanMap.put(id, obj);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println(beanMap);
    }
}
