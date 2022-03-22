package com.lx.sercive.Impl;

import com.lx.mapper.UserMapper;
import com.lx.pojo.User;
import com.lx.sercive.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;

    @Override
    public List<User> findAll() {
        return mapper.findAll();
    }

    @Override
    public int add(User user) {
        int add = mapper.add(user);
        System.out.println(add);
        return add;
    }
}
