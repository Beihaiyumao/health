package com.neusoft.controller;

import com.github.pagehelper.Page;
import com.neusoft.dao.HealthyArticleMapper;
import com.neusoft.entity.*;
import com.neusoft.service.HealthyArticleService;
import com.neusoft.tool.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.text.ParseException;
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
    public Result addHealthyArticle(HealthyArticle healthyArticle, @RequestParam("file") MultipartFile file) {
        return healthyArticleService.addHealthyArticle(healthyArticle, file);

    }

    /**
     * 模糊查询文章
     *
     * @param title
     */
    @RequestMapping(value = "/selectHealthyArticleByTitle", method = RequestMethod.GET)
    public PageInfo<HealthyArticle> selectHealthyArticleByTitle(@RequestParam(defaultValue = "1", value = "currentPage") Integer pageNum,
                                                                @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize,
                                                                @RequestParam("title") String title) {
        Page<HealthyArticle> healthyArticleList = healthyArticleService.selectHealthyArticleByTitle(pageNum, pageSize, title);
        PageInfo<HealthyArticle> pageInfo = new PageInfo<>(healthyArticleList);
        return pageInfo;
    }

    /**
     * 审核通过文章
     *
     * @param articleId
     * @return
     */
    @RequestMapping(value = "/passHealthyArticle", method = RequestMethod.GET)
    public Result passHealthyArticle(@RequestParam("articleId") String articleId) {
        return healthyArticleService.passHealthyArticle(articleId);

    }

    /**
     * 审核不通过文章
     *
     * @param articleId
     * @return
     */
    @RequestMapping(value = "/outHealthyArticle", method = RequestMethod.GET)
    public Result outHealthyArticle(@RequestParam("articleId") String articleId) {
        return healthyArticleService.outHealthyArticle(articleId);

    }

    /**
     * 根据文章id查询文章
     *
     * @param articleId
     * @return
     */
    @RequestMapping(value = "/selectHealthyArticleById", method = RequestMethod.GET)
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
        return healthyArticleService.updateHealthyArticle(healthyArticle);

    }

    /**
     * 删除文章
     *
     * @param articleId
     * @return
     */
    @RequestMapping(value = "deleteHealthyArticleById", method = RequestMethod.GET)
    public Result deleteHealthyArticleById(@RequestParam("articleId") String articleId) {
        return healthyArticleService.deleteHealthyArticleById(articleId);

    }

    /**
     * 文章评论
     *
     * @param articleComment
     * @return
     */
    @RequestMapping(value = "/insertArticleComment", method = RequestMethod.POST)
    public Result insertArticleComment(@RequestBody ArticleComment articleComment) {
        return healthyArticleService.insertArticleComment(articleComment);

    }

    /**
     * 文章评论回复
     *
     * @param commentReply
     * @return
     */
    @RequestMapping(value = "/insertCommentReply", method = RequestMethod.POST)
    public Result insertCommentReply(@RequestBody CommentReply commentReply) {
        return healthyArticleService.insertCommentReply(commentReply);

    }

    /**
     * 审核通过文章列表
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/healthyArticle", method = RequestMethod.GET)
    public PageInfo<HealthyArticle> selectHealthyArticle(@RequestParam(defaultValue = "1", value = "currentPage") Integer pageNum,
                                                         @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize,
                                                         @RequestParam("articleGenre") String articleGenre) {
        //未分类
        if (articleGenre.isEmpty()) {
            Page<HealthyArticle> healthyArticle = healthyArticleService.selectHealthyArticle(pageNum, pageSize);
            PageInfo<HealthyArticle> pageInfo = new PageInfo<>(healthyArticle);
            return pageInfo;
        } else {
            //分类查询
            Page<HealthyArticle> healthyArticle = healthyArticleService.selectHealthArticleByGenre(pageNum, pageSize, articleGenre);
            PageInfo<HealthyArticle> pageInfo = new PageInfo<>(healthyArticle);
            return pageInfo;
        }

    }

    /**
     * 收藏文章
     *
     * @param collectionArticle
     * @return
     */
    @RequestMapping(value = "collectionArticles", method = RequestMethod.POST)
    public Result collectionArticles(@RequestBody CollectionArticle collectionArticle) {

        return healthyArticleService.collectionArticles(collectionArticle);
    }

    /**
     * 取消收藏
     *
     * @param collectionArticleId
     * @return
     */
    @RequestMapping(value = "deleteCollectionAritcle", method = RequestMethod.GET)
    public Result deleteCollectionAritcleByArticleId(@RequestParam("collectionArticleId") String collectionArticleId) {
        return healthyArticleService.deleteCollectionAritcleByArticleId(collectionArticleId);
    }


    /**
     * 文章下所有评论分页
     *
     * @param pageNum
     * @param pageSize
     * @param articleId
     * @return
     */
    @RequestMapping(value = "/commentList", method = RequestMethod.GET)
    public PageInfo<ArticleComment> selectArticleCommentPageByArticleId(@RequestParam(defaultValue = "1", value = "currentPage") Integer pageNum,
                                                                        @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize,
                                                                        @RequestParam("articleId") String articleId) {
        Page<ArticleComment> commentList = healthyArticleService.selectArticleCommentPageByArticleId(pageNum, pageSize, articleId);
        for (int i = 0; i < commentList.size(); i++) {
            commentList.get(i).setCommentReply(healthyArticleService.selectCommentReplyByArticleCommentId(commentList.get(i).getCommentId()));
        }
        PageInfo<ArticleComment> pageInfo = new PageInfo<>(commentList);
        return pageInfo;
    }

    /**
     * 根据评论id查询评论下的所有回复
     *
     * @param articleCommentId
     * @return
     */
    @RequestMapping(value = "/commentReply", method = RequestMethod.GET)
    public List<CommentReply> selectCommentReplyByArticleCommentId(@RequestParam("articleCommentId") String articleCommentId) {
        return healthyArticleService.selectCommentReplyByArticleCommentId(articleCommentId);
    }

    /**
     * 判断用户是否收藏了该文章
     *
     * @param userId
     * @param articleId
     * @return
     */
    @GetMapping("/selectCollectionAritlceById")
    public Result selectCollectionAritlceById(@RequestParam("userId") String userId, @RequestParam("articleId") String articleId) {
        return healthyArticleService.selectCollectionAritlceById(userId, articleId);
    }

    /**
     * 用户点赞文章
     *
     * @param likeArticle
     * @return
     */
    @PostMapping("/insertLikeArticle")
    public Result insertLikeArticle(@RequestBody LikeArticle likeArticle) {
        return healthyArticleService.insertLikeArticle(likeArticle);
    }

    /**
     * 判断用户是否点赞了该文章
     *
     * @param userId
     * @param articleId
     * @return
     */
    @GetMapping("/selectLikeArticleId")
    public Result selectLikeArticleId(@RequestParam("userId") String userId, @RequestParam("articleId") String articleId) {
        return healthyArticleService.selectLikeArticleId(userId, articleId);
    }

    /**
     * 取消点赞
     *
     * @param likeArticleId
     * @return
     */
    @GetMapping("/deleteLikeArticle")
    public Result deleteLikeArticle(@RequestParam("likeArticleId") String likeArticleId) {
        return healthyArticleService.deleteLikeArticle(likeArticleId);
    }

    /**
     * 文章点赞总数
     *
     * @param articleId
     * @return
     */
    @GetMapping("/selectLikeArticleAll")
    public Result selectLikeArticleAll(@RequestParam("articleId") String articleId) {
        return healthyArticleService.selectLikeArticleAll(articleId);
    }

    /**
     * 我发布的文章
     *
     * @param pageNum
     * @param pageSize
     * @param userId
     * @param role
     * @return
     */
    @GetMapping("/selectAllMyCreateHealthArticle")
    public PageInfo<HealthyArticle> selectAllMyCreateHealthArticle(@RequestParam(defaultValue = "1", value = "currentPage") Integer pageNum,
                                                                   @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize,
                                                                   @RequestParam("userId") String userId, @RequestParam("role") String role) {
        Page<HealthyArticle> healthyArticlePage = healthyArticleService.selectAllMyCreateHealthArticle(pageNum, pageSize, userId, role);
        PageInfo<HealthyArticle> pageInfo = new PageInfo<>(healthyArticlePage);
        return pageInfo;
    }
}
