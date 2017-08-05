package com.reflect.basic;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by chen on 2017/8/4.
 */
public class Hello2CallWay {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Person p = new Person();
        Method method = Person.class.getMethod("setName", String.class);

        method.invoke(p,"cxm");

        System.out.println("使用反射操作setName方法后，Person对象的name值是："+p.getName());
    }
}
