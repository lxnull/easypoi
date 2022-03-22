package com.lx.sercive.Impl;

import com.lx.sercive.UploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class UploadServiceImpl implements UploadService {

    /*
    MultipartFile：这个对象是springMVC提供的文件上传的接受类。
    他的底层会自动和HttpServletRequest request中的request.getInputStream()融合，从而达到文件上传的效果。
    文件上传的底层原理：request.getInputStream()
     */

    @Override
    public String uploadExcel(MultipartFile multipartFile, String dir) {
        // 1.指定文件上传的目录
        File targetFile = new File("G:\\JavaSpace\\Java进阶\\easypoi\\easypoi_springboot\\src\\main\\resources\\file" + dir);
        try {
            if (!targetFile.exists()) {
                targetFile.mkdirs();
            }
            // 2.指定文件名
            File file = new File(targetFile, multipartFile.getOriginalFilename());
            // 3.上传到指定的目录
            multipartFile.transferTo(file);
            return "ok";
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
    }
}
