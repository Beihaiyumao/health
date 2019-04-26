package com.neusoft.dao;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.neusoft.entity.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import java.util.List;

public interface HealthyArticleMapper {
    int deleteHealthyArticleById(String articleId);

    int insert(HealthyArticle record);

    int insertSelective(HealthyArticle record);

    //根据文章id查询文章
    HealthyArticle selectHealthyArticleById(String articleId);

    int updateHealthyArticle(HealthyArticle record);

    int updateByPrimaryKey(HealthyArticle record);

    //模糊查询文章
    Page<HealthyArticle> selectHealthyArticleByTitle(String title);

    //管理员审核通过文章
    int passHealthyArticle(@Param("articleId") String articleId, @Param("dateTime") Date dateTime);

    //管理员不通过文章
    int outHealthyArticle(@Param("articleId") String articleId, @Param("dateTime") Date dateTime);

    //评论文章
    int insertArticleComment(ArticleComment record);

    //根据文章id删除该文章下的所有评论
    int deleteArticleCommentByArticleId(String articleId);

    //根据文章id查询该文章下的所有评论
    List<ArticleComment> selectArticleCommentByArticleId(String articleId);

    //回复文章评论
    int insertCommentReply(CommentReply commentReply);

    //根据文章id查询该文章下的所有回复
    List<CommentReply> selectCommentRepiyByArticleId(String articleId);

    //根据文章id删除该文章下的所有回复
    int deleteCommentReplyByArticleId(String articleId);

    //分页审核通过文章
    Page<HealthyArticle> selectHealthyArticle();

    //分类查询审核通过的文章
    Page<HealthyArticle> selectHealthArticleByGenre(@Param("genre") String genre);

    //收藏文章
    int collectionArticles(CollectionArticle collectionArticle);

    //删除收藏的文章
    int deleteCollectionAritcleByArticleId(@Param("collectionArticleId") String collectionArticleId);

    //根据文章id查询当前用户是否已经收藏该文章
    List<String> selectCollectionAritlceById(@Param("articleId") String articleId, @Param("userId") String userId);

    //我收藏的文章
    Page<HealthyArticle> selectHealthyArticleByUserId(String userId);

    //根据文章id查找评论列表分页
    Page<ArticleComment> selectArticleCommentPageByArticleId(String articleId);

    //根据评论id查询所有回复
    List<CommentReply> selectCommentReplyByArticleCommentId(String articleCommentId);

    //点赞文章
    int insertLikeArticle(LikeArticle likeArticle);

    //判断用户是否点赞过此文章
    List<String> selectLikeArticleId(@Param("userId") String userId, @Param("articleId") String articleId);

    //取消点赞
    int deleteLikeArticle(@Param("likeArticleId") String likeArticleId);

    //文章总点赞数
    List<String> selectLikeArticleAll(@Param("articleId") String articleId);

    //我发布的文章列表
    Page<HealthyArticle> selectAllMyCreateHealthArticle(@Param("userId") String userId, @Param("role") String role);

    //根据文章id查询多少喜欢
    List<String> selectAllLikeById(String articleId);

    //根据文章id评论数量
    List<String> selectCommentById(String articleId);

    //根据文章id查询回复数量
    List<String> selectReplyById(String articleId);
}