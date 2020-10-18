package com.example.testpproject.zyhs.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class InvocationHandlerImpl implements InvocationHandler {


    public Object mRealObject;


    public InvocationHandlerImpl(Object mRealObject) {
        this.mRealObject = mRealObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("proxy invoke, proxy = " + proxy.getClass() + ", realObject = " + mRealObject.getClass());


        Object invoke = method.invoke(mRealObject, args);

        return invoke;
    }
}
