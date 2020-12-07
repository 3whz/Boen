package com.boen.service;

import com.boen.domain.GymClass;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GymClassService {
    /**
     * 添加课程
     *
     * @param gymClass
     * @return 自增id
     */
    public int GymClassInsert(GymClass gymClass);

    /**
     * 批量删除课程  删除的时候记得放到集合里
     *
     * @param gymClass
     * @return row 受影响行数
     */
    public int GymClassDelete(List<GymClass> gymClass);

    /**
     * 修改课程
     *
     * @param gymClass
     * @return row 受影响行数
     */
    public int GymClassUpdate(GymClass gymClass);

    /**
     * 查询课程
     *
     * @param gymClass
     * @return List<GymClass>
     */
    public List<GymClass> GymClassSelect(GymClass gymClass);

    //联表
    public List<GymClass> GymClassByUIdSelect(int id);

    //上传的课程
    public List<GymClass> GymClassByCUIdSelect(int id);
}