package cn.boen.gym.service.impl;

import cn.boen.gym.mapper.UserMapper;
import cn.boen.gym.pojo.Admin;
import cn.boen.gym.pojo.User;
import cn.boen.gym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional    //事务
public class UserServiceImpl  implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User loginUser(User user) {
        User user2 =(User)userMapper.loginUser(user);
        return user2;
    }

    @Override
    public List<User> userFindAll() {
        return null;
    }

    @Override
    public int userSave() {
        return 0;
    }

    @Override
    public int userUpdate() {
        return 0;
    }
}
