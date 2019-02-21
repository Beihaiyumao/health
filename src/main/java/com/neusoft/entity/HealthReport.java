package com.neusoft.entity;

import java.util.Date;

/**
 * 健康报告大类
 * 2019/2/18
 */
public class HealthReport {

    private String healthReportId; //id

    private String title; //标题

    private String description;//介绍

    private Date createTime;//创建时间

    public String getHealthReportId() {
        return healthReportId;
    }

    public void setHealthReportId(String healthReportId) {
        this.healthReportId = healthReportId == null ? null : healthReportId.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}