package com.neusoft.dao;

import com.github.pagehelper.Page;
import com.neusoft.entity.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public interface AdminMapper {
    /*****管理员登录****/
    Admin adminLogin(String username);

    /*****新增管理员****/
    int addAdmin(Admin admin);

    /*****删除管理员****/
    int deleteAdmin(String adminId);

    //根据管理员用户名查询
    List<String> selectAdminByName(@Param("adminName") String adminName);

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
    int deleteCommentById(@Param("commentId") String commentId);

    //根据回复id删除回复
    int deleteReplyById(@Param("replyId") String replyId);

    //管理员修改密码
    int changePassword(@Param("password") String password, @Param("adminId") String adminId);

    //根据管理员id查询管理员信息
    Admin selectAdminById(@Param("adminId") String adminId);

    //新增文章分类
    int insertHealthArticleGenre(HealthArticleGenre healthArticleGenre);

    //所有文章分类
    Page<HealthArticleGenre> selectAllArticleGenre();

    Page<HealthArticleGenre>selectArticleGenreOutAll();

    //判断是否已存在此文章分类
    HealthArticleGenre selectHealthArticleGenreByCodeOrName(@Param("articleGenreCode") String articleGenreCode, @Param("articleGenreName") String articleGenreName);

    //删除文章分类
    int deleteHealthArticleGenreById(@Param("healthyArticleGenreId") String healthyArticleGenreId);

    //新增问题分类
    int insertHealthQuestionGenre(HealthQuestionGenre healthQuestionGenre);

    //判断此分类是否存在
    HealthQuestionGenre selectHealthQuestionGenreByCodeOrName(@Param("questionGenreCode") String questionGenreCode, @Param("questionGenreName") String questionGenreName);

    //所有文章分类
    Page<HealthQuestionGenre> selectAllHealthQuestionGenre();

    Page<HealthQuestionGenre> selectHealthQuestionGenreOutAll();

    //删除问题分类
    int deleteHealthQuestionGenreById(@Param("healthyQuestionGenreId") String healthyQuestionGenreId);

    //修改文章分类名称
    int updateHealthArticleGenre(@Param("healthyArticleGenreId") String healthyArticleGenreId, @Param("articleGenreName") String articleGenreName);

    //修改问题类别名称
    int updateHealthQuestionGenre(@Param("healthyQuestionGenreId") String healthyQuestionGenreId, @Param("questionGenreName") String questionGenreName);

    //新增用户通知
    int insertNoticeMsg(NoticeMsg noticeMsg);

    //所有用户通知
    Page<NoticeMsg> selectAllNoticeMsg();

    //更新用户通知状态
    int updateNoticeState(@Param("state") String state, @Param("noticeMsgId") String noticeMsgId);

    //判断是否存在已开启的通知
    List<String> selectAllNoticeStateIsYes();

    //删除通知
    int deleteNoticeStateById(@Param("noticeMsgId") String noticeMsgId);

    List<NoticeMsg>selectIsYesNotice();

}

