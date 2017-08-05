package com.reflect.ex1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by chen on 2017/8/5.
 */
public class Run {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Object obj = Class.forName("com.reflect.ex1.SomeObject").newInstance();
        SomeObject so = (SomeObject)obj;
        so.print();

        Method method = Class.forName("com.reflect.ex1.SomeObject").newInstance().getClass().getMethod("print");
        method.invoke(obj);
    }
}
