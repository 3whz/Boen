package com.boen;

import com.boen.domain.*;
import com.boen.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootMybatisApplication.class)
public class MybatisTest {
    @Autowired
    private AdminService adminService;
    @Autowired
    private UserService userService;
    @Autowired
    private GymClassService gymClassService;
    @Autowired
    private GymService gymService;
    @Autowired
    private ClassClassifyService classClassifyService;
    //添加管理员
    @Test
    public void AdminInsert() {
        Admin admin = new Admin();
        admin.setAccount("aaaa");
        int id = adminService.AdminInsert(admin);
        System.out.println(id);
    }

    //删除管理员
    @Test
    public void AdminDelete() {
        Admin admin = new Admin();
        Admin adminx = new Admin();
        admin.setId(9);
        adminx.setId(10);
        List<Admin> adminList = new ArrayList<Admin>();
        adminList.add(admin);
        adminList.add(adminx);
        int row = adminService.AdminDelete(adminList);
        System.out.println(row);
    }
    //修改管理员
    @Test
    public void AdminUpdate() {
        Admin admin = new Admin();
        admin.setId(11);
        admin.setEmail("aaaaaa");
        admin.setAccount("bbbb");
        int row = adminService.AdminUpdate(admin);
        System.out.println(row);
    }
    //查询管理员
    @Test
    public void AdminSelect() {
        Admin admin = new Admin();
        admin.setId(11);
        List<Admin> adminList = adminService.AdminSelect(admin);
        System.out.println(adminList);
    }

//用户部分
    //添加用户
    @Test
    public void UserInsert() {
        User user = new User();
        user.setUsername("aaaa");
        int id = userService.UserInsert(user);
        System.out.println(id);
    }

    //删除用户
    @Test
    public void UserDelete() {
        User user = new User();
        User userx = new User();
        user.setId(9);
        userx.setId(8);
        List<User> userList = new ArrayList<User>();
        userList.add(user);
        userList.add(userx);
        int row = userService.UserDelete(userList);
        System.out.println(row);
    }
    //修改用户
    @Test
    public void UserUpdate() {
        User user = new User();
        user.setId(7);
        user.setUsername("aaaa");
        user.setEmail("aaaaaa");
        int row = userService.UserUpdate(user);
        System.out.println(row);
    }
    //查询用户
    @Test
    public void UserSelect() {
        User user = new User();
        user.setId(7);
        List<User> userList = userService.UserSelect(user);
        System.out.println(userList);
    }
    //用户_课程
    @Test
    public void SelectUserJointGymClass() {
        User user = new User();
        List<User> userList= userService.UserJointGymClassSelect(user);
        System.out.println(userList);
    }
//课程部分
//添加课程
@Test
public void GymClassInsert() {
    GymClass gymClass = new GymClass();
    gymClass.setName("aaba");
    int id = gymClassService.GymClassInsert(gymClass);
    System.out.println(id);
}

    //删除课程
    @Test
    public void GymClassDelete() {
        GymClass gymClass = new GymClass();
        GymClass gymClassx = new GymClass();
        gymClass.setId(22);
        gymClassx.setId(23);
        List<GymClass> gymClassList = new ArrayList<GymClass>();
        gymClassList.add(gymClass);
        gymClassList.add(gymClassx);
        int row = gymClassService.GymClassDelete(gymClassList);
        System.out.println(row);
    }
    //修改课程
    @Test
    public void GymClassUpdate() {
        GymClass gymClass = new GymClass();
        gymClass.setId(22);
        gymClass.setName("abbbaa");
        int row = gymClassService.GymClassUpdate(gymClass);
        System.out.println(row);
    }
    //查询课程
    @Test
    public void GymClassSelect() {
        GymClass gymClass = new GymClass();
//        gymClass.setId(7);
        List<GymClass> gymClassList = gymClassService.GymClassSelect(gymClass);
        System.out.println(gymClassList);
    }
    //查询课程u_id
    @Test
    public void GymClassByUIdSelect() {
        List<GymClass> gymClassList = gymClassService.GymClassByUIdSelect(1);
        System.out.println(gymClassList);
    }
    //添加分类
    @Test
    public void ClassClassifyInsert() {
        ClassClassify classClassify = new ClassClassify();
        classClassify.setName("aaba");
        int id = classClassifyService.ClassClassifyInsert(classClassify);
        System.out.println(id);
    }

    //删除分类
    @Test
    public void ClassClassifyDelete() {
        ClassClassify classClassify = new ClassClassify();
        ClassClassify classClassifyx = new ClassClassify();
        classClassify.setId(4);
        classClassifyx.setId(5);
        List<ClassClassify> classClassifyList = new ArrayList<ClassClassify>();
        classClassifyList.add(classClassify);
        classClassifyList.add(classClassifyx);
        int row = classClassifyService.ClassClassifyDelete(classClassifyList);
        System.out.println(row);
    }
    //修改分类
    @Test
    public void ClassClassifyUpdate() {
        ClassClassify classClassify = new ClassClassify();
        classClassify.setId(6);
        classClassify.setName("锻炼");
        int row = classClassifyService.ClassClassifyUpdate(classClassify);
        System.out.println(row);
    }
    //查询分类
    @Test
    public void ClassClassifySelect() {
        ClassClassify classClassify = new ClassClassify();
        classClassify.setId(6);
        List<ClassClassify> classClassifyList = classClassifyService.ClassClassifySelect(classClassify);
        System.out.println(classClassifyList);
    }
    //分类——课程
    @Test
    public void SelectClassClassifyJointGymClass() {
        ClassClassify classClassify = new ClassClassify();
        List<ClassClassify>  classClassifyList= classClassifyService.ClassClassifyJointGymClassSelect(classClassify);
        System.out.println(classClassifyList);
    }
    @Test
    public void UserJointGymClassSelect() {
        User user = new User();
        user.setId(1);
        List<User>  userList= userService.UserJointGymClassSelect(user);
        System.out.println(userList);
    }
    @Test
    public void GymClassByCUIdSelect() {
        User user = new User();
        List<User>  userList= userService.CUserJointGymClassSelect(user);
        System.out.println(userList);
    }
}
