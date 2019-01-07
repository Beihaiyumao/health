package com.neusoft.entity;

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
}