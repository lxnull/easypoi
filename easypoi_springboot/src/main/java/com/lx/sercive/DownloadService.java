package com.lx.sercive;

import com.lx.pojo.User;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

import java.io.OutputStream;
import java.util.List;

@Service
public interface DownloadService {

    public Workbook getWorkbook(List<User> userList);
}
