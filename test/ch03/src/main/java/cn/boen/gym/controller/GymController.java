package cn.boen.gym.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import cn.boen.gym.pojo.Admin;
import cn.boen.gym.pojo.User;
import cn.boen.gym.service.AdminService;
import cn.boen.gym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GymController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private UserService userService;

    @GetMapping("/loginAdmin")
    public String tologin() {
        return "admin/login";
    }

    @PostMapping("/loginAdmin")
    public String login(HttpServletRequest request, HttpSession session, Admin admin) {
        Admin admin2 = adminService.loginAdmin(admin);
        if(admin2 != null) {
            session.setAttribute("admin_session", admin2);
            return "admin/index";
        }else {
            request.setAttribute("msg", "账号或密码错误!");
            return "admin/login";
        }
    }
    @GetMapping("/login")
    public String usertologin() {
        return "login";
    }
    @PostMapping("/login")
    public String login(HttpServletRequest request, HttpSession session, User user) {
        User user2 = userService.loginUser(user);
        if(user2 != null) {
            session.setAttribute("user_session", user2);
            return "index";
        }else {
            request.setAttribute("msg", "用户名或密码错误!");
            return "login";
        }
    }

}
