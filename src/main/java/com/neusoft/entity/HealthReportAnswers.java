package com.neusoft.entity;

import java.util.Date;

/**
 * 报告问题选项
 * 2019/2/19
 */
public class HealthReportAnswers {

    private String healthReportAnswerId;//选项id

    private String healthReportQuestionId;//问题id

    private String optionContent;//选项内容

    private Integer mark;//分数

    private Date createTime;//创建时间

    public String getHealthReportAnswerId() {
        return healthReportAnswerId;
    }

    public void setHealthReportAnswerId(String healthReportAnswerId) {
        this.healthReportAnswerId = healthReportAnswerId == null ? null : healthReportAnswerId.trim();
    }

    public String getHealthReportQuestionId() {
        return healthReportQuestionId;
    }

    public void setHealthReportQuestionId(String healthReportQuestionId) {
        this.healthReportQuestionId = healthReportQuestionId == null ? null : healthReportQuestionId.trim();
    }

    public String getOptionContent() {
        return optionContent;
    }

    public void setOptionContent(String optionContent) {
        this.optionContent = optionContent == null ? null : optionContent.trim();
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}