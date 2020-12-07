package com.boen.controller;

import com.boen.domain.GymClass;
import com.boen.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@CrossOrigin   //跨域
public class GymClassController {
    //图片
    @Autowired
    private SavePictureService savePictureService;
    @Autowired
    private GymClassService gymClassService;
    //课程

    /**
     * 添加课程 上传封面
     *
     * @param gymClass
     * @return 自增id
     */
    @RequestMapping("/GymClassInsert")
    @ResponseBody
    public int GymClassInsert(@RequestParam("file") MultipartFile file, GymClass gymClass) throws IOException {
        //传图片返回图片名
        String fileName = savePictureService.savePicByFormData(file);
        //存入数据库反填自增id
        gymClass.setImg(fileName);
        gymClassService.GymClassInsert(gymClass);
        return gymClass.getId();
    }

    /**
     * 批量删除课程  删除的时候记得放到集合里
     *
     * @param gymClassList
     * @return row 受影响行数
     */
    @RequestMapping("/GymClassDelete")
    @ResponseBody
    public void GymClassDelete(List<GymClass> gymClassList) {
        gymClassService.GymClassDelete(gymClassList);
    }

    /**
     * 修改课程
     *
     * @param gymClass
     * @return row 受影响行数
     */
    @RequestMapping("/GymClassUpdate")
    @ResponseBody
    public int GymClassUpdate(GymClass gymClass) {
        int row = gymClassService.GymClassUpdate(gymClass);
        return row;
    }

    /**
     * 查询课程
     *
     * @param gymClass
     * @return List<GymClass>
     */
    @RequestMapping("/GymClassSelect")
    @ResponseBody
    public List<GymClass> GymClassSelect(GymClass gymClass) {
        List<GymClass> gymClassList = gymClassService.GymClassSelect(gymClass);
        return gymClassList;
    }
    /**
     * 半联表多对多从映射表查到课程
     *
     * @param id
     * @return List<GymClass>  与该id相关的课程信息
     */
    @RequestMapping("/GymClassByUIdSelect")
    @ResponseBody
    public List<GymClass> GymClassByUIdSelect(int id) {
        List<GymClass> gymClassList = gymClassService.GymClassByUIdSelect(id);
        return gymClassList;
    }

}
