package com.neusoft.entity;

import java.util.Date;

/**
 * 健康日志-运动日志
 * 2019/2/26
 */
public class HealthDiarySport {

    private String healthDiarySportId; //id

    private String sportType;//运动类型

    private String sportName;//运动名称

    private Date sportTime;//运动日期

    private double sportDuration;//运动时长

    private Date createTime;//创建时间

    private String userId;//用户id

    public String getHealthDiarySportId() {
        return healthDiarySportId;
    }

    public void setHealthDiarySportId(String healthDiarySportId) {
        this.healthDiarySportId = healthDiarySportId == null ? null : healthDiarySportId.trim();
    }

    public String getSportType() {
        return sportType;
    }

    public void setSportType(String sportType) {
        this.sportType = sportType == null ? null : sportType.trim();
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName == null ? null : sportName.trim();
    }

    public Date getSportTime() {
        return sportTime;
    }

    public void setSportTime(Date sportTime) {
        this.sportTime = sportTime;
    }

    public double getSportDuration() {
        return sportDuration;
    }

    public void setSportDuration(double sportDuration) {
        this.sportDuration = sportDuration;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }
}