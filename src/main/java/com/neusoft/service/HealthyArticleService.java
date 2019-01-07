package com.neusoft.service;


import com.github.pagehelper.PageHelper;

import com.neusoft.DataDictionary.ArticleState;
import com.neusoft.dao.HealthyArticleMapper;
import com.neusoft.entity.*;
import com.neusoft.tool.FileUtil;
import com.neusoft.tool.SystemTool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import org.springframework.util.ClassUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    public Result addHealthyArticle(HealthyArticle healthyArticle, MultipartFile file) {
        if (!file.isEmpty()) {
            // 获取文件名称,包含后缀
            String fileName = file.getOriginalFilename();
            //获取文件后缀
            String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
            if (suffix.equals("png") || suffix.equals("jpg")) {

                fileName = SystemTool.uuid() + "." + suffix;
            } else {
                return new Result(200, "只支持png，jgp后缀的图片", false);
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String time = sdf.format(new Date());
            // 存放在这个路径下：该路径是该工程目录下的static文件下：(注：该文件可能需要自己创建)
            // 放在static下的原因是，存放的是静态文件资源，即通过浏览器输入本地服务器地址，加文件名时是可以访问到的
            String path = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/" + "img/" + "healthArticle/" + time + "/";
            File filePath = new File(path);
            //如果目录不存在则自动创建
            if (!filePath.exists()) {
                filePath.mkdirs();
            }
            try {
                // 该方法是对文件写入的封装，在tool类中，导入该包即可使用，后面会给出方法
                FileUtil.fileupload(file.getBytes(), path, fileName);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            healthyArticle.setArticleId(SystemTool.uuid());
            healthyArticle.setCreateTime(SystemTool.getDateTime());
            healthyArticle.setArticleState(ArticleState.ARTICLE_STATE_UNAUDITED.getCode());
            healthyArticle.setPic("img/healthArticle/" + time + "/" + fileName);
            int code = healthyArticleMapper.insert(healthyArticle);
            if (code == 1) {
                return new Result(100, "发布文章成功", true);
            } else {
                return new Result(200, "发布文章失败", false);
            }
        }
        return new Result(200, "未知错误", false);
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
    public Result passHealthyArticle(String articleId) {

        int code = healthyArticleMapper.passHealthyArticle(articleId, SystemTool.getDateTime());
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
    public Result outHealthyArticle(String articleId) {
        int code = healthyArticleMapper.outHealthyArticle(articleId, SystemTool.getDateTime());
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
    public HealthyArticle selectHealthyArticleById(String articleId) {

        return healthyArticleMapper.selectHealthyArticleById(articleId);
    }

    /**
     * 修改文章
     *
     * @param healthyArticle
     * @return
     */
    public Result updateHealthyArticle(HealthyArticle healthyArticle) {
        healthyArticle.setCreateTime(SystemTool.getDateTime());
        healthyArticle.setArticleState(ArticleState.ARTICLE_STATE_UNAUDITED.getCode());
        int code = healthyArticleMapper.updateHealthyArticle(healthyArticle);
        if (code == 1) {
            return new Result(100, "更新成功", true);
        } else {
            return new Result(200, "更新失败", false);
        }

    }

    /**
     * 删除文章并删除下面的所有评论回复
     *
     * @param articleId
     * @return
     */
    public Result deleteHealthyArticleById(String articleId) {
        if (selectArticleCommentByArticleId(articleId).size() > 0) {
            deleteArticleCommentByArticleId(articleId);
        }
        if (selectCommentRepiyByArticleId(articleId).size() > 0) {
            deleteCommentReplyByArticleId(articleId);
        }
        int code = healthyArticleMapper.deleteHealthyArticleById(articleId);
        if (code == 1) {
            return new Result(100, "删除成功", true);
        } else {
            return new Result(200, "删除失败", false);
        }
    }

    /**
     * 评论文章
     *
     * @param articleComment
     * @return
     */
    public Result insertArticleComment(ArticleComment articleComment) {
        articleComment.setCommentId(SystemTool.uuid());
        articleComment.setCreateTime(SystemTool.getDateTime());
        int code = healthyArticleMapper.insertArticleComment(articleComment);
        if (code == 1) {
            return new Result(100, "评论成功", true);
        } else {
            return new Result(200, "评论失败", false);
        }
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
    public Result insertCommentReply(CommentReply commentReply) {
        commentReply.setReplyId(SystemTool.uuid());
        commentReply.setCreateTime(SystemTool.getDateTime());
        int code = healthyArticleMapper.insertCommentReply(commentReply);
        if (code == 1) {
            return new Result(100, "回复成功", true);
        } else {
            return new Result(200, "回复失败", false);
        }
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
    public Result collectionArticles(CollectionArticle collectionArticle) {
        collectionArticle.setCollectionArticleId(SystemTool.uuid());
        collectionArticle.setCreateTime(SystemTool.getDateTime());
        int code = healthyArticleMapper.collectionArticles(collectionArticle);
        //如果已收藏则给出提示
        String collectionArticleDTO = healthyArticleMapper.selectCollectionAritlceById(collectionArticle.getArticleId(), collectionArticle.getUserId());
        if (collectionArticleDTO == null) {

            if (code == 1) {
                return new Result(100, "收藏成功", true);
            } else {
                return new Result(200, "收藏失败", false);
            }
        }
        return new Result(200, "请不要重复收藏", false);

    }

    /**
     * 删除收藏的文章
     *
     * @param articleId
     * @return
     */
    public Result deleteCollectionAritcleByArticleId(String articleId) {
        int code= healthyArticleMapper.deleteCollectionAritcleByArticleId(articleId);
        if(code==1){
            return new Result(100,"取消收藏成功",true);
        }else {
            return new Result(200,"取消收藏失败",false);
        }
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
