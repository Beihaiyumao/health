package com.neusoft.entity;
/**
 * 问题实体
 */

import java.util.Date;

public class Question {
    private String questionId; //问题id

    private String userId; // 提问者id

    private String title; //题目

    private String detail; // 详细内容

    private Date createTime; //创建时间

    private int sex; //提问者性别

    private String username;//提问者姓名

    private String questionGenre; //问题分类

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId == null ? null : questionId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getQuestionGenre() {
        return questionGenre;
    }

    public void setQuestionGenre(String questionGenre) {
        this.questionGenre = questionGenre;
    }
}