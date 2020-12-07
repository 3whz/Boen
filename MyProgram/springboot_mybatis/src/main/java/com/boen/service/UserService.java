package com.boen.service;

import com.boen.domain.GymClass;
import com.boen.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    /**
     * 添加用户
     *
     * @param user
     * @return 自增id
     */
    public int UserInsert(User user);
    /**
     * 批量删除  删除的时候记得放到集合里
     *
     * @param userList
     * @return row 受影响行数
     */
    public int UserDelete(List<User> userList);
    /**
     * 修改用户
     *
     * @param user
     * @return row 受影响行数
     */
    public int UserUpdate(User user);
    /**
     * 查询用户
     *
     * @param user
     * @return List<User>
     */
    public List<User> UserSelect(User user);


    /**
     * 联表
     * @param user
     * @return
     */
    public List<User> UserJointGymClassSelect(User user);

    public List<User> CUserJointGymClassSelect(User user);

}
