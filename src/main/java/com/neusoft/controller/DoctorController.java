package com.neusoft.controller;

import com.github.pagehelper.Page;
import com.neusoft.DataDictionary.BlackState;
import com.neusoft.dao.DoctorMapper;
import com.neusoft.entity.AnswerQuestion;
import com.neusoft.entity.Doctor;
import com.neusoft.entity.Result;
import com.neusoft.service.DoctorService;
import com.neusoft.tool.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import javax.servlet.http.HttpSession;

/**
 * 医生端
 * 2018/12/28
 */
@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private DoctorMapper doctorMapper;

    /**
     * 医生登录
     *
     * @param doctor
     * @param session
     * @return
     */
    @PostMapping("/doctorLogin")
    public Result doctorLogin(@RequestBody Doctor doctor, HttpSession session) {
        Doctor doctorLogin = doctorMapper.login(doctor.getEmail());
        if (doctorLogin != null && doctorLogin.getBlackState().equals(BlackState.BLACK_STATE_TRUE.getCode())) {
            String msg = doctorMapper.selectUserBlackMsg(doctor.getEmail());
            return new Result(200, "抱歉您已被管理员拉黑，具体原因:" + msg, false);
        }
        if (!doctorService.login(doctor)) {
            return new Result(200, doctorService.getErrorMessage(), false);
        } else {
            Doctor doctorInfo = doctorMapper.login(doctor.getEmail());
            session.setAttribute("username", doctorInfo.getUsername());
            session.setAttribute("doctorId", doctorInfo.getDoctorId());
            return new Result(100, doctorService.getErrorMessage(), true);
        }
    }

    /**
     * 医生注册
     *
     * @param doctor
     * @param session
     * @return
     */
    @PostMapping("/doctorRegist")
    public Result doctorRegist(@RequestBody Doctor doctor, HttpSession session) {
        Doctor doctorRegist = doctorMapper.login(doctor.getEmail());
//        String idCode = (String) session.getAttribute("sRand");
//        System.out.print(idCode);
        if (doctorRegist != null && doctorRegist.getBlackState().equals(BlackState.BLACK_STATE_TRUE.getCode())) {
            String msg = doctorMapper.selectUserBlackMsg(doctor.getEmail());
            return new Result(200, "抱歉您已被管理员拉黑，具体原因:" + msg, false);
        }
        if (doctorRegist != null) {
            return new Result(200, "该邮箱已被注册请直接登录", false);
        }
//        if (doctor.getIdentifying() == null || doctor.getIdentifying().isEmpty()) {
//            return new Result(200, "请输入验证码", false);
//        }
//        if (!doctor.getIdentifying().equals(idCode)) {
//            return new Result(200, "验证码错误", false);
//        }
        if (doctorRegist == null ) {
            int code = doctorService.doctorRegist(doctor);
            if (code == 1) {
                return new Result(100, "注册成功", true);
            } else {
                return new Result(200, "注册失败", false);
            }
        }
        return new Result(200, "未知错误", false);
    }

    /**
     * 分页所有的医生
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/allDoctor")
    public PageInfo<Doctor> allDoctor(@RequestParam(defaultValue = "1", value = "currentPage") Integer pageNum,
                                      @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize) {
        Page<Doctor> allDoctor = doctorService.allDoctor(pageNum, pageSize);
        PageInfo<Doctor> pageInfo = new PageInfo<Doctor>(allDoctor);
        return pageInfo;
    }

    /**
     * 注销账号
     *
     * @param doctorId
     * @return
     */
    @GetMapping("/deleteDoctor")
    public Result deleteDoctorById(@RequestParam("doctorId") String doctorId) {
        return doctorService.deleteDoctorById(doctorId);

    }

    /**
     * 医生个人中心
     *
     * @param doctorId
     * @return
     */
    @GetMapping("/doctorInfo")
    public Doctor selectDoctorInfoById(@RequestParam("doctorId") String doctorId) {
        return doctorService.selectDoctorInfoById(doctorId);
    }

    /**
     * 更新个人信息
     *
     * @param doctor
     * @return
     */
    @PostMapping("/updateInfo")
    public Result updateDoctorInfo(@RequestBody Doctor doctor) {
        return  doctorService.updateDoctorInfo(doctor);

    }

    /**
     * 修改密码
     *
     * @param doctorId
     * @param oldPassword
     * @param newPassword
     * @return
     */
    @GetMapping("/updatePassword")
    public Result updatePassword(@RequestParam("doctorId") String doctorId, @RequestParam("oldPassword") String oldPassword, @RequestParam("newPassword") String newPassword) {
        Doctor doctorInfo = doctorService.selectDoctorInfoById(doctorId);
        if (!doctorInfo.getPassword().equals(oldPassword)) {
            return new Result(200, "旧密码错误", false);
        }
        if (doctorInfo.getPassword().equals(oldPassword)) {
            if (oldPassword.equals(newPassword)) {
                return new Result(200, "新密码不能于旧密码相同", false);
            }
            int code = doctorService.updatePassword(doctorId, newPassword);
            if (code == 1) {
                return new Result(100, "修改密码成功", true);
            } else {
                return new Result(200, "修改密码失败", false);
            }
        }
        return new Result(200, "未知错误", false);
    }

    /**
     * 医生回答患者提问问题
     *
     * @param answerQuestion
     * @return
     */
    @PostMapping("/answerQuestion")
    public Result insertAnswerQuestion(@RequestBody AnswerQuestion answerQuestion) {
        return doctorService.insertAnswerQuestion(answerQuestion);

    }

    /**
     * 我回答的问题列表
     *
     * @param pageNum
     * @param pageSize
     * @param doctorId
     * @return
     */
    @GetMapping("/myAnswerQuestion")
    public PageInfo<AnswerQuestion> myAnswerQuestion(@RequestParam(defaultValue = "1", value = "currentPage") Integer pageNum,
                                                     @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize,
                                                     @RequestParam("doctorId") String doctorId) {
        Page<AnswerQuestion> answerQuestions = doctorService.myAnswerQuestion(doctorId, pageNum, pageSize);
        PageInfo<AnswerQuestion> pageInfo = new PageInfo<>(answerQuestions);
        return pageInfo;
    }

    /**
     * 删除回答
     *
     * @param answerId
     * @return
     */
    @GetMapping("/deleteMyAnswerQuestion")
    public Result deleteMyAnswerQuestion(@RequestParam("answerId") String answerId) {
        return doctorService.deleteMyAnswerQuestion(answerId);

    }
}
