package com.boen.service.impl;

import com.boen.domain.ClassClassify;
import com.boen.mapper.ClassClassifyMapper;
import com.boen.service.ClassClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional    //事务
public class ClassClassifyServiceImpl implements ClassClassifyService {
    @Autowired
    private ClassClassifyMapper classClassifyMapper;

    /**
     *添加分类
     * @param classClassify
     * @return 自增id
     */
    @Override
    public int ClassClassifyInsert(ClassClassify classClassify) {
        classClassifyMapper.ClassClassifyInsert(classClassify);
        return classClassify.getId();
    }
    /**
     * 批量删除分类  删除的时候记得放到集合里
     * @param classClassifyList
     * @return row 受影响行数
     */
    @Override
    public int ClassClassifyDelete(List<ClassClassify> classClassifyList) {
        int row = classClassifyMapper.ClassClassifyDelete(classClassifyList);
        return row;
    }
    /**
     *修改分类
     * @param classClassify
     * @return row 受影响行数
     */
    @Override
    public int ClassClassifyUpdate(ClassClassify classClassify) {
        int row = classClassifyMapper.ClassClassifyUpdate(classClassify);
        return row;
    }
    /**
     * 查询分类
     * @param classClassify
     * @return List<Admin>
     */
    @Override
    public List<ClassClassify> ClassClassifySelect(ClassClassify classClassify) {
        List<ClassClassify> classClassifyList = classClassifyMapper.ClassClassifySelect(classClassify);
        return classClassifyList;
    }

    /**
     * 分类包含课程
     * @param classClassify
     * @return List<ClassClassify>
     */
    @Override
    public List<ClassClassify> ClassClassifyJointGymClassSelect(ClassClassify classClassify) {
        List<ClassClassify>  classClassifyList= classClassifyMapper.ClassClassifyJointGymClassSelect(classClassify);
        return classClassifyList;
    }
}
