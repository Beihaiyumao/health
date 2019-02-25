package com.neusoft.entity;

import java.util.List;

/**
 * 调查问卷实体
 * 2019/2/25
 */
public class Questionnaire {

    private String healthReportId; //健康报告大类id

    private String healthReportTitle; //健康报告大类标题

    private String healthReportQuestionId;//健康报告问题id

    private String questionTitle; //问题标题

    private String answerType; //问题类型0:单选还是1:多选

    private List<HealthReportAnswers> healthReportAnswersList; //问题答案

    public String getHealthReportId() {
        return healthReportId;
    }

    public void setHealthReportId(String healthReportId) {
        this.healthReportId = healthReportId;
    }

    public String getHealthReportTitle() {
        return healthReportTitle;
    }

    public void setHealthReportTitle(String healthReportTitle) {
        this.healthReportTitle = healthReportTitle;
    }

    public String getHealthReportQuestionId() {
        return healthReportQuestionId;
    }

    public void setHealthReportQuestionId(String healthReportQuestionId) {
        this.healthReportQuestionId = healthReportQuestionId;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getAnswerType() {
        return answerType;
    }

    public void setAnswerType(String answerType) {
        this.answerType = answerType;
    }

    public List<HealthReportAnswers> getHealthReportAnswersList() {
        return healthReportAnswersList;
    }

    public void setHealthReportAnswersList(List<HealthReportAnswers> healthReportAnswersList) {
        this.healthReportAnswersList = healthReportAnswersList;
    }
}
