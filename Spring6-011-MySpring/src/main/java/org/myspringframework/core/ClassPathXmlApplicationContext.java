package org.myspringframework.core;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassPathXmlApplicationContext implements ApplicationContext {


    public static final Logger logger = LoggerFactory.getLogger(ClassPathXmlApplicationContext.class);

    private final Map<String, Object> singletonObjects = new HashMap<>();

    // 解析spring配置文件，并初始化所有bean对象
    public ClassPathXmlApplicationContext(String configLocation) {
        // 解析spring配置文件，实例化bean对象，将bean对象放入到singletonObjects集合中
        try {
            // dom4j解析xml的文件的核心对象
            SAXReader saxReader = new SAXReader();

            // 获取一个输入流，指向配置文件
            // getSystemClassLoader只适合配置文件在类路径下
            InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream(configLocation);

            // 读取文件
            Document read = saxReader.read(in);

            // 获取文件中的所有bean标签
            List<Node> nodes = read.selectNodes("//bean");

            // 遍历bean标签
            for (Node node : nodes) {
                try {
                    // System.out.println(node);
                    // 向下转向是为了使用Element接口中的方法
                    Element nodeElt = (Element) node;

                    // 获取bean的ID
                    String id = nodeElt.attributeValue("id");
                    // 获取bean的Class
                    String className = nodeElt.attributeValue("class");
                    logger.info("bean id = " + id);
                    logger.info("bean class = " + className);

                    // 根据class名获取Class对象
                    Class<?> aClass = Class.forName(className);

                    // 获取无参构造函数
                    Constructor<?> declaredConstructor = aClass.getDeclaredConstructor();

                    // 通过无参构造函数创建对象
                    Object obj = declaredConstructor.newInstance();

                    singletonObjects.put(id, obj);
                    logger.info(singletonObjects.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            // 在将nodes集合遍历一次，给bean对象赋值
            for (Node node : nodes) {
                Element nodeElt = (Element) node;
                String id = nodeElt.attributeValue("id");
                String className = nodeElt.attributeValue("class");
                try {
                    Class<?> aClass = Class.forName(className);
                    // 获取bean标签中的所有property标签
                    List<Element> properties = nodeElt.elements("property");

                    for (Element property : properties) {
                        try {
                            String propertyName = property.attributeValue("name");
                            // logger.info("propertyName = " + proName);

                            // 获取属性
                            Field field = aClass.getDeclaredField(propertyName);

                            // 获取set方法名
                            String setMethodName = "set" + propertyName.toUpperCase().charAt(0) +
                                    propertyName.substring(1);

                            // 根据属性类型获取set方法
                            Method setProName = aClass.getDeclaredMethod(setMethodName, field.getType());

                            // 获取具体的属性值
                            String value = property.attributeValue("value");
                            String ref = property.attributeValue("ref");

                            if (value != null) {
                                // value不为空说明值类型是简单类型
                                // 获取类型名
                                Object realValue = null;
                                String propertyTypeSimpleName = field.getType().getSimpleName();
                                switch (propertyTypeSimpleName) {
                                    case "byte", "Byte" -> realValue = Byte.parseByte(value);

                                    case "short", "Short" -> realValue = Short.parseShort(value);

                                    case "int", "Integer" -> realValue = Integer.parseInt(value);

                                    case "long", "Long" -> realValue = Long.parseLong(value);

                                    case "float", "Float" -> realValue = Float.parseFloat(value);

                                    case "double", "Double" -> realValue = Double.parseDouble(value);

                                    case "boolean", "Boolean" -> realValue = Boolean.parseBoolean(value);

                                    case "char", "Character" -> realValue = value.charAt(0);

                                    case "String" -> realValue = value;

                                }
                                setProName.invoke(singletonObjects.get(id), realValue);
                            }

                            if (ref != null) {
                                // ref不为空说明值类型是复杂类型
                                setProName.invoke(singletonObjects.get(id), singletonObjects.get(ref));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (DocumentException documentException) {
            documentException.printStackTrace();
        }
    }

    @Override
    public Object getBean(String beanName) {
        return singletonObjects.get(beanName);
    }
}
