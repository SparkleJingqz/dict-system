package com.example.dictsystem.service.Impl;

import com.example.dictsystem.dao.ZiMapper;
import com.example.dictsystem.dao.ZiXingMapper;
import com.example.dictsystem.entity.Zi;
import com.example.dictsystem.entity.ZiPre;
import com.example.dictsystem.entity.ZiXing;
import com.example.dictsystem.service.ZiService;
import com.example.dictsystem.vo.DataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZiServiceImpl implements ZiService {
    @Autowired
    ZiMapper ziMapper;

    @Autowired
    ZiXingMapper ziXingMapper;

    @Override
    public boolean editZiYin(Integer ID, String username, String guyinmiaoxie, String ziyinchuchu, String hanyupinyin) {
        Zi zi = ziMapper.queryZiById(ID);
        StringBuilder sb = new StringBuilder();
        if (zi.getYinding() == null) {
            zi.setYinding("");
        }
        int len = zi.getYinding().length();
        if (len > 3 && zi.getYinding().charAt(len - 1) != '>') {
            sb.append("<br>");
        }
        sb.append("·用户" + username + "做出修正：" + hanyupinyin + ziyinchuchu + guyinmiaoxie + "<br>");
        zi.setYinding(zi.getYinding() + sb);
        zi.setYiding(null);
        zi.setWending(null);
        return ziMapper.appendXiuDing(zi) != 0;
    }

    @Override
    public boolean editZiXing(Integer ID, String username, String zixing, String zixingchuchu) {
        return false;
    }

    @Override
    public boolean editZiYi(Integer ID, String username, String yuanwenneirong, String xiudingneirong) {
        Zi zi = ziMapper.queryZiById(ID);
        StringBuilder sb = new StringBuilder();
        if (zi.getYiding() == null) {
            zi.setYiding("");
        }
        int len = zi.getYiding().length();
        if (len > 3 && zi.getYiding().charAt(len - 1) != '>') {
            sb.append("<br>");
        }
        sb.append("·用户" + username + "根据原文内容: “" + yuanwenneirong + "” 做出修订: " + xiudingneirong + "<br>");
        zi.setYiding(zi.getYiding() + sb);
        zi.setYinding(null);
        zi.setWending(null);
        return ziMapper.appendXiuDing(zi) != 0;
    }

    @Override
    public boolean editShuoWen(Integer ID, String username, String shuowen) {
        Zi zi = ziMapper.queryZiById(ID);
        StringBuilder sb = new StringBuilder();
        if (zi.getWending() == null) {
            zi.setWending("");
        }
        int len = zi.getWending().length();
        if (len > 3 && zi.getWending().charAt(len - 1) != '>') {
            sb.append("<br>");
        }
        sb.append("·用户" + username + "做出修正：" + shuowen + "<br>");
        zi.setYinding(null);
        zi.setYiding(null);
        zi.setWending(zi.getWending() + sb);
        return ziMapper.appendXiuDing(zi) != 0;
    }

    @Override
    public DataVO<ZiPre> getAllZi(int page, int size) {
        List<ZiPre> zis = ziMapper.queryAllZiPre(size * (page-1), size);
        int count = zis.size();
        DataVO<ZiPre> zisVO = new DataVO<>(0, "", count, zis);
        return zisVO;
    }

    @Override
    public DataVO<ZiPre> getZiByYin(String yin, int page, int size) {
        List<ZiPre> zis = ziMapper.queryZiPreByYin(yin, size * (page-1), size);
        int count = zis.size();
        DataVO<ZiPre> zisVO = new DataVO<>(0, "", count, zis);
        return zisVO;
    }

    @Override
    public Zi getZiById(int id) {
        return ziMapper.queryZiById(id);
    }

    @Override
    public boolean addZi(Zi zi) {
        if (ziMapper.queryZiPreByZi(zi.getZi()) != null) {
            return false;
        }
        return ziMapper.appendZi(zi) != 0;
    }
}
