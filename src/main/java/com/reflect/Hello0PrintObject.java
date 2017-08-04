package com.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by chen on 2017/8/4.
 */
public class Hello0PrintObject {
    public static void main(String[] args) throws ClassNotFoundException {
        Class c = Class.forName("com.reflect.Person");
        System.out.println("属性：");
        Field f[] = c.getDeclaredFields();
        for (int i = 0; i < f.length; i++) {
            System.out.println(f[i].getName());
        }

        System.out.println("方法：");
        Method[] m = c.getDeclaredMethods();
        for(int i=0;i<m.length;i++){
            System.out.println(m[i].toString());
        }
    }
}
