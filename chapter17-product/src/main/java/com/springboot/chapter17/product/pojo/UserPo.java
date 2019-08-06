package com.springboot.chapter17.product.pojo;

import java.io.Serializable;

/**
 * 用户
 *
 * @author moralok
 * @date 2019/8/5
 */
public class UserPo implements Serializable {

    private static final long serialVersionUID = -2535737897308758054L;

    private Long id;

    private String userName;

    // 1-白银会员，2-黄金会员，3-钻石会员
    private int level;

    private String note;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
