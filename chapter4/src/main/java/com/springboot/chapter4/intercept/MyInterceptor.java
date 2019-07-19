package com.springboot.chapter4.intercept;

import com.springboot.chapter4.invoke.Invocation;

import java.lang.reflect.InvocationTargetException;

public class MyInterceptor implements Interceptor {

    @Override
    public boolean before() {
        System.out.println("before ……");
        return true;
    }

    @Override
    public void after() {
        System.out.println("after ……");
    }

    @Override
    public Object around(Invocation invocation) throws InvocationTargetException, IllegalAccessException {
        System.out.println("around before ……");
        Object obj = invocation.proceed();
        System.out.println("around after ……");
        return obj;
    }

    @Override
    public void afterReturning() {
        System.out.println("aroundReturning ……");
    }

    @Override
    public void afterThrowing() {
        System.out.println("afterThrowing ……");
    }

    @Override
    public boolean useAround() {
        return true;
    }
}
