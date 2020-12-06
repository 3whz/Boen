package com.boen.service.impl;

import com.boen.domain.Admin;
import com.boen.domain.GymClass;
import com.boen.mapper.AdminMapper;
import com.boen.mapper.GymClassMapper;
import com.boen.service.AdminService;
import com.boen.service.SavePictureService;
import com.boen.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.UUID;

//传图片的
@Service
@Transactional    //事务
public class SavePictureServiceImpl implements SavePictureService {

    @Autowired
    private GymClassMapper gymClassMapper;

    public String savePicByIo(HttpServletRequest request) throws IOException {
        // 图片存储路径
        String path = "E:\\image\\factory";
        // 判断是否有路径
        if (!new File(path).exists()) {
            new File(path).mkdirs();
        }
        ServletInputStream inputStream = request.getInputStream();
        //UUID生成唯一识别码
        String fileName = UUID.randomUUID().toString().replace("-","") + ".jpg";
        File tempFile = new File(path,fileName);
        if (!tempFile.exists()) {
            OutputStream os = new FileOutputStream(tempFile);
            BufferedOutputStream bos = new BufferedOutputStream(os);
            byte[] buf = new byte[1024];
            int length;
            length = inputStream.read(buf,0,buf.length);
            while (length != -1) {
                bos.write(buf, 0 , length);
                length = inputStream.read(buf);
            }
            bos.close();
            os.close();
            inputStream.close();
        }
        return fileName;
    }

    //传图片的用的这个
    public String savePicByFormData(MultipartFile file) throws IOException {
        // 图片存储路径
        String path = "E:\\image\\factory";
        // 判断是否有路径
        if (!new File(path).exists()) {
            new File(path).mkdirs();
        }
        String fileName = UUID.randomUUID().toString().replace("-","") + ".jpg";
        File tempFile = new File(path,fileName);
        if (!tempFile.exists()) {
            tempFile.createNewFile();
        }
        file.transferTo(tempFile);

        return fileName;
    }
}
