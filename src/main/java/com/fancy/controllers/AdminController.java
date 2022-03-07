package com.fancy.controllers;

import com.fancy.pojo.Admin;
import com.fancy.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class AdminController {
    //在所有控制层中一定有业务层对象
    @Autowired
    AdminService adminService;

    @RequestMapping("/login.action")
    public String login(String name, String pwd, Model model) {
        Admin admin = adminService.login(name, pwd);
        if (admin != null) {
            model.addAttribute("name", name);
            return "main";
        } else {
            model.addAttribute("errmsg", "用户名或密码不正确");
            return "login";
        }
    }
}
