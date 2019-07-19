package com.springboot.chapter8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

// 指定扫描的包
@SpringBootApplication(scanBasePackages = "com.springboot.chapter8")
// 指定扫描的包，用于扫描继承了 MongoRepository 的接口
@EnableMongoRepositories(
        // 扫描包
        basePackages = "com.springboot.chapter8.repository"
        // 使用自定义后缀，其默认值为 Impl
        // 此时需要修改类名：UserRepositoryImpl --> UserRepositoryStuff
        // repositoryImplementationPostfix = "stuff"
)
public class Chapter8Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter8Application.class, args);
    }

}
