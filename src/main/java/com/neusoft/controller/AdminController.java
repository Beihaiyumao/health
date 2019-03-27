package com.neusoft.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;


import com.github.pagehelper.Page;
import com.neusoft.dao.AdminMapper;
import com.neusoft.entity.*;
import com.neusoft.tool.PageInfo;
import com.sun.org.apache.bcel.internal.generic.FMUL;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.neusoft.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private AdminMapper adminMapper;

    /**
     * 管理员登陆
     *
     * @param adminLogin
     * @param
     * @throws IOException
     */
    @RequestMapping(value = "/adminLogin", method = RequestMethod.POST)
    public Result adminLogin(@RequestBody Admin adminLogin) {

        if (!adminService.adminLogin(adminLogin)) {
            return new Result(200, adminService.getErrorMessage(), false);
        } else {
            Admin admin = adminMapper.adminLogin(adminLogin.getUsername());
            return new Result(100, "登陆成功!", true, admin);
        }
    }

    /**
     * 新增管理员
     *
     * @param addAdmin
     */
    @RequestMapping(value = "/addAdmin", method = RequestMethod.POST)
    public Result addAdmin(@RequestBody Admin addAdmin) {

        return adminService.addAdmin(addAdmin);
    }

    /**
     * 删除管理员
     *
     * @param adminId
     */
    @RequestMapping(value = "/deleteAdmin", method = RequestMethod.GET)
    public Result deleteAdmin(@RequestParam("adminId") String adminId) {

        return adminService.deleteAdmin(adminId);
    }

    /**
     * 管理员退出登陆
     *
     * @param model
     * @param session
     * @return
     */
    @RequestMapping(value = "/adminLoginOut")
    public String adminLoginOut(Model model, HttpSession session) {
        model.asMap().remove("username");
        session.invalidate();
        return null;
    }

    /**
     * 未删除普通用户列表
     *
     * @return
     */
    @RequestMapping(value = "/selectAllUser", method = RequestMethod.GET)
    public PageInfo<User> selectAllUser(@RequestParam(defaultValue = "1", value = "currentPage") Integer pageNum,
                                        @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize) {
        Page<User> userList = adminService.selectAllUser(pageNum, pageSize);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        return pageInfo;
    }

    /**
     * 已删除的普通用户列表
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/allDeleteUser")
    public PageInfo<User> selectAllDeleteUser(@RequestParam(defaultValue = "1", value = "currentPage") Integer pageNum,
                                              @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize) {
        Page<User> allDeleteUser = adminService.selectAllDeleteUser(pageNum, pageSize);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<User> pageInfo = new PageInfo<>(allDeleteUser);
        return pageInfo;
    }

    /**
     * 待审核文章列表
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "examineHelthyArticle", method = RequestMethod.GET)
    public PageInfo<HealthyArticle> selectExamineHelthyArticle(@RequestParam(defaultValue = "1", value = "currentPage") Integer pageNum,
                                                               @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize) {
        Page<HealthyArticle> examineHelthyArticle = adminService.selectExamineHelthyArticle(pageNum, pageSize);
        PageInfo<HealthyArticle> pageInfo = new PageInfo<>(examineHelthyArticle);
        return pageInfo;
    }

    /**
     * 审核通过文章列表
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "passHelthyArticle", method = RequestMethod.GET)
    public PageInfo<HealthyArticle> selectPassHelthyArticle(@RequestParam(defaultValue = "1", value = "currentPage") Integer pageNum,
                                                            @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize) {
        Page<HealthyArticle> passHelthyArticle = adminService.selectPassHelthyArticle(pageNum, pageSize);
        PageInfo<HealthyArticle> pageInfo = new PageInfo<>(passHelthyArticle);
        return pageInfo;
    }

    /**
     * 审核不通过文章列表
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "outHelthyArticle", method = RequestMethod.GET)
    public PageInfo<HealthyArticle> selectOutHelthyArticle(@RequestParam(defaultValue = "1", value = "currentPage") Integer pageNum,
                                                           @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize) {
        Page<HealthyArticle> outHelthyArticle = adminService.selectOutHelthyArticle(pageNum, pageSize);
        PageInfo<HealthyArticle> pageInfo = new PageInfo<>(outHelthyArticle);
        return pageInfo;
    }

    /**
     * 管理员列表
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/selectAllAdmin", method = RequestMethod.GET)
    public PageInfo<Admin> selectAllAdmin(@RequestParam(defaultValue = "1", value = "currentPage") Integer pageNum,
                                          @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize) {
        Page<Admin> adminList = adminService.selectAllAdmin(pageNum, pageSize);
        PageInfo<Admin> pageInfo = new PageInfo<>(adminList);
        return pageInfo;
    }

    /**
     * 拉黑普通用户
     *
     * @param userId
     * @param msg
     * @return
     */
    @GetMapping("/blackUser")
    public Result deleteUserById(@RequestParam("userId") String userId, @RequestParam("msg") String msg) {
        return adminService.deleteUserById(userId, msg);

    }

    /**
     * 拉黑医生用户
     *
     * @param doctorId
     * @param msg
     * @return
     */
    @GetMapping("/blackDoctor")
    public Result selectDoctorInfoById(@RequestParam("doctorId") String doctorId, @RequestParam("msg") String msg) {
        return adminService.selectDoctorInfoById(doctorId, msg);

    }

    /**
     * 未删除医生列表
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/allDoctor")
    public PageInfo<Doctor> selectAllDoctor(@RequestParam(defaultValue = "1", value = "currentPage") Integer pageNum,
                                            @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize) {
        Page<Doctor> allDoctor = adminService.selectAllDoctor(pageNum, pageSize);
        PageInfo<Doctor> pageInfo = new PageInfo<>(allDoctor);
        return pageInfo;
    }

    /**
     * 已删除的医生列表
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/allDeleteDoctor")
    public PageInfo<Doctor> selectAllDeleteDoctor(@RequestParam(defaultValue = "1", value = "currentPage") Integer pageNum,
                                                  @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize) {
        Page<Doctor> allDeleteDoctor = adminService.selectAllDeleteDoctor(pageNum, pageSize);
        PageInfo<Doctor> pageInfo = new PageInfo<>(allDeleteDoctor);
        return pageInfo;
    }

    /**
     * 所有问题列表
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/allQuestion")
    public PageInfo<Question> selseAllQuestion(@RequestParam(defaultValue = "1", value = "currentPage") Integer pageNum,
                                               @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize) {
        Page<Question> allQuestion = adminService.selseAllQuestion(pageNum, pageSize);
        PageInfo<Question> pageInfo = new PageInfo<>(allQuestion);
        return pageInfo;
    }

    /**
     * 所有问题的回答列表
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/allAnswerQuestion")
    public PageInfo<AnswerQuestion> selectAllAnswerQuestion(@RequestParam(defaultValue = "1", value = "currentPage") Integer pageNum,
                                                            @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize) {
        Page<AnswerQuestion> allAnswerQuestion = adminService.selectAllAnswerQuestion(pageNum, pageSize);
        PageInfo<AnswerQuestion> pageInfo = new PageInfo<>(allAnswerQuestion);
        return pageInfo;
    }

    /**
     * 所有文章的评论
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/allArticleComment")
    public PageInfo<ArticleComment> selectAllArticleComment(@RequestParam(defaultValue = "1", value = "currentPage") Integer pageNum,
                                                            @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize) {
        Page<ArticleComment> allArticleComment = adminService.selectAllArticleComment(pageNum, pageSize);
        PageInfo<ArticleComment> pageInfo = new PageInfo<>(allArticleComment);
        return pageInfo;
    }

    /**
     * 所有评论的回复
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/allCommentReply")
    public PageInfo<CommentReply> selectAllCommentReply(@RequestParam(defaultValue = "1", value = "currentPage") Integer pageNum,
                                                        @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize) {
        Page<CommentReply> allCommentReply = adminService.selectAllCommentReply(pageNum, pageSize);
        PageInfo<CommentReply> pageInfo = new PageInfo<>(allCommentReply);
        return pageInfo;
    }

    /**
     * 新增导航栏
     *
     * @param navBar
     * @return
     */
    @PostMapping("/insertNavBar")
    public Result insertNavBar(@RequestBody NavBar navBar) {
        return adminService.insertNavBar(navBar);
    }

    /**
     * 导航栏
     *
     * @return
     */
    @GetMapping("/selectNavBar")
    public List<NavBar> selectNavBar() {
        return adminService.selectNavBar();
    }

    /**
     * 删除导航栏
     *
     * @param navBarId
     * @return
     */
    @GetMapping("/deleteNavBar")
    public Result deleteNavBar(@RequestParam("navBarId") String navBarId) {
        return adminService.deleteNavBar(navBarId);
    }

    /**
     * 新增一级菜单
     *
     * @param firstMenu
     * @return
     */
    @PostMapping("/insertFirstMenu")
    public Result insertFirstMenu(@RequestBody FirstMenu firstMenu) {
        return adminService.insertFirstMenu(firstMenu);
    }

    /**
     * 所有一级菜单
     *
     * @return
     */
    @GetMapping("/selectFirstMenu")
    public PageInfo<FirstMenu> selectFirstMenu(@RequestParam(defaultValue = "1", value = "currentPage") Integer pageNum,
                                               @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize) {
        Page<FirstMenu> firstMenuPage = adminService.selectFirstMenu(pageNum, pageSize);
        PageInfo<FirstMenu> pageInfo = new PageInfo<>(firstMenuPage);
        return pageInfo;
    }

    /**
     * 导航栏下的一级菜单
     *
     * @param navBarId
     * @return
     */
    @GetMapping("/selectFirstMenuByNavBarId")
    public List<FirstMenu> selectFirstMenuByNavBarId(@RequestParam("navBarId") String navBarId) {
        return adminService.selectFirstMenuByNavBarId(navBarId);
    }

    /**
     * 删除一级菜单
     *
     * @param firstMenuId
     * @return
     */
    @GetMapping("/deleteFirstMenu")
    public Result deleteFirstMenu(@RequestParam("firstMenuId") String firstMenuId) {
        return adminService.deleteFirstMenu(firstMenuId);
    }

    /**
     * 新增用户反馈
     *
     * @param userFeedBack
     * @return
     */
    @PostMapping("/insertFeedback")
    public Result insertFeedback(@RequestBody UserFeedBack userFeedBack) {
        return adminService.insertFeedback(userFeedBack);
    }

    /**
     * 所有用户的反馈
     *
     * @param pageNum
     * @param pageSize
     * @param msg
     * @return
     */
    @GetMapping("/selectFeedback")
    public PageInfo<UserFeedBack> selectFeedback(@RequestParam(defaultValue = "1", value = "currentPage") Integer pageNum,
                                                 @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize,
                                                 @RequestParam("msg") String msg) {
        Page<UserFeedBack> userFeedBackPage = adminService.selectFeedback(pageNum, pageSize, msg);
        PageInfo<UserFeedBack> pageInfo = new PageInfo<>(userFeedBackPage);
        return pageInfo;
    }

    /**
     * 删除用户反馈
     *
     * @param userFeedbackId
     * @return
     */
    @GetMapping("/deleteFeedback")
    public Result deleteFeedback(@RequestParam("userFeedbackId") String userFeedbackId) {
        return adminService.deleteFeedback(userFeedbackId);
    }

    /**
     * 取消拉黑用户
     *
     * @param userId
     * @return
     */
    @GetMapping("/cancelBlackUser")
    public Result cancelBlackUser(@RequestParam("userId") String userId) {
        return adminService.cancelBlackUser(userId);
    }

    /**
     * 取消拉黑医生
     *
     * @param doctorId
     * @return
     */
    @GetMapping("/cancelBlackDoct")
    public Result cancelBlackDoct(@RequestParam("doctorId") String doctorId) {
        return adminService.cancelBlackDoct(doctorId);
    }

    /**
     * 删除评论
     *
     * @param commentId
     * @return
     */
    @GetMapping("/deleteCommentById")
    public Result deleteCommentById(@RequestParam("commentId") String commentId) {
        return adminService.deleteCommentById(commentId);
    }

    /**
     * 删除回复
     *
     * @param replyId
     * @return
     */
    @GetMapping("/deleteReplyById")
    public Result deleteReplyById(@RequestParam("replyId") String replyId) {
        return adminService.deleteReplyById(replyId);
    }

    /**
     * 修改密码
     *
     * @param adminId
     * @param password
     * @param opassword
     * @return
     */
    @GetMapping("/changePassword")
    public Result changePassword(@RequestParam("adminId") String adminId, @RequestParam("password") String password, @RequestParam("opassword")
            String opassword) {
        return adminService.changePassword(adminId, password, opassword);
    }

    /**
     * 新增文章分类
     *
     * @param healthArticleGenre
     * @return
     */
    @PostMapping("/insertHealthArticleGenre")
    public Result insertHealthArticleGenre(@RequestBody HealthArticleGenre healthArticleGenre) {
        return adminService.insertHealthArticleGenre(healthArticleGenre);
    }

    /**
     * 所有的文章分类
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/selectAllArticleGenre")
    public PageInfo<HealthArticleGenre> selectAllArticleGenre(@RequestParam(defaultValue = "1", value = "currentPage") Integer pageNum,
                                                              @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize) {
        Page<HealthArticleGenre> healthArticleGenrePage = adminService.selectAllArticleGenre(pageNum, pageSize);
        PageInfo<HealthArticleGenre> pageInfo = new PageInfo<>(healthArticleGenrePage);
        return pageInfo;
    }

    /**
     * 删除文章分类
     *
     * @param healthyArticleGenreId
     * @return
     */
    @GetMapping("/deleteHealthArticleGenreById")
    public Result deleteHealthArticleGenreById(@RequestParam("healthyArticleGenreId") String healthyArticleGenreId) {
        return adminService.deleteHealthArticleGenreById(healthyArticleGenreId);
    }

    /**
     * 新增问题分类
     *
     * @param healthQuestionGenre
     * @return
     */
    @PostMapping("/insertHealthQuestionGenre")
    public Result insertHealthQuestionGenre(@RequestBody HealthQuestionGenre healthQuestionGenre) {
        return adminService.insertHealthQuestionGenre(healthQuestionGenre);
    }

    /**
     * 所有的问题分类
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/selectAllHealthQuestionGenre")
    public PageInfo<HealthQuestionGenre> selectAllHealthQuestionGenre(@RequestParam(defaultValue = "1", value = "currentPage") Integer pageNum,
                                                                      @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize) {
        Page<HealthQuestionGenre> healthQuestionGenrePage = adminService.selectAllHealthQuestionGenre(pageNum, pageSize);
        PageInfo<HealthQuestionGenre> pageInfo = new PageInfo<>(healthQuestionGenrePage);
        return pageInfo;
    }

    /**
     * 删除问题分类
     *
     * @param healthyQuestionGenreId
     * @return
     */
    @GetMapping("/deleteHealthQuestionGenreById")
    public Result deleteHealthQuestionGenreById(@RequestParam("healthyQuestionGenreId") String healthyQuestionGenreId) {
        return adminService.deleteHealthQuestionGenreById(healthyQuestionGenreId);
    }

    /**
     * 修改文章类别名称
     *
     * @param healthyArticleGenreId
     * @param articleGenreName
     * @return
     */
    @GetMapping("/updateHealthArticleGenre")
    public Result updateHealthArticleGenre(@RequestParam("healthyArticleGenreId") String healthyArticleGenreId, @RequestParam("articleGenreName") String articleGenreName) {
        return adminService.updateHealthArticleGenre(healthyArticleGenreId, articleGenreName);
    }

    /**
     * 修改问题类别名称
     *
     * @param healthyQuestionGenreId
     * @param questionGenreName
     * @return
     */
    @GetMapping("/updateHealthQuestionGenre")
    public Result updateHealthQuestionGenre(@RequestParam("healthyQuestionGenreId") String healthyQuestionGenreId, @RequestParam("questionGenreName") String questionGenreName) {
        return adminService.updateHealthQuestionGenre(healthyQuestionGenreId, questionGenreName);
    }
}
