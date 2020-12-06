package com.boen.controller;

import com.boen.domain.GymClass;
import com.boen.service.GymClassService;
import com.boen.service.SavePictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
//图片上传的一些方法  没什么用
@Controller
@CrossOrigin   //跨域
public class GetImg {
    @Autowired
    private SavePictureService savePictureService;
    @Autowired
    private GymClassService gymClassService;
    @PostMapping("savePicByIo")
    @ResponseBody
    public String savePicByIo(HttpServletRequest request) throws Exception{
        System.out.println("图片上传开始");
        String fileName = savePictureService.savePicByIo(request);
        return fileName;
    }

    @PostMapping("/savePicByFormData")
    @ResponseBody
    public Integer savePicByFormData(@RequestParam("file") MultipartFile file,GymClass gymClass) throws IOException {
        //传图片返回图片名
        String fileName = savePictureService.savePicByFormData(file);
        //存入数据库反填自增id
        gymClass.setImg(fileName);
        gymClassService.GymClassInsert(gymClass);
        return gymClass.getId();
    }
}
