package com.neusoft.entity;

import java.util.Date;

/**
 * 文章评论
 */
public class ArticleComment {
    private String commentId; //评论id

    private String articleId; //文章id

    private String content; //评论内容

    private String userId;  //用户id

    private Date createTime; //评论时间

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }


    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}