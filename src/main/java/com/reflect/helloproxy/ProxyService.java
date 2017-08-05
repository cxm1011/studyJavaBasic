package com.reflect.helloproxy;

/**
 * Created by chen on 2017/8/5.
 */
public class ProxyService {
    public UserServiceImpl userService;  //被代理对象

    public ProxyService(UserServiceImpl businessClass){
        this.userService = businessClass;
    }

    public void doSomeing(){
        System.out.println("运行前时间");
        this.userService.doSomeing();
        System.out.println("运行后时间");
    }
}
