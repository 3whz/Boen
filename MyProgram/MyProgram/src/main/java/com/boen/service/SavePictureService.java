package com.boen.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
//传图片的
public interface SavePictureService {
    public String savePicByIo(HttpServletRequest request) throws IOException;

    //form接收
    public String savePicByFormData(MultipartFile file) throws IOException;
}
