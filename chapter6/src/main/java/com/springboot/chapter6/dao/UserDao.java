package com.springboot.chapter6.dao;

import com.springboot.chapter6.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    User getUser(Long id);

    int insertUser(User user);
}
