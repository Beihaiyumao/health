package com.neusoft.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.neusoft.DataDictionary.BlackState;
import com.neusoft.dao.UserMapper;
import com.neusoft.entity.*;
import com.neusoft.tool.FileUtil;
import com.neusoft.tool.SystemTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    public Result deleteUser(String userId) {
        int code = userMapper.deleteUser(userId);
        if (code == 1) {
            return new Result(100, "注销成功", true);
        } else {
            return new Result(200, "注销失败", false);
        }
    }

    /**
     * 更新用户信息
     *
     * @param user
     * @return
     */
    public Result updateUserInfo(User user) {
        int code = userMapper.updateUserInfo(user);
        if (code == 1) {
            return new Result(100, "更新个人信息成功", true);
        } else {
            return new Result(200, "更新个人信息失败", false);
        }

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

    /**
     * 上传头像
     *
     * @param fileName
     * @return
     */
    public Result updateHeadPhoto(String fileName, String userId) {
//        if (!file.isEmpty()) {
////            // 获取文件名称,包含后缀
////            String fileName = file.getOriginalFilename();
////            //获取文件后缀
////            String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
////            if (suffix.equals("png") || suffix.equals("jpg")) {
////
////                fileName = SystemTool.uuid() + "." + suffix;
////            } else {
////                return new Result(200, "只支持png，jgp后缀的图片", false);
////            }
////
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String time = sdf.format(new Date());
////            // 存放在这个路径下：该路径是该工程目录下的static文件下：(注：该文件可能需要自己创建)
////            // 放在static下的原因是，存放的是静态文件资源，即通过浏览器输入本地服务器地址，加文件名时是可以访问到的
////            String path = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/" + "img/" + "headPhoto/" + time + "/";
////            File filePath = new File(path);
////            //如果目录不存在则自动创建
////            if (!filePath.exists()) {
////                filePath.mkdirs();
////            }
////            try {
////                // 该方法是对文件写入的封装，在tool类中，导入该包即可使用，后面会给出方法
////                FileUtil.fileupload(file.getBytes(), path, fileName);
////            } catch (IOException e) {
////                // TODO Auto-generated catch block
////                e.printStackTrace();
////            }
        int code = userMapper.updateHeadPhoto("img/headPhoto/" + time + "/" + fileName, userId);
        if (code == 1) {
            return new Result(100, "上传成功", true);
        } else {
            return new Result(200, "上传失败", false);
        }

//        }
//        return new Result(200, "上传失败", false);
    }

    /**
     * 分页搜索我收藏的文章
     *
     * @param pageNum
     * @param pageSize
     * @param userId
     * @param title
     * @return
     */
    public Page<HealthyArticle> selectMyHealthyArticle(Integer pageNum, Integer pageSize, String userId, String title) {
        PageHelper.startPage(pageNum, pageSize);
        return userMapper.selectMyHealthyArticle(userId, title);
    }

    /**
     * 搜索我的问题
     *
     * @param pageNum
     * @param pageSize
     * @param userId
     * @param title
     * @return
     */
    public Page<Question> selectMyQuestion(Integer pageNum, Integer pageSize, String userId, String title) {
        PageHelper.startPage(pageNum, pageSize);
        return userMapper.selectMyQuestion(userId, title);
    }
}
