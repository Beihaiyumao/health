package com.neusoft.entity;

import java.util.Date;

/**
 * 医生对问题进行回复
 * 2019/1/3
 */
public class AnswerQuestion {

    private String answerId; //回答id

    private String questionId; //问题id

    private String answerDetail; //回答内容

    private String doctorId; //医生id

    private String doctorName; //医生名字

    private String userName; // 提问者名字

    private String title; //题目

    private String detail; // 详细内容

    private Date createTime; //创建时间

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getAnswerId() {
        return answerId;
    }

    public void setAnswerId(String answerId) {
        this.answerId = answerId == null ? null : answerId.trim();
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId == null ? null : questionId.trim();
    }

    public String getAnswerDetail() {
        return answerDetail;
    }

    public void setAnswerDetail(String answerDetail) {
        this.answerDetail = answerDetail == null ? null : answerDetail.trim();
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId == null ? null : doctorId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}