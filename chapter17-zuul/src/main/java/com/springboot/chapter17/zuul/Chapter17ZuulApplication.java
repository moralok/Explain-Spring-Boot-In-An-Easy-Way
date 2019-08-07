package com.springboot.chapter17.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
// 启动 Zuul 代理功能
@EnableZuulProxy
public class Chapter17ZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(Chapter17ZuulApplication.class, args);
    }

}
