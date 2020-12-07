package com.boen.controller;

import com.boen.domain.User;
import com.boen.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin   //跨域
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 添加用户
     *
     * @param user
     * @return 自增id
     */
    @RequestMapping("/UserInsert")
    @ResponseBody
    public int UserInsert(User user) {
        int id = userService.UserInsert(user);
        return id;
    }

    /**
     * 批量删除  删除的时候记得放到集合里
     *
     * @param userList
     * @return row 受影响行数
     */
    @RequestMapping("/UserDelete")
    @ResponseBody
    public void UserDelete(List<User> userList) {
        userService.UserDelete(userList);
    }

    /**
     * 修改用户
     *
     * @param user
     * @return row 受影响行数
     */
    @RequestMapping("/UserUpdate")
    @ResponseBody
    public int UserUpdate(User user) {
        int row = userService.UserUpdate(user);
        return row;
    }

    /**
     * 查询用户
     *
     * @param user
     * @return List<User>
     */
    @RequestMapping("/UserSelect")
    @ResponseBody
    public List<User> selectUser(User user) {
        List<User> userList = userService.UserSelect(user);
        return userList;
    }

    /**
     * 全联表多对多从用户_课程
     *
     * @param user
     * @return List<User>  用户信息和用户所属课程信息
     */
    @RequestMapping("/UserJointGymClassSelect")
    @ResponseBody
    public List<User> UserJointGymClassSelect(User user) {
        List<User> userList = userService.UserJointGymClassSelect(user);
        return userList;
    }
    /**
     * 全联表多对多从用户_课程
     *
     * @param user
     * @return List<User>  用户信息和用户所属课程信息
     */
    @RequestMapping("/CUserJointGymClassSelect")
    @ResponseBody
    public List<User> CUserJointGymClassSelect(User user) {
        List<User> userList = userService.CUserJointGymClassSelect(user);
        return userList;
    }
}
