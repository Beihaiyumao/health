package com.neusoft.dao;

import com.github.pagehelper.Page;
import com.neusoft.entity.AnswerQuestion;
import com.neusoft.entity.Doctor;
import org.apache.ibatis.annotations.Param;

public interface DoctorMapper {
    int deleteByPrimaryKey(String doctorId);


    int insertSelective(Doctor record);

    int updateByPrimaryKeySelective(Doctor record);

    //医生登录
    Doctor login(String email);

    //医生注册
    int doctorRegist(Doctor doctor);

    //医生分页列表
    Page<Doctor> allDoctor();

    //根据医生id删除医生
    int deleteDoctorById(String doctorId);

    //根据医生id查询个人信息
    Doctor selectDoctorInfoById(String doctorId);

    //根据邮箱查询医生被拉黑的原因
    String selectUserBlackMsg(String email);

    //修改个人信息
    int updateDoctorInfo(Doctor doctor);

    //修改密码
    int updatePassword(@Param("doctorId") String doctorId, @Param("password") String password);

    //回答问题
    int insertAnswerQuestion(AnswerQuestion answerQuestion);

    //我的回答列表
    Page<AnswerQuestion> myAnswerQuestion(String doctorId);

    //删除我的回答
    int deleteMyAnswerQuestion(String answerId);

}