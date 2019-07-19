package com.springboot.chapter8.service;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.springboot.chapter8.pojo.User;

import java.util.List;

public interface UserService {

    public void saveUser(User user);

    public DeleteResult deleteUser(Long id);

    public List<User> findUser(String userName, String note, int skip, int limit);

    public UpdateResult updateUser(Long id, String userName, String note);

    public User getUser(Long id);
}
