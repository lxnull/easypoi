package com.lx.sercive;

import com.lx.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public List<User> findAll();

    public int add(User user);

    public int add(List<User> userList);

    public List<User> getUsersFromExcel(String path);
}
