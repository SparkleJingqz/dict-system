package com.example.dictsystem.service.Impl;

import com.example.dictsystem.dao.XingMapper;
import com.example.dictsystem.entity.Xing;
import com.example.dictsystem.service.XingService;
import com.example.dictsystem.vo.DataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class XingServiceImpl implements XingService {
    @Autowired
    XingMapper xingMapper;

    @Override
    public int getPicsNum(int id) {
        return xingMapper.queryXingNum(id);
    }

    @Override
    public DataVO insertXing(int ID, String url, String miaoshu) {
        final int i = xingMapper.insertXing(new Xing(ID, miaoshu, url));
        return new DataVO(i != 0 ? 0 : 1, "", i, null);
    }

    @Override
    public DataVO<Xing> getZiXings(int id) {
        final List<Xing> xings = xingMapper.queryXingById(id);
        return new DataVO(0, "", xings.size(), xings);
    }
}
