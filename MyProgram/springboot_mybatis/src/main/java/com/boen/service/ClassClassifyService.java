package com.boen.service;

import com.boen.domain.Admin;
import com.boen.domain.ClassClassify;
import com.boen.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClassClassifyService {

        /**
         *添加分类
         * @param classClassify
         * @return 自增id
         */
        public int ClassClassifyInsert(ClassClassify classClassify);
        /**
         * 批量删除分类  删除的时候记得放到集合里
         * @param classClassifyList
         * @return row 受影响行数
         */
        public int ClassClassifyDelete(@Param("idList") List<ClassClassify> classClassifyList);
        /**
         *修改分类
         * @param classClassify
         * @return row 受影响行数
         */
        public int ClassClassifyUpdate(ClassClassify classClassify);
        /**
         * 查询分类
         * @param classClassify
         * @return List<Admin>
         */
        public List<ClassClassify> ClassClassifySelect(ClassClassify classClassify);


//联表

    public List<ClassClassify> ClassClassifyJointGymClassSelect(ClassClassify classClassify);
}
