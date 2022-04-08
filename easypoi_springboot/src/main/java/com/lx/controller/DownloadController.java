package com.lx.controller;

import com.lx.pojo.User;
import com.lx.sercive.DownloadService;
import com.lx.sercive.UserService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/download")
public class DownloadController {

    @Value("${file.uploadFolder}")
    private String uploadFolder;
    @Autowired
    private DownloadService downloadService;
    @Autowired
    private UserService userService;

    @GetMapping("/excel")
    public void downloadExcel(HttpServletResponse response) {
        List<User> all = userService.findAll();
        for (User user : all) {
            int index = user.getPhoto().indexOf("img");
            String imgPath = uploadFolder + user.getPhoto().substring(index);
            user.setPhoto(imgPath);
        }

        Workbook workbook = downloadService.getWorkbook(all);

        try {
            response.setHeader("content-disposition","attachment;fileName="+ URLEncoder.encode("用户列表.xls","UTF-8"));
            ServletOutputStream os = response.getOutputStream();
            workbook.write(os);
            os.close();
            workbook.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
