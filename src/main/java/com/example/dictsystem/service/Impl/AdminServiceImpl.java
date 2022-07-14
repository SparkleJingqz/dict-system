package com.example.dictsystem.service.Impl;

import com.example.dictsystem.dao.AdminMapper;
import com.example.dictsystem.entity.Admin;
import com.example.dictsystem.entity.Zi;
import com.example.dictsystem.service.AdminService;
import com.example.dictsystem.vo.DataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;

    @Override
    public boolean insertAdmin(Admin admin) {
        return adminMapper.insertAdmin(admin) != 0;
    }

    @Override
    public DataVO search(String id, String password) {
        DataVO DataVO = new DataVO();
        HttpSession session;

        Admin admin = adminMapper.search(id, password);
        if (admin != null) {
            DataVO.setMsg("登录成功");
            DataVO.setCode(0);
            List<Admin> list = new ArrayList<>();
            list.add(admin);
            DataVO.setData(list);
            return DataVO;
        }
        DataVO.setMsg("登录失败，请检查用户名和密码");
        DataVO.setCode(1);
        return DataVO;
    }
}
