package pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ExcelTarget("card")
public class Card implements Serializable {

    @Excel(name = "身份编码",width = 25.0,orderNum = "5")
    public String id;
    @Excel(name = "地址",width = 25.0,orderNum = "6")
    public String address;
}