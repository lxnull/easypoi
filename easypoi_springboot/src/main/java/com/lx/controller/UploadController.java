package com.lx.controller;

import com.lx.pojo.User;
import com.lx.sercive.UploadService;
import com.lx.sercive.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/upload")
public class UploadController {
    @Qualifier("uploadServiceImpl")
    @Autowired
    private UploadService service;

    @Autowired
    private UserService userService;

    @PostMapping("/excel")
    public int uploadExcel(@RequestParam("file")MultipartFile multipartFile, HttpServletRequest request) {
        if (multipartFile.isEmpty()) {
//            Map<String, Object> map = new HashMap<>();
//            map.put("error","文件上传失败");
//            return map;
            return 0;
        }
        Map<String, Object> pathMap = service.uploadMap(multipartFile, "excel");
        String absolutePath = (String) pathMap.get("absolutePath");

        List<User> userList = userService.getUsersFromExcel(absolutePath);

        int add = userService.add(userList);

        System.out.println(add);

        return add;
    }

    @PostMapping("/image")
    public Map<String, Object> uploadImage(@RequestParam("file")MultipartFile multipartFile, HttpServletRequest request) {
        if (multipartFile.isEmpty()) {
            Map<String, Object> map = new HashMap<>();
            map.put("error","文件上传失败");
            return map;
        }
        Map<String, Object> pathMap = service.uploadMap(multipartFile, "img");
        System.out.println(pathMap.toString());
        return pathMap;
    }
}
