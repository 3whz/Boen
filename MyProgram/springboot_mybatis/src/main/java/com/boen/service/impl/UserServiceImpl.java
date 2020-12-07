package com.boen.service.impl;

import com.boen.domain.User;
import com.boen.mapper.UserMapper;
import com.boen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service//服务层（注入dao）
@Transactional    //事务
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 添加用户
     *
     * @param user
     * @return 自增id
     */
    @Override
    public int UserInsert(User user) {
        userMapper.UserInsert(user);
        return user.getId();
    }

    /**
     * 批量删除  删除的时候记得放到集合里
     *
     * @param userList
     * @return row 受影响行数
     */
    @Override
    public int UserDelete(List<User> userList) {
        int row = userMapper.UserDelete(userList);
        return row;
    }

    /**
     * 修改用户
     *
     * @param user
     * @return row 受影响行数
     */
    @Override
    public int UserUpdate(User user) {
        int row = userMapper.UserUpdate(user);
        return row;
    }

    /**
     * 查询用户
     *
     * @param user
     * @return List<User>
     */
    @Override
    public List<User> UserSelect(User user) {
        return userMapper.UserSelect(user);
    }

    //联表
    @Override
    public List<User> UserJointGymClassSelect(User user) {
        return userMapper.UserJointGymClassSelect(user);
    }

    @Override
    public List<User> CUserJointGymClassSelect(User user) {
        return userMapper.CUserJointGymClassSelect(user);
    }


}
