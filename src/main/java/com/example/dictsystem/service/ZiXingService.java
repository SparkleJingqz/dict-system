package com.example.dictsystem.service;

import com.example.dictsystem.entity.ZiXing;
import com.example.dictsystem.vo.DataVO;

public interface ZiXingService {
    int getPicsNum(int id);

    DataVO insertXing(int ID, byte[] zixing, String miaoshu);

    DataVO<ZiXing> getZiXings(int id);

}
