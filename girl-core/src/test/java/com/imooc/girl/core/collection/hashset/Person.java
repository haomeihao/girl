package com.imooc.girl.core.collection.hashset;

/**
 * Created by hmh on 2017/8/11.
 */
public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; //地址相等
        if (!(obj instanceof Person)) return false; //是否一个对象
        Person p = (Person)obj;
        if (this.name.equals(p.name) && this.age == p.age) return true;
        else return false;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() * this.age; //指定编码公式
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
