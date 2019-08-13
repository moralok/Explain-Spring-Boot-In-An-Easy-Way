package com.springboot.chapter15;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 定义扫描包
@SpringBootApplication(scanBasePackages = "com.springboot.chapter15")
// 定义扫描 MyBatis 接口
@MapperScan(annotationClass = Mapper.class, basePackages = "com.springboot.chapter15")
public class Chapter15Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter15Application.class, args);
    }

}
