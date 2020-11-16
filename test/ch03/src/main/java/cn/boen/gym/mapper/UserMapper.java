package cn.boen.gym.mapper;

import cn.boen.gym.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    //登录方法
    @Select("select * from user where username = #{username} and password = #{password}")
    public User loginUser(User user);


    //查询所有用户
    public List<User> userFindAll();

    public int userSave();

    public int userUpdate();
}
