package com.boen.controller;

import com.boen.domain.ClassClassify;
import com.boen.service.ClassClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Controller
@CrossOrigin   //跨域
public class ClassClassifyController {
    @Autowired
    private ClassClassifyService classClassifyService;

    /**
     * 添加分类
     *
     * @param classClassify
     * @return 自增id
     */
    @RequestMapping("/ClassClassifyInsert")
    @ResponseBody
    public Integer ClassClassifyInsert(ClassClassify classClassify) {
        classClassifyService.ClassClassifyInsert(classClassify);
        return classClassify.getId();
    }

    /**
     * 批量删除分类  删除的时候记得放到集合里
     *
     * @param classClassifyList
     * @return row 受影响行数
     */
    @RequestMapping("/ClassClassifyDelete")
    @ResponseBody
    public Integer ClassClassifyDelete(List<ClassClassify> classClassifyList) {
        int row = classClassifyService.ClassClassifyDelete(classClassifyList);
        return row;
    }

    /**
     * 修改分类
     *
     * @param classClassify
     * @return row 受影响行数
     */
    @RequestMapping("/ClassClassifyUpdate")
    @ResponseBody
    public Integer ClassClassifyUpdate(ClassClassify classClassify) {
        int row = classClassifyService.ClassClassifyUpdate(classClassify);
        return row;
    }

    /**
     * 查询分类
     *
     * @param classClassify
     * @return List<ClassClassify>
     */
    @RequestMapping("/ClassClassifySelect")
    @ResponseBody
    public List<ClassClassify> ClassClassifySelect(ClassClassify classClassify) {
        List<ClassClassify> classClassifyList = classClassifyService.ClassClassifySelect(classClassify);
        return classClassifyList;
    }

    /**
     * 分类包含课程
     *
     * @param classClassify
     * @return List<ClassClassify>
     */
    @RequestMapping("/ClassClassifyJointGymClassSelect")
    @ResponseBody
    public List<ClassClassify> ClassClassifyJointGymClassSelect(ClassClassify classClassify) {
        List<ClassClassify> classClassifyList = classClassifyService.ClassClassifyJointGymClassSelect(classClassify);
        return classClassifyList;
    }
}
