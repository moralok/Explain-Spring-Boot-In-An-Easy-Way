package com.springboot.chapter4.aspect.validator;

import com.springboot.chapter4.pojo.User;

public interface UserValidator {
    // 检测用户对象是否为空
    public boolean validate(User user);
}
