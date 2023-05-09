package com.bryan9.spring6.bean2;

/*
*   妻子类
*
*/
public class Wife2 {
    private String name;

    private Husband2 husband;

    public Wife2(String name, Husband2 husband) {
        this.name = name;
        this.husband = husband;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Wife{" +
                "name='" + name + '\'' +
                ", husband=" + husband.getName() +
                '}';
    }
}
