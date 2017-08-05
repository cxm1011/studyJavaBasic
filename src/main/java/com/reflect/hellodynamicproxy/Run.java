package com.reflect.hellodynamicproxy;

/**
 * Created by chen on 2017/8/5.
 */
public class Run {
    public static void main(String[] args){
       // System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles",true);
        DynamicProxyHandler handler = new DynamicProxyHandler();
        ServiceInf user = new UserServiceImpl();
        ServiceInf userProxy = (ServiceInf)handler.bind(user);
        userProxy.doSomeing(); //一旦绑定后，在进入代理对象方法调用时就会到DynamicProxyHandler的代理方法上，代理方法
                                //有三个参数，第一个是代理对象，第二个是当前调用的那个方法。第三个是方法的参数
    }
}
