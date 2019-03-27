package com.neusoft.entity;

import java.util.Date;

/**
 * 文章分类
 */
public class HealthArticleGenre {
    private String healthyArticleGenreId; //id

    private String articleGenreCode;

    private String articleGenreName;

    private Date createTime;

    public String getHealthyArticleGenreId() {
        return healthyArticleGenreId;
    }

    public void setHealthyArticleGenreId(String healthyArticleGenreId) {
        this.healthyArticleGenreId = healthyArticleGenreId == null ? null : healthyArticleGenreId.trim();
    }

    public String getArticleGenreCode() {
        return articleGenreCode;
    }

    public void setArticleGenreCode(String articleGenreCode) {
        this.articleGenreCode = articleGenreCode == null ? null : articleGenreCode.trim();
    }

    public String getArticleGenreName() {
        return articleGenreName;
    }

    public void setArticleGenreName(String articleGenreName) {
        this.articleGenreName = articleGenreName == null ? null : articleGenreName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}