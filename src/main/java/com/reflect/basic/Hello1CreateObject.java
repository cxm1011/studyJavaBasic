package com.reflect.basic;

/**
 * Created by chen on 2017/8/4.
 */
public class Hello1CreateObject {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class classType = Class.forName("com.reflect.basic.Person");
        Object obj = classType.newInstance();

        Person tom = (Person)obj;
        tom.setName("Tom");

        System.out.println(tom.getName());
    }
}
