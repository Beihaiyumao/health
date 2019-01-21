package com.neusoft.service;

import com.neusoft.entity.Result;
import com.neusoft.tool.FileUtil;
import com.neusoft.tool.SystemTool;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 文件上传服务器Service
 * 2019/1/21
 */
@Service
public class UploadFilesService {
    public Result uploadPic(MultipartFile file) {
        if (!file.isEmpty()) {
            // 获取文件名称,包含后缀
            String fileName = file.getOriginalFilename();
            //获取文件后缀
            String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
            if (suffix.equals("png") || suffix.equals("jpg")) {

                fileName = SystemTool.uuid() + "." + suffix;
            } else {
                return new Result(200, "只支持png，jgp后缀的图片", false);
            }

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String time = sdf.format(new Date());
            String path = "C://usr/uploadFiles/images/" + time + "/";
            File filePath = new File(path);
            //如果目录不存在则自动创建
            if (!filePath.exists()) {
                filePath.mkdirs();
            }
            try {
                // 该方法是对文件写入的封装，在tool类中，导入该包即可使用，后面会给出方法
                FileUtil.fileupload(file.getBytes(), path, fileName);
                return new Result(100, "上传成功", true);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return new Result(200, "上传失败", false);
            }
        }
        return new Result(200, "未知错误", false);
    }
}
