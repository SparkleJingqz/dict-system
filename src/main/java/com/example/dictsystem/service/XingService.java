package com.example.dictsystem.service;

import com.example.dictsystem.entity.Xing;
import com.example.dictsystem.entity.ZiXing;
import com.example.dictsystem.vo.DataVO;

public interface XingService {
    int getPicsNum(int id);

    DataVO insertXing(int ID, String url, String miaoshu);

    DataVO<Xing> getZiXings(int id);
}
