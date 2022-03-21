package pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ExcelTarget("emp")
public class Emp {

    @Excel(name = "编号")
    private String id;
    @Excel(name = "状态",replace = {"停用_0","启用_1"})
    private int status;
    @Excel(name = "用户名")
    private String uname;
    @Excel(name = "密码")
    private String upwd;
    @Excel(name = "创建日期",format = "YYYY-MM-dd HH:mm:ss")
    private Date createTime;
}