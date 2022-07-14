package com.example.dictsystem.dao;

import com.example.dictsystem.entity.ZiXing;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZiXingMapper {
    List<ZiXing> queryZiXingById(int ID);

    int insertZiXing(int ID, byte[] zixing, String miaoshu);

    int queryZiXingNum(int ID);
}
