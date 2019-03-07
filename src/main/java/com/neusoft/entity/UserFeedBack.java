package com.neusoft.entity;

import java.util.Date;

/**
 * 用户反馈
 * 2019/3/7
 */
public class UserFeedBack {

    private String userFeedbackId; //id

    private String userId; //用户id

    private String msg; //反馈内容

    private String wechat;//联系方式

    private Date createTime;//创建时间

    public String getUserFeedbackId() {
        return userFeedbackId;
    }

    public void setUserFeedbackId(String userFeedbackId) {
        this.userFeedbackId = userFeedbackId == null ? null : userFeedbackId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat == null ? null : wechat.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}