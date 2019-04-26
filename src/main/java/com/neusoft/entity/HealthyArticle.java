package com.neusoft.entity;

import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/***
 * 健康文章
 * 2018/12/21
 */
public class HealthyArticle {
    private String articleId; //文章id

    private String title; //标题

    private String pic; //图片

    private String author; //作者

    private String article; //导语

    private String content; //内容

    private String articleState; //文章审核状态

    private Date createTime; //创建时间

    private Date changeAtricleStateTime; //更改审核状态时间

    private String articleGenre; //文章分类

    private String createUserId; //创建者id

    private String createUserRole; //创建者身份

    private Integer likeAll;

    private Integer commentAll;

    public Integer getLikeAll() {
        return likeAll;
    }

    public void setLikeAll(Integer likeAll) {
        this.likeAll = likeAll;
    }

    public Integer getCommentAll() {
        return commentAll;
    }

    public void setCommentAll(Integer commentAll) {
        this.commentAll = commentAll;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article == null ? null : article.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getArticleState() {
        return articleState;
    }

    public void setArticleState(String articleState) {
        this.articleState = articleState;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getChangeAtricleStateTime() {
        return changeAtricleStateTime;
    }

    public void setChangeAtricleStateTime(Date changeAtricleStateTime) {
        this.changeAtricleStateTime = changeAtricleStateTime;
    }

    public String getArticleGenre() {
        return articleGenre;
    }

    public void setArticleGenre(String articleGenre) {
        this.articleGenre = articleGenre;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateUserRole() {
        return createUserRole;
    }

    public void setCreateUserRole(String createUserRole) {
        this.createUserRole = createUserRole;
    }

}