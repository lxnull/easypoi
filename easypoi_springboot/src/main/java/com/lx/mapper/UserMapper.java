package com.lx.mapper;

import com.lx.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    public List<User> findAll();

    public int add(User user);
}
