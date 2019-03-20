package com.neusoft.entity;

import java.util.Date;

/**
 * 医生端
 * 2018/12/27
 */
public class Doctor {

    private String doctorId; //医生id

    private String username; //用户名

    private String password; //密码

    private String sex; //性别

    private String phone; //电话

    private String email; //邮件

    private String hospital; //所属医院

    private Date createTime; //注册时间

    private String identifying; //验证码

    private String blackState; //是否拉黑

    private String pic; //头像

    private String blackMsg;//拉黑原因

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getBlackState() {
        return blackState;
    }

    public void setBlackState(String blackState) {
        this.blackState = blackState;
    }

    public String getIdentifying() {
        return identifying;
    }

    public void setIdentifying(String identifying) {
        this.identifying = identifying;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId == null ? null : doctorId.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital == null ? null : hospital.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getBlackMsg() {
        return blackMsg;
    }

    public void setBlackMsg(String blackMsg) {
        this.blackMsg = blackMsg;
    }
}