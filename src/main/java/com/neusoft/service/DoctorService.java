package com.neusoft.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.neusoft.DataDictionary.BlackState;
import com.neusoft.dao.DoctorMapper;
import com.neusoft.entity.AnswerQuestion;
import com.neusoft.entity.Doctor;
import com.neusoft.tool.SystemTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
 * 医生端
 * 2018/12/28
 */
@Service
public class DoctorService {
    @Autowired
    private DoctorMapper doctorMapper;
    //错误信息
    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * 医生登录
     *
     * @param doctor
     * @return
     */
    public boolean login(Doctor doctor) {
        boolean success = true;
        Doctor doctorLogin = doctorMapper.login(doctor.getEmail());
        if (doctorLogin == null) {
            errorMessage = "用户名错误";
            success = false;
        } else if (!doctor.getPassword().equals(doctorLogin.getPassword())) {
            errorMessage = "密码错误";
            success = false;
        } else {
            errorMessage = "登录成功";
        }
        return success;
    }

    /**
     * 医生注册
     *
     * @param doctor
     */
    public int doctorRegist(Doctor doctor) {
        doctor.setCreateTime(SystemTool.getDateTime());
        doctor.setDoctorId(SystemTool.uuid());
        doctor.setBlackState(BlackState.BLACK_STATE_FALSE.getCode());
        return doctorMapper.doctorRegist(doctor);
    }

    /**
     * 分页所有的医生
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Page<Doctor> allDoctor(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return doctorMapper.allDoctor();
    }

    /**
     * 注销账号
     *
     * @param doctorId
     * @return
     */
    public int deleteDoctorById(String doctorId) {
        return doctorMapper.deleteDoctorById(doctorId);
    }

    /**
     * 医生个人中心
     *
     * @param doctorId
     * @return
     */
    public Doctor selectDoctorInfoById(String doctorId) {
        return doctorMapper.selectDoctorInfoById(doctorId);
    }

    /**
     * 更新个人信息
     *
     * @param doctor
     * @return
     */
    public int updateDoctorInfo(Doctor doctor) {
        return doctorMapper.updateDoctorInfo(doctor);
    }

    /**
     * 修改密码
     *
     * @param doctorId
     * @param password
     * @return
     */
    public int updatePassword(String doctorId, String password) {
        return doctorMapper.updatePassword(doctorId, password);
    }

    /**
     * 医生回答患者问题
     *
     * @param answerQuestion
     * @return
     */
    public int insertAnswerQuestion(AnswerQuestion answerQuestion) {
        answerQuestion.setAnswerId(SystemTool.uuid());
        answerQuestion.setCreateTime(SystemTool.getDateTime());
        return doctorMapper.insertAnswerQuestion(answerQuestion);
    }

    /**
     * 我回答的问题列表
     *
     * @param doctorId
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Page<AnswerQuestion> myAnswerQuestion(String doctorId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return doctorMapper.myAnswerQuestion(doctorId);
    }

    /**
     * 删除回答
     *
     * @param answerId
     * @return
     */
    public int deleteMyAnswerQuestion(String answerId) {
        return doctorMapper.deleteMyAnswerQuestion(answerId);
    }
}
