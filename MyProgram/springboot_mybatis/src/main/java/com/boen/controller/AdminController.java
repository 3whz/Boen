package com.boen.controller;

import com.boen.domain.*;
import com.boen.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@CrossOrigin   //跨域
public class AdminController {
    @Autowired
    private AdminService adminService;
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
}
