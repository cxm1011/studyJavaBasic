package com.reflect.hellodynamicproxy;

import javax.jws.Oneway;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by chen on 2017/8/5.
 */
public class DynamicProxyHandler implements InvocationHandler{
    private Object userObject;

    public Object bind(Object user){
        this.userObject = user;
        return Proxy.newProxyInstance(user.getClass().getClassLoader(),user.getClass().getInterfaces(),this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result;
        System.out.println("代理前。。。");
        result = method.invoke(userObject,args);
        System.out.println("代理后。。。");
        return result;
    }
}
