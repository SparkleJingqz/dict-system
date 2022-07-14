package com.example.dictsystem.dao;

import com.example.dictsystem.entity.Xing;
import com.example.dictsystem.entity.ZiXing;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface XingMapper {
    List<Xing> queryXingById(int ID);

    int insertXing(Xing xing);

    int queryXingNum(int ID);
}
