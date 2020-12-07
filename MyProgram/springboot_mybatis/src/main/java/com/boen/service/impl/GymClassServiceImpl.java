package com.boen.service.impl;

import com.boen.domain.GymClass;
import com.boen.mapper.GymClassMapper;
import com.boen.service.GymClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional    //事务
public class GymClassServiceImpl implements GymClassService {

    @Autowired
    private GymClassMapper gymClassMapper;


    /**
     * 添加课程
     *
     * @param gymClass
     * @return 自增id
     */
    @Override
    public int GymClassInsert(GymClass gymClass) {
       gymClassMapper.GymClassInsert(gymClass);
       return gymClass.getId();
    }
    /**
     * 批量删除课程  删除的时候记得放到集合里
     *
     * @param gymClass
     * @return row 受影响行数
     */
    @Override
    public int GymClassDelete(List<GymClass> gymClass) {
       int row = gymClassMapper.GymClassDelete(gymClass);
        return row;
    }
    /**
     * 修改课程
     *
     * @param gymClass
     * @return row 受影响行数
     */
    @Override
    public int GymClassUpdate(GymClass gymClass) {
        int row =gymClassMapper.GymClassUpdate(gymClass);
        return row;
    }
    /**
     * 查询课程
     *
     * @param gymClass
     * @return List<GymClass>
     */
    @Override
    public List<GymClass> GymClassSelect(GymClass gymClass){
        List<GymClass> gymClassList= gymClassMapper.GymClassSelect(gymClass);
//        List<User> useres = new ArrayList<User>();
//        gymClass=gymClasses.get(0);
//        System.out.println(gymClass.getName());
//        gymClasses.add(gymClass);
//        gymClasses.remove(0);
        return gymClassList;
    }

    /**
     * 通过用户id查课
     * @param id
     * @return
     */
    @Override
    public List<GymClass> GymClassByUIdSelect(int id) {
        List<GymClass> gymClasseList= gymClassMapper.GymClassByUIdSelect(id);
        return gymClasseList;
    }

    @Override
    public List<GymClass> GymClassByCUIdSelect(int id) {
        List<GymClass> gymClasseList= gymClassMapper.GymClassByCUIdSelect(id);
        return gymClasseList;

    }


}
