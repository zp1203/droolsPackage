package com.drools.study.model;

/**
 * Created by zp on 2019/4/14.
 */
public class Person {

    /* 姓名 */
    private String name;
    /* 年龄 */
    private int age ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
