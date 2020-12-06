package com.boen.service.impl;

import com.boen.domain.Admin;
import com.boen.mapper.AdminMapper;
import com.boen.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional    //事务
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    /**
     *添加管理员
     * @param admin
     * @return 自增id
     */
    @Override
    public int AdminInsert(Admin admin) {
        adminMapper.AdminInsert(admin);
        //反回自增id
        return admin.getId();
    }
    /**
     * 批量删除  删除的时候记得放到集合里
     * @param adminList
     * @return row 受影响行数
     */
    @Override
    public int AdminDelete(List<Admin> adminList) {
        int row= adminMapper.AdminDelete(adminList);
        return row;
    }
    /**
     *修改管理员
     * @param admin
     * @return row 受影响行数
     */
    @Override
    public int AdminUpdate(Admin admin) {
        int row= adminMapper.AdminUpdate(admin);
        return row;
    }
    /**
     * 查询管理员
     * @param admin
     * @return List<Admin>
     */
    @Override
    public List<Admin> AdminSelect(Admin admin) {
        List<Admin> adminList=adminMapper.AdminSelect(admin);
        return adminList;
    }

}
