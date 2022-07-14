package com.example.dictsystem.service;

import com.example.dictsystem.entity.Zi;
import com.example.dictsystem.entity.ZiPre;
import com.example.dictsystem.entity.ZiXing;
import com.example.dictsystem.vo.DataVO;

public interface ZiService {

    boolean editZiYin(Integer ID, String username, String guyinmiaoxie, String ziyinchuchu, String hanyupinyin);

    boolean editZiXing(Integer ID, String username, String zixing, String zixingchuchu);

    boolean editZiYi(Integer ID, String username, String yuanwenneirong, String xiudingneirong);

    boolean editShuoWen(Integer ID, String username, String shuowen);

    DataVO<ZiPre> getAllZi(int page, int size);

    DataVO<ZiPre> getZiByYin(String yin, int page, int limit);

    Zi getZiById(int id);

    boolean addZi(Zi zi);
}
