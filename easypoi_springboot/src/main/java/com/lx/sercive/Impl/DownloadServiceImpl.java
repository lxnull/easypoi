package com.lx.sercive.Impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.lx.pojo.User;
import com.lx.sercive.DownloadService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

import java.io.OutputStream;
import java.util.List;

@Service
public class DownloadServiceImpl implements DownloadService {
    @Override
    public Workbook getWorkbook(List<User> userList) {
        ExportParams exportParams = new ExportParams("用户信息表", "信息表1");
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, User.class, userList);
        return workbook;
    }
}
