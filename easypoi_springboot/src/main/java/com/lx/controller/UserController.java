package com.lx.controller;

import com.lx.pojo.User;
import com.lx.sercive.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Qualifier("userServiceImpl")
    @Autowired
    private UserService service;

    @GetMapping("/findall")
    public List<User> findAll() {
        List<User> users = service.findAll();
        return users;
    }

    @GetMapping("/add")
    public int add(String uname, String pwd, String createTimeStr, int sex) {
        User user = new User();
        user.setUname(uname);
        user.setPwd(pwd);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            Date createTime = simpleDateFormat.parse(createTimeStr);
            user.setCreateTime(createTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setSex(sex);
        int add = service.add(user);
        System.out.println(add);
        return add;
    }
}
