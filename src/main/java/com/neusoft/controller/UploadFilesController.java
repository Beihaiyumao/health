package com.neusoft.controller;

import com.neusoft.entity.Result;
import com.neusoft.service.UploadFilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 文件上传服务器
 * 2019/1/21
 */
@RestController
@RequestMapping("/uploadFiles")
public class UploadFilesController {
    @Autowired
    private UploadFilesService uploadFilesService;

    /**
     * 上传图片，只支持jpg,png
     *
     * @param file
     * @return
     */
    @PostMapping("/uploadPic")
    public Result uploadPic(@RequestParam("file") MultipartFile file) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String time = sdf.format(new Date());
        String path = "C://usr/uploadFiles/images/" + time + "/";
        return uploadFilesService.uploadPic(file, path);
    }

    /**
     * 小程序修改用户头像
     *
     * @param file
     * @return
     */
    @PostMapping("/changUserPho")
    public Result changUserPho(@RequestParam("file") MultipartFile file) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String time = sdf.format(new Date());
        // 存放在这个路径下：该路径是该工程目录下的static文件下：(注：该文件可能需要自己创建)
        // 放在static下的原因是，存放的是静态文件资源，即通过浏览器输入本地服务器地址，加文件名时是可以访问到的
        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/" + "img/" + "headPhoto/" + time + "/";
        String s="C:/Program Files/Apache Software Foundation/Tomcat 8.5/webapps/health/WEB-INF/classes/static/img/headPhoto/" + time + "/";
        return uploadFilesService.uploadPic(file, s);
    }

}
