package com.example.dictsystem.controller;

import com.example.dictsystem.entity.Admin;
import com.example.dictsystem.service.AdminService;
import com.example.dictsystem.service.ZiService;
import com.example.dictsystem.service.ZiXingService;
import com.example.dictsystem.vo.DataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    ZiService ziService;

    @Autowired
    ZiXingService ziXingService;

    @Autowired
    AdminService adminService;

    @GetMapping("/")
    public String getHome() {
        return "index";
    }

    @GetMapping("/searchPage")
    public String searchPage() {
        return "page/search-visitor";
    }

    @GetMapping("/detail")
    public String detail(Model model, int ID) {
        model.addAttribute("ID", ID);
        final int size = ziXingService.getPicsNum(ID);
        model.addAttribute("n", size);
        return "page/table/detail1";
    }

    @GetMapping("/userInfo")
    public String infoPage() {
        return "page/notice-visitor";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "page/login-3";
    }

    @PostMapping("/login")
    @ResponseBody
    public DataVO judgeLogin(String id, String password, HttpSession session) {
        final DataVO dataVO = adminService.search(id, password);
        if (dataVO.getCode() == 0) {
            Admin admin = (Admin) dataVO.getData().get(0);
            session.setAttribute("ADMIN", admin);
            session.setAttribute("TYPE", "admin" );
        }
        return dataVO;
    }
}
