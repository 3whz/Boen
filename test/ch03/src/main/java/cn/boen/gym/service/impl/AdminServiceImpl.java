package cn.boen.gym.service.impl;

import cn.boen.gym.mapper.AdminMapper;
import cn.boen.gym.pojo.Admin;
import cn.boen.gym.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional    //事务
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public Admin loginAdmin(Admin admin) {
        Admin admin2 =(Admin)adminMapper.loginAdmin(admin);
        return admin2;
    }
}
