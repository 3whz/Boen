package cn.boen.gym.service;

import cn.boen.gym.pojo.User;

import java.util.List;

public interface UserService {
    public User loginUser(User user);

    public List<User> userFindAll();

    public int userSave();

    public int userUpdate();
}
