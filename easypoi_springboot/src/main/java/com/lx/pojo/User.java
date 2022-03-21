package com.lx.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@ExcelTarget("user")
public class User implements Serializable {

    @Excel(name = "id",orderNum = "0")
    private String id;
    @Excel(name = "用户名",orderNum = "1")
    private String uname;
    @Excel(name = "密码",orderNum = "2")
    private String pwd;
    @Excel(name = "创建时间",orderNum = "3",format = "YYYY-MM-dd HH:mm:ss")
    private Date createTime;
    @Excel(name = "头像",width = 20.0,type = 2,savePath = "G:\\JavaSpace\\Java进阶\\easypoi\\easypoi_springboot\\src\\main\\resources\\static\\img")
    private String photo;
    @Excel(name = "性别",orderNum = "2",replace = {"女_0","男_1"})
    private int sex;
    @Excel(name = "状态",orderNum = "4",replace = {"停用_0","启用_1"})
    private int status;

    private String TimeString;
}