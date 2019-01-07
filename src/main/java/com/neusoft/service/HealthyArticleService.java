package com.neusoft.service;


import com.github.pagehelper.PageHelper;

import com.neusoft.DataDictionary.ArticleState;
import com.neusoft.dao.HealthyArticleMapper;
import com.neusoft.entity.ArticleComment;
import com.neusoft.entity.CollectionArticle;
import com.neusoft.entity.CommentReply;
import com.neusoft.entity.HealthyArticle;
import com.neusoft.tool.SystemTool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;

import java.util.List;

/***
 * 健康文章Service
 * 2018/12/21
 */
@Service
public class HealthyArticleService {
    @Autowired
    private HealthyArticleMapper healthyArticleMapper;

    /**
     * 新增文章
     *
     * @param healthyArticle
     * @return
     */
    public int addHealthyArticle(HealthyArticle healthyArticle) {
        healthyArticle.setArticleId(SystemTool.uuid());
        healthyArticle.setCreateTime(SystemTool.getDateTime());
        healthyArticle.setArticleState(ArticleState.ARTICLE_STATE_UNAUDITED.getCode());
        int code = healthyArticleMapper.insert(healthyArticle);
        return code;
    }

    /**
     * 模糊查询文章
     *
     * @param title
     * @return
     */
    public List<HealthyArticle> selectHealthyArticleByTitle(String title) {
        List<HealthyArticle> healthyArticleList = healthyArticleMapper.selectHealthyArticleByTitle(title);
        return healthyArticleList;
    }

    /**
     * 审核通过文章
     *
     * @param articleId
     * @return
     */
    public int passHealthyArticle(String articleId) {

        int code = healthyArticleMapper.passHealthyArticle(articleId, SystemTool.getDateTime());
        return code;
    }

    /**
     * 审核不通过文章
     *
     * @param articleId
     * @return
     */
    public int outHealthyArticle(String articleId) {
        int code = healthyArticleMapper.outHealthyArticle(articleId, SystemTool.getDateTime());
        return code;
    }

    /**
     * 根据文章id查询文章
     *
     * @param articleId
     * @return
     */
    public HealthyArticle selectHealthyArticleById(String articleId) {

        return healthyArticleMapper.selectHealthyArticleById(articleId);
    }

    /**
     * 修改文章
     *
     * @param healthyArticle
     * @return
     */
    public int updateHealthyArticle(HealthyArticle healthyArticle) {
        healthyArticle.setCreateTime(SystemTool.getDateTime());
        healthyArticle.setArticleState(ArticleState.ARTICLE_STATE_UNAUDITED.getCode());
        int code = healthyArticleMapper.updateHealthyArticle(healthyArticle);
        return code;
    }

    /**
     * 删除文章并删除下面的所有评论回复
     *
     * @param articleId
     * @return
     */
    public int deleteHealthyArticleById(String articleId) {
        if (selectArticleCommentByArticleId(articleId).size() > 0) {
            deleteArticleCommentByArticleId(articleId);
        }
        if (selectCommentRepiyByArticleId(articleId).size() > 0) {
            deleteCommentReplyByArticleId(articleId);
        }
        int code = healthyArticleMapper.deleteHealthyArticleById(articleId);
        return code;
    }

    /**
     * 评论文章
     *
     * @param articleComment
     * @return
     */
    public int insertArticleComment(ArticleComment articleComment) {
        articleComment.setCommentId(SystemTool.uuid());
        articleComment.setCreateTime(SystemTool.getDateTime());
        int code = healthyArticleMapper.insertArticleComment(articleComment);
        return code;
    }

    /**
     * 根据文章id查询该文章下的所有评论
     *
     * @param articleId
     * @return
     */
    public List<ArticleComment> selectArticleCommentByArticleId(String articleId) {
        List<ArticleComment> articleCommentList = healthyArticleMapper.selectArticleCommentByArticleId(articleId);
        return articleCommentList;
    }

    /**
     * 根据文章id删除该文章下的所有评论
     *
     * @param articleId
     * @return
     */
    public int deleteArticleCommentByArticleId(String articleId) {
        int code = healthyArticleMapper.deleteArticleCommentByArticleId(articleId);
        return code;
    }

    /**
     * 回复评论
     *
     * @param commentReply
     * @return
     */
    public int insertCommentReply(CommentReply commentReply) {
        commentReply.setReplyId(SystemTool.uuid());
        commentReply.setCreateTime(SystemTool.getDateTime());
        int code = healthyArticleMapper.insertCommentReply(commentReply);
        return code;
    }

    /**
     * 根据文章id查询该文章下的所有回复
     *
     * @param articleId
     * @return
     */
    public List<CommentReply> selectCommentRepiyByArticleId(String articleId) {
        return healthyArticleMapper.selectCommentRepiyByArticleId(articleId);
    }

    /**
     * 根据文章id删除该文章下的所有回复
     *
     * @param articleId
     * @return
     */
    public int deleteCommentReplyByArticleId(String articleId) {
        int code = healthyArticleMapper.deleteCommentReplyByArticleId(articleId);
        return code;
    }

    /**
     * 审核通过文章列表
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Page<HealthyArticle> selectHealthyArticle(Integer pageNum, Integer pageSize) {
        //用插件进行分页
        PageHelper.startPage(pageNum, pageSize);
        return healthyArticleMapper.selectHealthyArticle();
    }

    /**
     * 收藏文章
     *
     * @param collectionArticle
     * @return
     */
    public int collectionArticles(CollectionArticle collectionArticle) {
        collectionArticle.setCollectionArticleId(SystemTool.uuid());
        collectionArticle.setCreateTime(SystemTool.getDateTime());
        return healthyArticleMapper.collectionArticles(collectionArticle);
    }

    /**
     * 删除收藏的文章
     *
     * @param articleId
     * @return
     */
    public int deleteCollectionAritcleByArticleId(String articleId) {
        return healthyArticleMapper.deleteCollectionAritcleByArticleId(articleId);
    }

    /**
     * 我收藏的文章列表
     *
     * @param pageNum
     * @param pageSize
     * @param userId
     * @return
     */
    public Page<HealthyArticle> selectHealthyArticleByUserId(Integer pageNum, Integer pageSize, String userId) {
        PageHelper.startPage(pageNum, pageSize);
        return healthyArticleMapper.selectHealthyArticleByUserId(userId);
    }

    /**
     * 文章下所有评论分页
     *
     * @param pageNum
     * @param pageSize
     * @param articleId
     * @return
     */
    public Page<ArticleComment> selectArticleCommentPageByArticleId(Integer pageNum, Integer pageSize, String articleId) {
        PageHelper.startPage(pageNum, pageSize);
        return healthyArticleMapper.selectArticleCommentPageByArticleId(articleId);
    }

    /**
     * 根据评论id查询评论下的所有回复
     *
     * @param articleCommentId
     * @return
     */
    public List<CommentReply> selectCommentReplyByArticleCommentId(String articleCommentId) {
        return healthyArticleMapper.selectCommentReplyByArticleCommentId(articleCommentId);
    }
}
