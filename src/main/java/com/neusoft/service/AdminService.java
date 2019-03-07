package com.neusoft.service;

import java.sql.Date;
import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.neusoft.DataDictionary.Role;
import com.neusoft.dao.DoctorMapper;
import com.neusoft.dao.UserMapper;
import com.neusoft.entity.*;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.dao.AdminMapper;
import com.neusoft.tool.SystemTool;

@Service
public class AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DoctorMapper doctorMapper;

    //错误信息
    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * 管理员登陆
     *
     * @param adminLogin
     * @return
     */
    public boolean adminLogin(Admin adminLogin) {
        boolean adminLoginState = true;
        Admin admin = adminMapper.adminLogin(adminLogin.getUsername());
        if (admin == null) {
            errorMessage = "用户名错误";
            adminLoginState = false;
        } else if (!admin.getPassword().equals(adminLogin.getPassword())) {
            errorMessage = "密码错误";
            adminLoginState = false;
        }
        return adminLoginState;
    }

    /**
     * 新增管理员
     *
     * @param addAdmin
     */
    public void addAdmin(Admin addAdmin) {
        //获取当前时间
        Date time = new Date(new java.util.Date().getTime());
        //管理员id
        String adminId = SystemTool.uuid();
        addAdmin.setAdminId(adminId);
        addAdmin.setCreateTime(time);
        adminMapper.addAdmin(addAdmin);
    }

    /**
     * 删除管理员
     *
     * @param adminId
     */
    public void deleteAdmin(String adminId) {
        adminMapper.deleteAdmin(adminId);
    }

    /**
     * 未删除普通用户列表
     *
     * @return
     */
    public Page<User> selectAllUser(Integer pageNum, Integer pageSize) {
        //用插件进行分页
        PageHelper.startPage(pageNum, pageSize);
        return adminMapper.selectAllUser();
    }

    /**
     * 已删除普通用户列表
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Page<User> selectAllDeleteUser(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return adminMapper.selectAllDeleteUser();
    }

    /**
     * 待审核文章列表
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Page<HealthyArticle> selectExamineHelthyArticle(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return adminMapper.selectExamineHelthyArticle();
    }

    /**
     * 审核通过文章列表
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Page<HealthyArticle> selectPassHelthyArticle(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return adminMapper.selectPassHelthyArticle();
    }

    /**
     * 审核不通过列表
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Page<HealthyArticle> selectOutHelthyArticle(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return adminMapper.selectOutHelthyArticle();
    }

    /**
     * 管理员列表
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Page<Admin> selectAllAdmin(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return adminMapper.selectAllAdmin();
    }

    /**
     * 拉黑普通用户
     *
     * @param userId
     * @param msg
     * @return
     */
    public Result deleteUserById(String userId, String msg) {
        Blacklist deleteUser = new Blacklist();
        deleteUser.setBlacklistId(SystemTool.uuid());
        deleteUser.setCreateTime(SystemTool.getDateTime());
        User useInfo = userMapper.selectUserInfoByUserId(userId);
        deleteUser.setEmail(useInfo.getEmail());
        deleteUser.setUserId(userId);
        deleteUser.setMsg(msg);
        deleteUser.setRole(Role.USER.getCode());
        int code = adminMapper.deleteUserById(deleteUser);
        if (code == 1) {
            //更新用户表字段
            adminMapper.updateUserBlackState(userId);
            return new Result(100, "已成功拉黑该用户", true);
        } else {
            return new Result(200, "拉黑失败", false);
        }
    }

    /**
     * 拉黑医生用户
     *
     * @param doctorId
     * @param msg
     * @return
     */
    public Result selectDoctorInfoById(String doctorId, String msg) {
        Blacklist deleteDoctor = new Blacklist();
        deleteDoctor.setBlacklistId(SystemTool.uuid());
        deleteDoctor.setCreateTime(SystemTool.getDateTime());
        Doctor doctorInfo = doctorMapper.selectDoctorInfoById(doctorId);
        deleteDoctor.setMsg(msg);
        deleteDoctor.setUserId(doctorId);
        deleteDoctor.setEmail(doctorInfo.getEmail());
        deleteDoctor.setRole(Role.DOCTOR.getCode());
        int code = adminMapper.deleteUserById(deleteDoctor);
        if (code == 1) {
            //更新医生表字段
            adminMapper.updateDoctorBlackState(doctorId);
            return new Result(100, "已成功拉黑该医生", true);
        } else {
            return new Result(200, "拉黑失败", false);
        }
    }

    /**
     * 未删除医生列表
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Page<Doctor> selectAllDoctor(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return adminMapper.selectAllDoctor();
    }

    /**
     * 已删除的医生列表
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Page<Doctor> selectAllDeleteDoctor(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return adminMapper.selectAllDeleteDoctor();
    }

    /**
     * 所有问题列表
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Page<Question> selseAllQuestion(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return adminMapper.selseAllQuestion();
    }

    /**
     * 所有问题回答列表
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Page<AnswerQuestion> selectAllAnswerQuestion(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return adminMapper.selectAllAnswerQuestion();
    }

    /**
     * 查询所有文章评论
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Page<ArticleComment> selectAllArticleComment(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return adminMapper.selectAllArticleComment();
    }

    /**
     * 查询所有评论的回复
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Page<CommentReply> selectAllCommentReply(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return adminMapper.selectAllCommentReply();
    }

    /**
     * 新增导航栏
     *
     * @param navBar
     * @return
     */
    public Result insertNavBar(NavBar navBar) {
        navBar.setCreateTime(SystemTool.getDateTime());
        navBar.setNavBarId(SystemTool.uuid());
        return SystemTool.insert(adminMapper.insertNavBar(navBar));
    }

    /**
     * 导航栏
     *
     * @return
     */
    public List<NavBar> selectNavBar() {
        return adminMapper.selectNavBar();
    }

    /**
     * 删除导航栏
     *
     * @param navBarId
     * @return
     */
    public Result deleteNavBar(String navBarId) {
        int code = adminMapper.deleteNavBar(navBarId);
        return SystemTool.delete(code);
    }

    /**
     * 新增一级菜单
     *
     * @param firstMenu
     * @return
     */
    public Result insertFirstMenu(FirstMenu firstMenu) {
        firstMenu.setCreateTime(SystemTool.getDateTime());
        firstMenu.setFirstMenuId(SystemTool.uuid());
        return SystemTool.insert(adminMapper.insertFirstMenu(firstMenu));
    }

    /**
     * 所有一级菜单
     *
     * @return
     */
    public Page<FirstMenu> selectFirstMenu(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return adminMapper.selectFirstMenu();
    }

    /**
     * 导航栏下的一级菜单
     *
     * @param navBarId
     * @return
     */
    public List<FirstMenu> selectFirstMenuByNavBarId(String navBarId) {
        return adminMapper.selectFirstMenuByNavBarId(navBarId);
    }

    /**
     * 删除一级菜单
     *
     * @param firstMenuId
     * @return
     */
    public Result deleteFirstMenu(String firstMenuId) {
        return SystemTool.delete(adminMapper.deleteFirstMenu(firstMenuId));
    }

    /**
     * 新增用户反馈
     *
     * @param userFeedBack
     * @return
     */
    public Result insertFeedback(UserFeedBack userFeedBack) {
        userFeedBack.setCreateTime(SystemTool.getDateTime());
        userFeedBack.setUserFeedbackId(SystemTool.uuid());
        return SystemTool.insert(adminMapper.insertFeedback(userFeedBack));
    }

    /**
     * 所有用户的反馈
     *
     * @param pageNum
     * @param pageSize
     * @param msg
     * @return
     */
    public Page<UserFeedBack> selectFeedback(Integer pageNum, Integer pageSize, String msg) {
        PageHelper.startPage(pageNum, pageSize);
        return adminMapper.selectFeedback(msg);
    }

    /**
     * 删除用户反馈
     *
     * @param userFeedbackId
     * @return
     */
    public Result deleteFeedback(String userFeedbackId) {
        return SystemTool.delete(adminMapper.deleteFeedback(userFeedbackId));
    }
}
