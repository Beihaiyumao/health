package com.neusoft.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;


import com.github.pagehelper.Page;
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

    /**
     * 管理员登陆
     *
     * @param adminLogin
     * @param session
     * @throws IOException
     */
    @RequestMapping(value = "/adminLogin", method = RequestMethod.POST)
    public Result adminLogin(@RequestBody Admin adminLogin, HttpSession session) {

        if (!adminService.adminLogin(adminLogin)) {
            return new Result(200, adminService.getErrorMessage(), false);
        } else {
            session.setAttribute("username", adminLogin.getUsername());
            return new Result(100, "登陆成功!", true);
        }
    }

    /**
     * 新增管理员
     *
     * @param addAdmin
     */
    @RequestMapping(value = "/addAdmin", method = RequestMethod.POST)
    public void addAdmin(@RequestBody Admin addAdmin) {
        adminService.addAdmin(addAdmin);
    }

    /**
     * 删除管理员
     *
     * @param adminId
     */
    @RequestMapping(value = "/deleteAdmin", method = RequestMethod.GET)
    public void deleteAdmin(@RequestParam("adminId") String adminId) {
        adminService.deleteAdmin(adminId);
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
}
