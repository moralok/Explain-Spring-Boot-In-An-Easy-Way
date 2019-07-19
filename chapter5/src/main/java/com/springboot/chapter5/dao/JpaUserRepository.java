package com.springboot.chapter5.dao;

import com.springboot.chapter5.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JpaUserRepository extends JpaRepository<User, Long> {
    @Query("from user where user_name like concat('%', ?1, '%') " +
            "and note like concat('%', ?2, '%')")
    public List<User> findUsers(String userName, String note);

    /**
     * 按用户名称模糊查询
     * @param userName 用户名
     * @return
     */
    public List<User> findByUserNameLike(String userName);

    /**
     * 根据主键查询
     * @param id -- 主键
     * @return
     */
    public User getUserById(Long id);

    public List<User> findByUserNameLikeOrNoteLike(String userName, String note);
}
