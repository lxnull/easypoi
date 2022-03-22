package com.lx.controller;

import com.lx.sercive.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
@RequestMapping("/upload")
public class UploadController {

    @Qualifier("uploadServiceImpl")
    @Autowired
    private UploadService service;

    @PostMapping("/excel")
    public String upload(MultipartFile multipartFile, HttpServletRequest request) {
        if (multipartFile.isEmpty()) {
            return "文件有误";
        }
        // 获取用户指定的文件夹
        // 问这个文件夹为什么要从页面上传递过来？
        // 做隔离，不同业务，不同文件放在不同目录中。
        String dir = request.getParameter("dir");
        return service.uploadExcel(multipartFile, dir);
    }
}
