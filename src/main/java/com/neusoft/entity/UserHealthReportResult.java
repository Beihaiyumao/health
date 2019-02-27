package com.neusoft.entity;

import java.util.Date;

/**
 * 用户健康报告结果
 * 2019/2/27
 */
public class UserHealthReportResult {

    private String healthReportResultUserId;//id

    private String healthReportId;//健康报告id

    private String userId;//用户id

    private double mark;//分值

    private Date createTime; //时间

    public String getHealthReportResultUserId() {
        return healthReportResultUserId;
    }

    public void setHealthReportResultUserId(String healthReportResultUserId) {
        this.healthReportResultUserId = healthReportResultUserId == null ? null : healthReportResultUserId.trim();
    }

    public String getHealthReportId() {
        return healthReportId;
    }

    public void setHealthReportId(String healthReportId) {
        this.healthReportId = healthReportId == null ? null : healthReportId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}