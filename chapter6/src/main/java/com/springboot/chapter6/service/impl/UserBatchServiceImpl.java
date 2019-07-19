package com.springboot.chapter6.service.impl;

import com.springboot.chapter6.pojo.User;
import com.springboot.chapter6.service.UserBatchService;
import com.springboot.chapter6.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserBatchServiceImpl implements UserBatchService {

    @Autowired
    private UserService userService = null;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public int insertUsers(List<User> users) {
        int count = 0;
        for (User user : users) {
            // 调用子方法，将使用 @Transactional 定义的传播行为
            count += userService.insertUser(user);
        }
        return count;
    }
}
