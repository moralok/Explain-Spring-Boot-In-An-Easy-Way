package com.springboot.chapter4.intercept;

import com.springboot.chapter4.invoke.Invocation;

import java.lang.reflect.InvocationTargetException;

public interface Interceptor {

    // 事前方法
    public boolean before();

    // 事后方法
    public void after();

    /**
     * 取代原有事件方法
     *
     * @param invocation
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public Object around(Invocation invocation) throws InvocationTargetException, IllegalAccessException;

    // 事后返回方法，事件没有发生异常执行
    public void afterReturning();

    // 事后异常方法，当事件发生异常后执行
    public void afterThrowing();

    // 是否使用 around 方法取代原有方法
    public boolean useAround();

}
