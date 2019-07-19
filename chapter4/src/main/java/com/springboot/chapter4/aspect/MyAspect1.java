package com.springboot.chapter4.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class MyAspect1 {

    @Pointcut("execution(* com.springboot.chapter4.aspect.service.impl.UserServiceImpl.manyAspects(..))")
    public void manyAspects() {

    }

    @Before("manyAspects()")
    public void before() {
        System.out.println("MyAspect1 before ……");
    }

    @Around("manyAspects()")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("MyAspect1 around before ……");
        // 回调目标对象的原有方法
        jp.proceed();
        System.out.println("MyAspect1 around after ……");
    }

    @After("manyAspects()")
    public void after() {
        System.out.println("MyAspect1 after ……");
    }

    @AfterReturning("manyAspects()")
    public void afterReturning() {
        System.out.println("MyAspect1 afterReturning ……");
    }

    @AfterThrowing("manyAspects()")
    public void afterThrowing() {
        System.out.println("MyAspect1 afterThrowing ……");
    }

    @Before("manyAspects()")
    public void beforeParam() {
        System.out.println("MyAspect1 beforeParam ……");
    }
}
