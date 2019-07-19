package com.springboot.chapter9.service.impl;

import com.springboot.chapter9.dao.UserDao;
import com.springboot.chapter9.pojo.User;
import com.springboot.chapter9.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao = null;

    @Override
    public User getUser(Long id) {
        return userDao.getUser(id);
    }

    @Override
    public List<User> findUsers(String userName, String note) {
        return userDao.findUsers(userName, note);
    }

    @Override
    public User insertUser(User user) {
        userDao.insertUser(user);
        return user;
    }

    @Override
    public User updateUser(Long id, String userName) {
        User user = this.getUser(id);
        if (user == null) {
            return null;
        }
        user.setUserName(userName);
        userDao.updateUser(user);
        return user;
    }

    @Override
    public int deleteUser(Long id) {
        return userDao.deleteUser(id);
    }
}