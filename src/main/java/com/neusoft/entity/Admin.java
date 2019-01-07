package com.neusoft.entity;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

public class Admin {
    private String username; //用户名

    private String password; //密码

    private String adminId; //id

    private Date createTime; //注册时间

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
