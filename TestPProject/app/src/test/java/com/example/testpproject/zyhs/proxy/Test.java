package com.example.testpproject.zyhs.proxy;

import java.lang.reflect.Proxy;

public class Test {


    @org.junit.Test
    public void test() {

        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");


        ChinaFactory chinaFactory = new ChinaFactory();

        InvocationHandlerImpl invocationHandler = new InvocationHandlerImpl(chinaFactory);


        ClassLoader classLoader = chinaFactory.getClass().getClassLoader();
        Class<?>[] interfaces = chinaFactory.getClass().getInterfaces();

        Factory proxyFactory = (Factory) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);

        proxyFactory.createDipan();

//        System.out.println("目标对象1：" + chinaFactory.getClass().getSimpleName());
//        System.out.println("代理对象1：" + proxyFactory.getClass().getSimpleName());

    }


}
