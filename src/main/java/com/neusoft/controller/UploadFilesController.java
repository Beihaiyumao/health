package com.neusoft.controller;

import com.neusoft.entity.Result;
import com.neusoft.service.UploadFilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


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
        return uploadFilesService.uploadPic(file);
    }
}
