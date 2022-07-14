package com.example.dictsystem.controller;

import com.example.dictsystem.dao.ZiMapper;
import com.example.dictsystem.entity.Admin;
import com.example.dictsystem.entity.Zi;
import com.example.dictsystem.service.AdminService;
import com.example.dictsystem.service.XingService;
import com.example.dictsystem.service.ZiService;
import com.example.dictsystem.vo.DataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

/**
 * 存储管理员有关操作，权限操作
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ZiService ziService;

    @Autowired
    private XingService xingService;

    @GetMapping("/getAdd")
    public String getAdd() {
        return "page/table/add";
    }

    @GetMapping("/getEdit")
    public String getEdit() {
        return "page/search-admin";
    }

    @GetMapping("/getNotice")
    public String getNotice() {
        return "page/notice-admin";
    }

    @GetMapping("/editZiYinPage")
    public String getEditZiYin(Model model, Integer ID, HttpSession session) {
        Admin admin = (Admin) session.getAttribute("ADMIN");
        model.addAttribute("ID", ID);
        model.addAttribute("user", admin.getName());
        return "page/table/edit-ziyin";
    }

    @GetMapping("/editZiYiPage")
    public String getEditZiYi(Model model, Integer ID, HttpSession session) {
        Admin admin = (Admin) session.getAttribute("ADMIN");
        model.addAttribute("ID", ID);
        model.addAttribute("user", admin.getName());
        return "page/table/edit-ziyi";
    }

    @GetMapping("/editZiXingPage")
    public String getEditZiXing(Model model, Integer ID, HttpSession session) {
        Admin admin = (Admin) session.getAttribute("ADMIN");
        model.addAttribute("ID", ID);
        model.addAttribute("user", admin.getName());
        return "page/table/edit-zixing";
    }

    @GetMapping("/editShuowenPage")
    public String getEditShuowen(Model model, Integer ID, HttpSession session) {
        Admin admin = (Admin) session.getAttribute("ADMIN");
        model.addAttribute("ID", ID);
        model.addAttribute("user", admin.getName());
        return "page/table/edit-shuowen";
    }

    @GetMapping("/addZi")
    public String addZi() {
        return "page/table/add";
    }

    @PostMapping("/editZiYin")
    @ResponseBody
    public boolean editZiYin(Integer ID, String username, String guyinmiaoxie, String ziyinchuchu, String hanyupinyin) {
        return ziService.editZiYin(ID, username, guyinmiaoxie, ziyinchuchu, hanyupinyin);
    }

    @PostMapping("/editZiYi")
    @ResponseBody
    public boolean editZiYi(Integer ID, String username, String yuanwenneirong ,String xiudingneirong) {
        return ziService.editZiYi(ID, username, yuanwenneirong, xiudingneirong);
    }

    //ZiXing仍待完善
    @PostMapping("/editZiXing")
    @ResponseBody
    public boolean editZiXing(Integer ID, String username, String zixingchuchu, String dir) {
        if (dir.charAt(dir.length()-1) == ',') {  //?为什么末尾会有,？
            dir = dir.substring(0, dir.length() - 1);
        }
        final DataVO dataVO = xingService.insertXing(ID, dir, zixingchuchu);
        return dataVO.getCode() == 0;
    }

    @PostMapping("/editShuoWen")
    @ResponseBody
    public boolean editShuoWen(Integer ID, String username, String shuowen) {
        return ziService.editShuoWen(ID, username, shuowen);
    }

    @PostMapping("/addZi")
    @ResponseBody
    public boolean addZi(String username, String zi, String weizhi, String shuowen, byte[] zixing, String ziyi, String ziyin) {
        Zi zi1 = Zi.builder()
                .zi(zi)
                .weizhi(weizhi)
                .yi(ziyi)
                .yin(ziyin).build();
        if (shuowen != null && shuowen.trim() != "") {
            zi1.setShuowen(shuowen);
        }
        return ziService.addZi(zi1);
    }
}
