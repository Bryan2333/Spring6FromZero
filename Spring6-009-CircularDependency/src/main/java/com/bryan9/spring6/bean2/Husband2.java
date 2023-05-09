package com.bryan9.spring6.bean2;

/*
*   丈夫类
*
*/
public class Husband2 {

    private String name;

    private Wife2 wife;

    public Husband2(String name, Wife2 wife) {
        this.name = name;
        this.wife = wife;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Husband{" +
                "name='" + name + '\'' +
                ", wife=" + wife.getName() +
                '}';
    }
}
