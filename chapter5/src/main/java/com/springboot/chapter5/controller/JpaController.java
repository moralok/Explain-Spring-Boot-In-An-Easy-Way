package com.springboot.chapter5.controller;

import com.springboot.chapter5.dao.JpaUserRepository;
import com.springboot.chapter5.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/jpa")
public class JpaController {
    // 注入 JPA 接口，这里不需要使用实体类
    @Autowired
    private JpaUserRepository jpaUserRepository = null;

    @RequestMapping("/getUser")
    @ResponseBody
    public User getUser(Long id) {
        // 使用 JPA 接口查询对象
        User user = jpaUserRepository.findById(id).get();
        return user;
    }

    @RequestMapping("/getUserById")
    @ResponseBody
    public User getUserById(Long id) {
        // 使用 JPA 接口查询对象
        User user = jpaUserRepository.getUserById(id);
        return user;
    }

    @RequestMapping("/findByUserNameLike")
    @ResponseBody
    public List<User> findByUserNameLike(String userName) {
        // 使用 JPA 接口查询对象
        List<User> userList = jpaUserRepository.findByUserNameLike(userName);
        return userList;
    }

    @RequestMapping("/findByUserNameLikeOrNoteLike")
    @ResponseBody
    public List<User> findByUserNameLikeOrNoteLike(String userName, String note) {
        String userNameLike = "%" + userName + "%";
        String noteLike = "%" + note + "%";
        // 使用 JPA 接口查询对象
        List<User> userList = jpaUserRepository.findByUserNameLikeOrNoteLike(userNameLike, noteLike);
        return userList;
    }
}
