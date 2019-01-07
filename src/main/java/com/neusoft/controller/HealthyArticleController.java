package com.neusoft.controller;

import com.github.pagehelper.Page;
import com.neusoft.dao.HealthyArticleMapper;
import com.neusoft.entity.*;
import com.neusoft.service.HealthyArticleService;
import com.neusoft.tool.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;


/***
 * 健康文章Controller
 * 2018/12/21
 */
@RestController
@RequestMapping("/healthyArticle")
public class HealthyArticleController {
    @Autowired
    private HealthyArticleService healthyArticleService;
    @Autowired
    private HealthyArticleMapper healthyArticleMapper;


    /***
     * 新增健康文章
     * @param healthyArticle
     */
    @RequestMapping(value = "/addHealthyArticle", method = RequestMethod.POST)
    public Result addHealthyArticle(@RequestBody HealthyArticle healthyArticle) {
        int code = healthyArticleService.addHealthyArticle(healthyArticle);
        if (code == 1) {
            return new Result(100, "发布文章成功", true);
        } else {
            return new Result(200, "发布文章失败", false);
        }
    }

    /**
     * 模糊查询文章
     *
     * @param title
     */
    @RequestMapping(value = "/selectHealthyArticleByTitle", method = RequestMethod.POST)
    public List<HealthyArticle> selectHealthyArticleByTitle(@RequestParam("title") String title) {
        List<HealthyArticle> healthyArticleList = healthyArticleService.selectHealthyArticleByTitle(title);
        return healthyArticleList;
    }

    /**
     * 审核通过文章
     *
     * @param articleId
     * @return
     */
    @RequestMapping(value = "/passHealthyArticle", method = RequestMethod.POST)
    public Result passHealthyArticle(@RequestParam("articleId") String articleId) {
        int code = healthyArticleService.passHealthyArticle(articleId);
        if (code == 1) {
            return new Result(100, "审核通过操作成功", true);
        } else {
            return new Result(200, "审核通过操作失败", false);
        }
    }

    /**
     * 审核不通过文章
     *
     * @param articleId
     * @return
     */
    @RequestMapping(value = "/outHealthyArticle", method = RequestMethod.POST)
    public Result outHealthyArticle(@RequestParam("articleId") String articleId) {
        int code = healthyArticleService.outHealthyArticle(articleId);
        if (code == 1) {
            return new Result(100, "审核不通过操作成功", true);
        } else {
            return new Result(200, "审核不通过操作失败", false);
        }
    }

    /**
     * 根据文章id查询文章
     *
     * @param articleId
     * @return
     */
    @RequestMapping(value = "/selectHealthyArticleById", method = RequestMethod.POST)
    public HealthyArticle selectHealthyArticleById(@RequestParam("articleId") String articleId) {
        return healthyArticleService.selectHealthyArticleById(articleId);
    }

    /**
     * 更新文章
     *
     * @param healthyArticle
     * @return
     */
    @RequestMapping(value = "/updateHealthyArticle", method = RequestMethod.POST)
    public Result updateHealthyArticle(@RequestBody HealthyArticle healthyArticle) {
        int code = healthyArticleService.updateHealthyArticle(healthyArticle);
        if (code == 1) {
            return new Result(100, "更新成功", true);
        } else {
            return new Result(200, "更新失败", false);
        }
    }

    /**
     * 删除文章
     *
     * @param articleId
     * @return
     */
    @RequestMapping(value = "deleteHealthyArticleById", method = RequestMethod.POST)
    public Result deleteHealthyArticleById(@RequestParam("articleId") String articleId) {
        int code = healthyArticleService.deleteHealthyArticleById(articleId);
        if (code == 1) {
            return new Result(100, "删除成功", true);
        } else {
            return new Result(200, "删除失败", false);
        }
    }

    /**
     * 文章评论
     *
     * @param articleComment
     * @return
     */
    @RequestMapping(value = "/insertArticleComment", method = RequestMethod.POST)
    public Result insertArticleComment(@RequestBody ArticleComment articleComment) {
        int code = healthyArticleService.insertArticleComment(articleComment);
        if (code == 1) {
            return new Result(100, "评论成功", true);
        } else {
            return new Result(200, "评论失败", false);
        }
    }

    /**
     * 文章评论回复
     *
     * @param commentReply
     * @return
     */
    @RequestMapping(value = "/insertCommentReply", method = RequestMethod.POST)
    public Result insertCommentReply(@RequestBody CommentReply commentReply) {
        int code = healthyArticleService.insertCommentReply(commentReply);
        if (code == 1) {
            return new Result(100, "回复成功", true);
        } else {
            return new Result(200, "回复失败", false);
        }
    }

    /**
     * 审核通过文章列表
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/healthyArticle", method = RequestMethod.POST)
    public PageInfo<HealthyArticle> selectHealthyArticle(@RequestParam(defaultValue = "1", value = "currentPage") Integer pageNum,
                                                         @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize) {
        Page<HealthyArticle> healthyArticle = healthyArticleService.selectHealthyArticle(pageNum, pageSize);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<HealthyArticle> pageInfo = new PageInfo<>(healthyArticle);
        return pageInfo;
    }

    /**
     * 收藏文章
     *
     *
     * 
     *
     * @param collectionArticle
     * @return
     */
    @RequestMapping(value = "collectionArticles", method = RequestMethod.POST)
    public Result collectionArticles(@RequestBody CollectionArticle collectionArticle) {
        int code = 0;
        //如果已收藏则给出提示
        String collectionArticleDTO = healthyArticleMapper.selectCollectionAritlceById(collectionArticle.getArticleId(), collectionArticle.getUserId());
        if (collectionArticleDTO == null) {
            code = healthyArticleService.collectionArticles(collectionArticle);
            if (code == 1) {
                return new Result(100, "收藏成功", true);
            } else {
                return new Result(200, "收藏失败", false);
            }
        }
        return new Result(200, "请不要重复收藏", false);
    }

    /**
     * 取消收藏
     *
     * @param articleId
     * @return
     */
    @RequestMapping(value = "deleteCollectionAritcle", method = RequestMethod.POST)
    public int deleteCollectionAritcleByArticleId(@RequestParam("articleId") String articleId) {
        return healthyArticleService.deleteCollectionAritcleByArticleId(articleId);
    }

    /**
     * 我收藏的文章列表
     *
     * @param pageNum
     * @param pageSize
     * @param userId
     * @return
     */
    @RequestMapping(value = "myCollectionArticle", method = RequestMethod.POST)
    public PageInfo<HealthyArticle> selectHealthyArticleByUserId(@RequestParam(defaultValue = "1", value = "currentPage") Integer pageNum,
                                                                 @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize,
                                                                 @RequestParam("userId") String userId) {
        Page<HealthyArticle> myCollectionArticle = healthyArticleService.selectHealthyArticleByUserId(pageNum, pageSize, userId);
        PageInfo<HealthyArticle> pageInfo = new PageInfo<>(myCollectionArticle);
        return pageInfo;
    }

    /**
     * 文章下所有评论分页
     *
     * @param pageNum
     * @param pageSize
     * @param articleId
     * @return
     */
    @RequestMapping(value = "/commentList", method = RequestMethod.POST)
    public PageInfo<ArticleComment> selectArticleCommentPageByArticleId(@RequestParam(defaultValue = "1", value = "currentPage") Integer pageNum,
                                                                        @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize,
                                                                        @RequestParam("articleId") String articleId) {
        Page<ArticleComment> commentList = healthyArticleService.selectArticleCommentPageByArticleId(pageNum, pageSize, articleId);
        PageInfo<ArticleComment> pageInfo = new PageInfo<>(commentList);
        return pageInfo;
    }

    /**
     * 根据评论id查询评论下的所有回复
     *
     * @param articleCommentId
     * @return
     */
    @RequestMapping(value = "/commentReply", method = RequestMethod.POST)
    public List<CommentReply> selectCommentReplyByArticleCommentId(@RequestParam("articleCommentId") String articleCommentId) {
        return healthyArticleService.selectCommentReplyByArticleCommentId(articleCommentId);
    }
}
