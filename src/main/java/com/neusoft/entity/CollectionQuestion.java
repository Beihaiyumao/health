package com.neusoft.entity;

import java.util.Date;

/**
 * 用户收藏问题
 * 2019/3/10
 */
public class CollectionQuestion {

    private String collectionQuestionId;

    private String userId;

    private String questionId;

    private Date createTime;

    public String getCollectionQuestionId() {
        return collectionQuestionId;
    }

    public void setCollectionQuestionId(String collectionQuestionId) {
        this.collectionQuestionId = collectionQuestionId == null ? null : collectionQuestionId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId == null ? null : questionId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}