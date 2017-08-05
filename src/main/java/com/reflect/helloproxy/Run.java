package com.reflect.helloproxy;

/**
 * Created by chen on 2017/8/5.
 */
public class Run {
    public static void main(String[] args){
        ProxyService proxyService = new ProxyService(new UserServiceImpl());
        proxyService.doSomeing();
    }
}
