package com.springboot.chapter17.product.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.springboot.chapter17.product.pojo.UserPo;
import com.springboot.chapter17.product.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * 产品控制器
 *
 * @author moralok
 * @date 2019/8/5
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    // 注入 RestTemplate
    @Autowired
    private RestTemplate restTemplate = null;

    @Autowired
    private UserService userService = null;

    @GetMapping("/ribbon")
    public UserPo testRibbon() {
        UserPo user = null;
        // 循环 10 次，然后可以看到各个用户微服务后台的日志打印
        for (int i=0; i<10; i++) {
            // 注意，这里直接使用了 USER 这个服务 ID，代表用户微服务系统
            // 该 ID 通过属性 spring.application.name 来指定
            user = restTemplate.getForObject("http://USER/user/" + (i+1), UserPo.class);
        }
        return user;
    }

    @GetMapping("/feign")
    public UserPo testFeign() {
        UserPo user = null;
        // 循环 10 次，然后可以看到各个用户微服务后台的日志打印
        for (int i=0; i<10; i++) {
            Long id = (long) (i+1);
            user = userService.getUser(id);
        }
        return user;
    }

    @GetMapping("/feign2")
    public Map<String, Object> testFeign2() {
        Map<String, Object> result = null;
        UserPo user = null;
        for (int i=1; i<=10; i++) {
            Long id = (long) i;
            user = new UserPo();
            user.setId(id);
            user.setUserName("user_name_" + id);
            int level = i % 3 + 1;
            user.setLevel(level);
            user.setNote("note_" + i);
            result = userService.addUser(user);
        }
        return result;
    }

    @GetMapping("/feign3")
    public Map<String, Object> testFeign3() {
        Map<String, Object> result = null;
        for (int i=0; i<10; i++) {
            Long id = (long) i;
            String userName = "user_name_" + id;
            result = userService.updateName(userName, id);
        }
        return result;
    }

    // Ribbon 断路
    @GetMapping("/circuitBreaker1")
    @HystrixCommand(fallbackMethod = "error",
            commandProperties = {
                @HystrixProperty(
                        name = "execution.isolation.thread.timeoutInMilliseconds",
                        value = "30000"
                )
            })
    public String circuitBreaker1() {
        return restTemplate.getForObject("http://USER/timeout", String.class);
    }

    // Feign 断路测试
    @GetMapping("/circuitBreaker2")
    @HystrixCommand(fallbackMethod = "error")
    public String circuitBreaker2() {
        return userService.testTimeout();
    }

    // 降级服务方法
    public String error() {
        return "超时出错";
    }
}
