package com.reflect;

/**
 * Created by chen on 2017/8/4.
 */
public class Person {
    public String name;
    public int age;
    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    public Person(){

    }

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
}
