package com.neusoft.service;

import com.neusoft.DataDictionary.BlackState;
import com.neusoft.dao.UserMapper;
import com.neusoft.entity.Blacklist;
import com.neusoft.entity.User;
import com.neusoft.tool.SystemTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    //错误信息
    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * 用户注册
     *
     * @param regist
     */
    public void registNewUser(User regist) {
        //获取当前时间
        regist.setCreateTime(SystemTool.getDateTime());
        //用户id
        regist.setUserId(SystemTool.uuid());
        regist.setBlackState(BlackState.BLACK_STATE_FALSE.getCode());
        userMapper.registNewUser(regist);
    }

    /**
     * 用户登陆
     *
     * @param login
     * @return
     */
    public boolean login(User login) {
        boolean success = true;
        User loginUser = userMapper.login(login.getEmail());
        if (loginUser == null) {
            errorMessage = "用户名错误!";
            success = false;
        } else if (!loginUser.getPassword().equals(login.getPassword())) {
            errorMessage = "密码错误!";
            success = false;
        } else {
            errorMessage = "登录成功!";
        }
        return success;
    }

    /*****根据用户Id查询用户信息****/
    public User selectUserInfoByUserId(String userId) {
        return userMapper.selectUserInfoByUserId(userId);
    }

    /*****根据邮箱查询用户信息****/
    public User selectUserInfoByEmail(String email) {
        return userMapper.login(email);
    }

    /****永久注销用户****/
    public void deleteUser(String userId) {
        userMapper.deleteUser(userId);
    }

    /**
     * 更新用户信息
     *
     * @param user
     * @return
     */
    public int updateUserInfo(User user) {
        int code = userMapper.updateUserInfo(user);
        return code;
    }

    /**
     * 修改密码
     *
     * @param userId
     * @param password
     * @return
     */
    public int updatePassword(String userId, String password) {
        return userMapper.updatePassword(userId, password);
    }

}
