package cn.boen.gym.service;

import cn.boen.gym.pojo.User;

import java.util.List;

public interface UserService {
    public User loginAdmin(User user);

    public List<User> UserFindAll();

    public int UserSave();

    public int UserUpdate();
}
