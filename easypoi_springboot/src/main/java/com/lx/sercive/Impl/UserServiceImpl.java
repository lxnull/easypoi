package com.lx.sercive.Impl;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.lx.mapper.UserMapper;
import com.lx.pojo.User;
import com.lx.sercive.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
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

    @Override
    public int add(List<User> userList) {
        for (User user : userList) {
//            System.out.println(user);
            mapper.add(user);
        }
        return userList.size();
    }

    @Override
    public List<User> getUsersFromExcel(String path) {
        FileInputStream fis = null;
        List<User> userlist = null;
        try {
            fis = new FileInputStream(path);
            ImportParams params = new ImportParams();
            params.setTitleRows(1);
            params.setHeadRows(1);
            userlist = ExcelImportUtil.importExcel(fis, User.class, params);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("操作成功");
        return userlist;
    }


}
