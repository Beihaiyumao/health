package com.neusoft.dao;

import com.neusoft.entity.Blacklist;
import com.neusoft.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(String userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(User record);

    //更新用户信息
    int updateUserInfo(User user);

    /***用户注册**/
    void registNewUser(User regist);

    /***用户登录**/
    User login(String email);

    /***永久注销用户***/
    void deleteUser(String userId);

    /***根据用户id查询用户信息*****/
    User selectUserInfoByUserId(String userId);

    //根据邮箱查询用户被拉黑的原因
    String selectUserBlackMsg(String email);

    // 修改密码
    int updatePassword(@Param("userId") String userId, @Param("password") String password);
    //更新头像
    int updateHeadPhoto(@Param("path")String path,@Param("userId")String userId);
}