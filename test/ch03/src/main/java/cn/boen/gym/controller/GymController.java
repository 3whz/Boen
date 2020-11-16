package cn.boen.gym.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import cn.boen.gym.pojo.Admin;
import cn.boen.gym.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GymController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/login")
    public String tologin() {
        return "login";
    }

    @PostMapping("/login")
    public String login(HttpServletRequest request, HttpSession session, Admin admin) {
        Admin admin2 = adminService.loginAdmin(admin);
        if(admin2 != null) {
            session.setAttribute("user_session", admin2.getAccount());
            return "index";
        }else {
            request.setAttribute("msg", "账号或密码错误");
            return "login";
        }
    }





}
