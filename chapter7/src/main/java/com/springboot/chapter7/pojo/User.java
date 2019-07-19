package com.springboot.chapter7.pojo;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Alias("user")
public class User implements Serializable {

    private  static final long seriaLVersionUID = 7760614561073458247L;
    private Long id;
    private String userName;
    private String note;

    public static long getSeriaLVersionUID() {
        return seriaLVersionUID;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
