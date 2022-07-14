package com.example.dictsystem.dao;

import com.example.dictsystem.entity.Admin;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminMapper {
    int insertAdmin(Admin admin);
    Admin search(String id, String password);
}
