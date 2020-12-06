package com.boen.controller;

import com.boen.domain.Admin;
import com.boen.domain.Gym;
import com.boen.domain.GymClass;
import com.boen.domain.User;
import com.boen.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@CrossOrigin   //跨域
public class MybatisController {
    //保存图片的还没整合
    @Autowired
    private SavePictureService savePictureService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private Userservice userService;
    @Autowired
    private GymClassService gymClassService;
    @Autowired
    private GymService gymService;
    //管理员部分

    /**
     * 添加管理员
     *
     * @param admin
     * @return 自增id
     */
    @RequestMapping("/AdminInsert")
    @ResponseBody
    public int AdminInsert(Admin admin) {
        int id = adminService.AdminInsert(admin);
        return id;
    }

    /**
     * 批量删除  删除的时候记得放到集合里
     *
     * @param AdminList
     * @return row 受影响行数
     */
    @RequestMapping("/AdminDelete")
    @ResponseBody
    public int DeleteAdmin(List<Admin> AdminList) {
        int row = adminService.AdminDelete(AdminList);
        return row;
    }

    /**
     * 修改管理员
     *
     * @param admin
     * @return row 受影响行数
     */
    @RequestMapping("/AdminUpdate")
    @ResponseBody
    public int AdminUpdate(Admin admin) {
        int row = adminService.AdminUpdate(admin);
        return row;
    }

    /**
     * 查询管理员
     *
     * @param admin
     * @return List<Admin>
     */
    @RequestMapping("/AdminSelect")
    @ResponseBody
    public List<Admin> selectAdmin(HttpServletRequest request, HttpSession session, Admin admin) {
        List<Admin> adminList = adminService.AdminSelect(admin);
        return adminList;
    }
//用户部分

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

    //课程

    /**
     * 添加课程 上传封面
     *
     * @param gymClass
     * @return 自增id
     */
    @RequestMapping("/GymClassInsert")
    @ResponseBody
    public int GymClassInsert(@RequestParam("file") MultipartFile file, GymClass gymClass) throws IOException {
        //传图片返回图片名
        String fileName = savePictureService.savePicByFormData(file);
        //存入数据库反填自增id
        gymClass.setImg(fileName);
        gymClassService.GymClassInsert(gymClass);
        return gymClass.getId();
    }

    /**
     * 批量删除课程  删除的时候记得放到集合里
     *
     * @param gymClassList
     * @return row 受影响行数
     */
    @RequestMapping("/GymClassDelete")
    @ResponseBody
    public void GymClassDelete(List<GymClass> gymClassList) {
        gymClassService.GymClassDelete(gymClassList);
    }
    /**
     * 修改课程
     *
     * @param gymClass
     * @return row 受影响行数
     */
    @RequestMapping("/GymClassUpdate")
    @ResponseBody
    public int GymClassUpdate(GymClass gymClass) {
        int row = gymClassService.GymClassUpdate(gymClass);
        return row;
    }
    /**
     * 查询课程
     *
     * @param gymClass
     * @return List<GymClass>
     */
    @RequestMapping("/GymClassSelect")
    @ResponseBody
    public List<GymClass> GymClassSelect(GymClass gymClass) {
        List<GymClass> gymClasses = gymClassService.GymClassSelect(gymClass);
        return gymClasses;
    }

    //gym 只有一个
    //更新gym信息 虽大容量
    @RequestMapping("/GymUpdate")
    @ResponseBody
    public int GymUpdate(Gym gym) {
        int row = gymService.GymUpdate(gym);
        return row;
    }
//联表查询

    /**
     * 半联表多对多从映射表查到课程
     *
     * @param id
     * @return List<GymClass>  与该id相关的课程信息
     */
    @RequestMapping("/SelectGymClassByuid")
    @ResponseBody
    public List<GymClass> selectGymClassByuid(int id) {
        List<GymClass> agymClass = gymClassService.SelectGymClassById(id);
        return agymClass;
    }

    /**
     * 全联表多对多从用户查到课程
     *
     * @param user
     * @return List<User>  用户信息和用户所属课程信息
     */
    @RequestMapping("/SelectUserz")
    @ResponseBody
    public List<User> selectUserListz(User user) {
        List<User> users = userService.selectUserz(user);
        return users;
    }
}
