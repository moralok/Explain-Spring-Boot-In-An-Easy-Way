package com.springboot.chapter5.controller;

import com.springboot.chapter5.pojo.User;
import com.springboot.chapter5.service.JdbcTmplUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/jdbcTmpl")
public class JdbcTmplController {

    @Autowired
    private JdbcTmplUserService jdbcTmplUserService = null;

    @RequestMapping("/getUser")
    @ResponseBody
    public User getUser(Long id) {
        User user = jdbcTmplUserService.getUser(id);
        return user;
    }
}
