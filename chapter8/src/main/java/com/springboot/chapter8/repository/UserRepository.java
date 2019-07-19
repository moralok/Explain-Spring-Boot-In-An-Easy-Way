package com.springboot.chapter8.repository;

import com.springboot.chapter8.pojo.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// 标识为 DAO 层
@Repository
// 扩展 MongoRepository 接口
public interface UserRepository extends MongoRepository<User, Long> {
    /**
     * 符合 JPA 规范命名方法，则不需要再实现该方法也可用
     * 意在对满足条件的文档按照用户名称进行模糊查询
     * @param userName -- 用户名称
     * @return 满足条件的用户信息
     */
    List<User> findByUserNameLike(String userName);

    User findUserByIdOrUserName(Long id, String userName);
}
