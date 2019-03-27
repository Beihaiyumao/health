package com.neusoft.entity;

import java.util.Date;

/**
 * 问题分类
 */
public class HealthQuestionGenre {
    private String healthyQuestionGenreId; //id

    private String questionGenreCode; //问题类别code

    private String questionGenreName; //问题类别name

    private Date createTime; //创建时间

    public String getHealthyQuestionGenreId() {
        return healthyQuestionGenreId;
    }

    public void setHealthyQuestionGenreId(String healthyQuestionGenreId) {
        this.healthyQuestionGenreId = healthyQuestionGenreId == null ? null : healthyQuestionGenreId.trim();
    }

    public String getQuestionGenreCode() {
        return questionGenreCode;
    }

    public void setQuestionGenreCode(String questionGenreCode) {
        this.questionGenreCode = questionGenreCode == null ? null : questionGenreCode.trim();
    }

    public String getQuestionGenreName() {
        return questionGenreName;
    }

    public void setQuestionGenreName(String questionGenreName) {
        this.questionGenreName = questionGenreName == null ? null : questionGenreName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}