package com.springboot.chapter5.service.impl;

import com.springboot.chapter5.dao.MyBatisUserDao;
import com.springboot.chapter5.pojo.User;
import com.springboot.chapter5.service.MyBatisUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyBatisUserServiceImpl implements MyBatisUserService {

    @Autowired
    private MyBatisUserDao myBatisUserDao = null;

    @Override
    public User getUser(Long id) {
        return myBatisUserDao.getUser(id);
    }
}
