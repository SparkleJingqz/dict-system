package com.example.dictsystem.service;

import com.example.dictsystem.entity.Admin;
import com.example.dictsystem.vo.DataVO;

public interface AdminService {
    boolean insertAdmin(Admin admin);
    DataVO search(String id, String password);
}
