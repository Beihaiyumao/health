package com.neusoft.entity;

import java.util.Date;

/**
 * 问卷问题
 * 2019/2/18
 */
public class HealthReportQuestion {

    private String healthReportQuestionId;//id

    private String questionTitle; //问题标题

    private String healthReportId; //报告大类

    private String answerType; //问题类型0:单选还是1:多选

    private Date createTime; //创建时间

    public String getHealthReportQuestionId() {
        return healthReportQuestionId;
    }

    public void setHealthReportQuestionId(String healthReportQuestionId) {
        this.healthReportQuestionId = healthReportQuestionId == null ? null : healthReportQuestionId.trim();
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle == null ? null : questionTitle.trim();
    }

    public String getHealthReportId() {
        return healthReportId;
    }

    public void setHealthReportId(String healthReportId) {
        this.healthReportId = healthReportId == null ? null : healthReportId.trim();
    }

    public String getAnswerType() {
        return answerType;
    }

    public void setAnswerType(String answerType) {
        this.answerType = answerType == null ? null : answerType.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}