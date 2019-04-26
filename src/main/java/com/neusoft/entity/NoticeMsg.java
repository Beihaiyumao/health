package com.neusoft.entity;

import java.util.Date;

/**
 * 用户通知栏
 */
public class NoticeMsg {
    private String noticeMsgId;

    private String msg;

    private String state;

    private Date createTime;

    public String getNoticeMsgId() {
        return noticeMsgId;
    }

    public void setNoticeMsgId(String noticeMsgId) {
        this.noticeMsgId = noticeMsgId == null ? null : noticeMsgId.trim();
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}