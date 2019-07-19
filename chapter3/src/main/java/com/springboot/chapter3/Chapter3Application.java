package com.springboot.chapter3;

import com.springboot.chapter3.config.AppConfig;
import com.springboot.chapter3.pojo.BusinessPerson;
import com.springboot.chapter3.pojo.ScopeBean;
import com.springboot.chapter3.pojo.UserByComponent;
import com.springboot.chapter3.pojo.User;
import com.springboot.chapter3.pojo.definition.Person;
import com.springboot.chapter3.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = {"classpath:jdbc.properties"}, ignoreResourceNotFound = true)
public class Chapter3Application {

//    private static Logger log = Logger.getLogger(Chapter3Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Chapter3Application.class, args);
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
//        User user = ctx.getBean(User.class);
//        System.out.println(user.getUserName());
//        UserByComponent userByComponent = ctx.getBean(UserByComponent.class);
//        System.out.println(userByComponent.getUserName());
//        UserService userService = ctx.getBean(UserService.class);
//        userService.printUser(user);
//        Person person = ctx.getBean(BusinessPerson.class);
//        person.service();

        // 关闭 IoC 容器
//        ((AnnotationConfigApplicationContext) ctx).close();

        ScopeBean scopeBean1 = ctx.getBean(ScopeBean.class);
        ScopeBean scopeBean2 = ctx.getBean(ScopeBean.class);
        System.out.println(scopeBean1 == scopeBean2);
    }

}
