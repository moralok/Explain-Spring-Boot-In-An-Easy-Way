package com.springboot.chapter17.product.service;

import com.springboot.chapter17.product.pojo.UserPo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 用户服务
 *
 * @author moralok
 * @date 2019/8/5
 */
// 指定服务 ID(Service ID)
@FeignClient("user")
public interface UserService {
    // 指定通过 HTTP 的 GET 方法请求路径
    @GetMapping("/user/{id}")
    // 这里会采用 Spring MVC 的注解配置
    UserPo getUser(@PathVariable("id") Long id);

    // POST 方法请求用户微服务
    @PostMapping("/insert")
    Map<String, Object> addUser(
            // 请求体参数
            @RequestBody UserPo user
    );

    // POST 方法请求用户微服务
    @PostMapping("/update/{userName}")
    Map<String, Object> updateName(
            // URL 参数
            @PathVariable("userName") String userName,
            // 请求头参数
            @RequestHeader("id") Long id
    );

    // 调用用户微服务的 timeout 请求
    @GetMapping("/timeout")
    String testTimeout();
}
