package com.example.dictsystem.dao;

import com.example.dictsystem.entity.Zi;
import com.example.dictsystem.entity.ZiPre;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 针对字的设置只需做新增字、对先有字新增修订与查阅字
 */
@Repository
public interface ZiMapper {
    //测试保存图片
    int insertPic(byte[] pic);

    int editPic(int ID, byte[] zixing);

    //通过id
    Zi queryZiById(int id);

    //通过字音
    List<Zi> queryZisByYin(String yin);

    ZiPre queryZiPreByZi(String zi);

    List<ZiPre> queryZiPreByYin(String yin, int start, int num);

    List<ZiPre> queryAllZiPre(int start, int num);

    //添加汉字
    int appendZi(Zi zi);

    //对字添加修订
    int appendXiuDing(Zi zi);



}
