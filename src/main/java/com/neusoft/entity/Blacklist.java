package com.neusoft.entity;

import java.util.Date;

/**
 * 黑名单
 * 2018/12/29
 */
public class Blacklist {

    private String blacklistId; //黑名单id

    private String userId; //用户id

    private String email; //用户邮箱

    private String msg; //拉黑原因

    private Date createTime; //拉黑时间

    private String role; //角色

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getBlacklistId() {
        return blacklistId;
    }

    public void setBlacklistId(String blacklistId) {
        this.blacklistId = blacklistId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
