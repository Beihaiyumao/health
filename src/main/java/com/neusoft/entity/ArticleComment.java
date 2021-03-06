package com.neusoft.entity;

import java.util.Date;
import java.util.List;

/**
 * 文章评论
 */
public class ArticleComment {
    private String commentId; //评论id

    private String articleId; //文章id

    private String content; //评论内容

    private String userId;  //用户id

    private Date createTime; //评论时间

    private String userName; //评论用户名

    private String headPhoto; //用户头像

    private String articleName; //所属文章名称

    private String email; //评论者邮箱

    private List<CommentReply> commentReply; //评论回复

    public String getHeadPhoto() {
        return headPhoto;
    }

    public void setHeadPhoto(String headPhoto) {
        this.headPhoto = headPhoto;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

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

    public List<CommentReply> getCommentReply() {
        return commentReply;
    }

    public void setCommentReply(List<CommentReply> commentReply) {
        this.commentReply = commentReply;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}