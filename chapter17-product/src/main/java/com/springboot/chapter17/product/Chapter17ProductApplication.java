package com.springboot.chapter17.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
// 启动 Feign
@EnableFeignClients(basePackages = "com.springboot.chapter17.product")
public class Chapter17ProductApplication {

    // 初始化 RestTemplate
    @LoadBalanced
    @Bean(name = "restTemplate")
    public RestTemplate initRestTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(Chapter17ProductApplication.class, args);
    }

}
