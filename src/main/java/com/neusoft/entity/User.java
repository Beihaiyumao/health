package com.neusoft.entity;

import java.util.Date;

/**
 * 用户信息
 */
public class User {

    private String userId; //用户id

    private String username; //用户名

    private String password; //密码

    private Integer sex; //性别

    private String email; //邮箱

    private String phone; //电话

    private Date createTime; //注册时间

    private String pic; //头像

    private String address; //住址

    private String identifying; //验证码

    private String blackState; //是否被拉黑

    private String blackMsg; //拉黑原因

    private Date blackTime; //拉黑时间

    public String getBlackState() {
        return blackState;
    }

    public void setBlackState(String blackState) {
        this.blackState = blackState;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getIdentifying() {
        return identifying;
    }

    public void setIdentifying(String identifying) {
        this.identifying = identifying;
    }

    public String getBlackMsg() {
        return blackMsg;
    }

    public void setBlackMsg(String blackMsg) {
        this.blackMsg = blackMsg;
    }

    public Date getBlackTime() {
        return blackTime;
    }

    public void setBlackTime(Date blackTime) {
        this.blackTime = blackTime;
    }
}