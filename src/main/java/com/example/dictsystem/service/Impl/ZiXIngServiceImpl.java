package com.example.dictsystem.service.Impl;

import com.example.dictsystem.dao.ZiXingMapper;
import com.example.dictsystem.entity.ZiXing;
import com.example.dictsystem.service.ZiXingService;
import com.example.dictsystem.vo.DataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZiXIngServiceImpl implements ZiXingService {
    @Autowired
    ZiXingMapper ziXingMapper;

    @Override
    public int getPicsNum(int id) {
        return ziXingMapper.queryZiXingNum(id);
    }

    @Override
    public DataVO insertXing(int ID, byte[] zixing, String miaoshu) {
        final int i = ziXingMapper.insertZiXing(ID, zixing, miaoshu);
        return new DataVO(i == 1 ? 0 : 1, "", 0, null); //包裹的code若为0则代表插入成功
    }

    @Override
    public DataVO<ZiXing> getZiXings(int id) {
        final List<ZiXing> ziXings = ziXingMapper.queryZiXingById(id);
        DataVO<ZiXing> dataVO = new DataVO<>(0, "", ziXings.size(), ziXings);
        return dataVO;
    }
}
