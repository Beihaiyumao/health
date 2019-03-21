package com.neusoft.dao;

import com.github.pagehelper.Page;
import com.neusoft.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMapper {
    /*****管理员登录****/
    Admin adminLogin(String username);

    /*****新增管理员****/
    int addAdmin(Admin admin);

    /*****删除管理员****/
    int deleteAdmin(String adminId);

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

    //新增导航
    int insertNavBar(NavBar navBar);

    //所有导航
    List<NavBar> selectNavBar();

    //删除导航栏
    int deleteNavBar(@Param("navBarId") String navBarId);

    //新增一级菜单
    int insertFirstMenu(FirstMenu firstMenu);

    //所有一级菜单
    Page<FirstMenu> selectFirstMenu();

    //导航栏下的一级菜单
    List<FirstMenu> selectFirstMenuByNavBarId(@Param("navBarId") String navBarId);

    //删除一级菜单
    int deleteFirstMenu(@Param("firstMenuId") String firstMenuId);

    //新增反馈信息
    int insertFeedback(UserFeedBack userFeedBack);

    //所有用户反馈信息
    Page<UserFeedBack> selectFeedback(@Param("msg") String msg);

    //删除用户反馈信息
    int deleteFeedback(@Param("userFeedbackId") String userFeedbackId);

    //取消拉黑用户
    int cancelBlackUser(@Param("userId") String userId);

    //取消拉黑医生
    int cancelBlackDoct(@Param("doctorId") String doctorId);

    //根据评论id删除评论
    int deleteCommentById(@Param("commentId")String commentId);

    //根据回复id删除回复
    int deleteReplyById(@Param("replyId")String replyId);
}
