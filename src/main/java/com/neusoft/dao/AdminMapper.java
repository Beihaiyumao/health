package com.neusoft.dao;

import com.github.pagehelper.Page;
import com.neusoft.entity.*;

import java.util.List;

public interface AdminMapper {
    /*****管理员登录****/
    Admin adminLogin(String username);

    /*****新增管理员****/
    void addAdmin(Admin admin);

    /*****删除管理员****/
    void deleteAdmin(String adminId);

    //查询所有未删除的用户
    Page<User> selectAllUser();

    //查询所有已删除的用户
    Page<User> selectAllDeleteUser();

    //待审核文章列表
    Page<HealthyArticle> selectExamineHelthyArticle();

    //审核通过文章列表
    Page<HealthyArticle> selectPassHelthyArticle();

    //审核不通过文章列表
    Page<HealthyArticle> selectOutHelthyArticle();

    //管理员列表
    Page<Admin> selectAllAdmin();

    //拉黑用户
    int deleteUserById(Blacklist blacklist);

    //更新用户表拉黑状态
    void updateUserBlackState(String userId);

    //更新医生表拉黑状态
    void updateDoctorBlackState(String doctorId);

    //查询所有未拉黑的医生用户
    Page<Doctor> selectAllDoctor();

    //查询所有已删除的医生用户
    Page<Doctor> selectAllDeleteDoctor();

    //查询所有问题
    Page<Question> selseAllQuestion();

    //查询所有问题的回答
    Page<AnswerQuestion> selectAllAnswerQuestion();

    //查询所有文章评论
    Page<ArticleComment> selectAllArticleComment();

    //查询所有评论的回复
    Page<CommentReply> selectAllCommentReply();
}
