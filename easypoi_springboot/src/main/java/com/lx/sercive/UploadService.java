package com.lx.sercive;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Service
public interface UploadService {

    /*
    MultipartFile：这个对象是springMVC提供的文件上传的接受类。
    他的底层会自动和HttpServletRequest request中的request.getInputStream()融合，从而达到文件上传的效果。
    文件上传的底层原理：request.getInputStream()
     */
    // 进返回链接
    public String upload(MultipartFile multipartFile, String dir);
    // 返回完整存储信息
    public Map<String,Object> uploadMap(MultipartFile multipartFile, String dir);
}
