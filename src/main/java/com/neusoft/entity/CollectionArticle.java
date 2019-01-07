package com.neusoft.entity;
/**
 * 收藏文章
 * 2018/12/26
 */

import java.util.Date;

public class CollectionArticle {
    private String collectionArticleId; //收藏id

    private String userId; //当前用户id

    private String articleId; //文章id

    private Date createTime; //收藏时间

    public String getCollectionArticleId() {
        return collectionArticleId;
    }

    public void setCollectionArticleId(String collectionArticleId) {
        this.collectionArticleId = collectionArticleId == null ? null : collectionArticleId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId == null ? null : articleId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}