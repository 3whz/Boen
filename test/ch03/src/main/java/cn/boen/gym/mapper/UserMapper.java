package cn.boen.gym.mapper;

import cn.boen.gym.pojo.User;

import java.util.List;

public interface UserMapper {
    //登录方法
    public User loginUser(User user);


    //查询所有
    public List<User> userFindAll();

    public int userSave();

    public int userUpdate();
}
