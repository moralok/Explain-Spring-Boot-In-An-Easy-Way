package com.springboot.chapter4;

import com.springboot.chapter4.aspect.MyAspect;
import com.springboot.chapter4.aspect.MyAspect1;
import com.springboot.chapter4.aspect.MyAspect2;
import com.springboot.chapter4.aspect.MyAspect3;
import com.springboot.chapter4.intercept.MyInterceptor;
import com.springboot.chapter4.proxy.ProxyBean;
import com.springboot.chapter4.service.HelloService;
import com.springboot.chapter4.service.impl.HelloServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication(scanBasePackages = {"com.springboot.chapter4.aspect"})
@EnableAspectJAutoProxy
public class Chapter4Application {

    // 定义切面
    @Bean(name = "myAspect")
    public MyAspect initMyAspect() {
        return new MyAspect();
    }

    // 定义切面
    @Bean(name = "myAspect1")
    public MyAspect1 initMyAspect1() {
        return new MyAspect1();
    }

    // 定义切面
    @Bean(name = "myAspect2")
    public MyAspect2 initMyAspect2() {
        return new MyAspect2();
    }

    // 定义切面
    @Bean(name = "myAspect3")
    public MyAspect3 initMyAspect3() {
        return new MyAspect3();
    }

    public static void main(String[] args) {
        SpringApplication.run(Chapter4Application.class, args);
//        testProxy();
    }

//    private static void testProxy() {
//        HelloService helloService = new HelloServiceImpl();
//        HelloService proxy = (HelloService) ProxyBean.getProxyBean(helloService, new MyInterceptor());
//        proxy.sayHello("zhangsan");
//        System.out.println("\n########################name is null!!###################\n");
//        proxy.sayHello(null);
//    }
}
