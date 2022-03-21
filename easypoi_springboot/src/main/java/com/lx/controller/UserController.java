package com.lx.controller;

import com.lx.pojo.User;
import com.lx.sercive.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
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

        for (User user : users) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
            String data = simpleDateFormat.format(user.getCreateTime());
            user.setTimeString(data);
        }

        return users;
    }
}
