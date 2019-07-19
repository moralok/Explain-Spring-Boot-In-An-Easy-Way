package com.springboot.chapter4.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;

@Aspect
@Order(1)
public class MyAspect3 {

    @Pointcut("execution(* com.springboot.chapter4.aspect.service.impl.UserServiceImpl.manyAspects(..))")
    public void manyAspects() {

    }

    @Before("manyAspects()")
    public void before() {
        System.out.println("MyAspect3 before ……");
    }

    @Around("manyAspects()")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("MyAspect3 around before ……");
        // 回调目标对象的原有方法
        jp.proceed();
        System.out.println("MyAspect3 around after ……");
    }

    @After("manyAspects()")
    public void after() {
        System.out.println("MyAspect3 after ……");
    }

    @AfterReturning("manyAspects()")
    public void afterReturning() {
        System.out.println("MyAspect3 afterReturning ……");
    }

    @AfterThrowing("manyAspects()")
    public void afterThrowing() {
        System.out.println("MyAspect3 afterThrowing ……");
    }

    @Before("manyAspects()")
    public void beforeParam() {
        System.out.println("MyAspect3 beforeParam ……");
    }
}
