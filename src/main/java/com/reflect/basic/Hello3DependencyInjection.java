package com.reflect.basic;

import java.lang.reflect.Field;

/**
 * Created by chen on 2017/8/4.
 */
public class Hello3DependencyInjection {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Person person = new Person();
        Class c = person.getClass();
        Person e = (Person)c.newInstance();

        e.setName("cxm");
        System.out.println(e.getName());

        Field[] f  = c.getDeclaredFields();
        for(int i=0;i<f.length;i++){
            if(f[i].getName().equals("name")){
                f[i].set(person,"tom");
            }
            if(f[i].getName().equals("age")){
                f[i].set(person,30);
            }
        }
        System.out.println(person.getName()+person.getAge());
    }
}
