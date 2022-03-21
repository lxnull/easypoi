package pojo;

import cn.afterturn.easypoi.excel.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ExcelTarget("user")
public class User implements Serializable {

    @Excel(name = "编号",orderNum = "0")
    private String id;
    @Excel(name = "姓名",orderNum = "1")
    private String name;
    @Excel(name = "年龄",orderNum = "2")
    private int age;
    @Excel(name = "创建日期",orderNum = "3",format = "YYYY-MM-dd HH:mm:ss",width = 30.0)
    private Date createTime;
    @Excel(name = "状态",replace = {"停用_0","启用_1"})
    private int status;
    @ExcelIgnore
    private String text;
    @ExcelIgnore
    private List<String> hobbies;
    @Excel(name = "爱好",width = 25.0,orderNum = "4")
    private String strHobbies;
    @ExcelEntity// 一对一
    private Card card;
//    @ExcelCollection(name = "订单列表",orderNum = "7")// 一对多
    @ExcelIgnore
    private List<Order> orders;
//    @Excel(name = "头像",width = 20.0,type = 2,imageType = 1)
    @ExcelIgnore
    private String photoPath;

    public String getStrHobbies() {
        StringBuffer sb = new StringBuffer();
        List<String> hobbies = this.getHobbies();
        for (String hobby : hobbies) {
                sb.append("," + hobby);
        }
        return sb.substring(1);
    }

    public void setStrHobbies(String strHobbies) {
        throw new UnsupportedOperationException();
    }
}