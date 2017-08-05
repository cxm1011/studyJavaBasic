package com.reflect.basic;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by chen on 2017/8/4.
 */
public class Hello1CreateObject2 {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Class classType = Person.class;
        Constructor<Person> con = classType.getConstructor(String.class,int.class); //按照名称创建的类的构造器提供参数
        Person person = (Person) con.newInstance("tom",30);
        System.out.println(person.getName());

    }
}
