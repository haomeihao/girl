package com.imooc.girl.core.rpc.httpclient;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by hmh on 2017/8/28.
 */
public class Person implements Serializable{

    private String name;
    private Integer age;
    private Date birth;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birth=" + birth +
                ", address='" + address + '\'' +
                '}';
    }
}
