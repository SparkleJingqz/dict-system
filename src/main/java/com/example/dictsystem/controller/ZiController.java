package com.example.dictsystem.controller;

import com.example.dictsystem.dao.ZiMapper;
import com.example.dictsystem.entity.Xing;
import com.example.dictsystem.entity.Zi;
import com.example.dictsystem.entity.ZiPre;
import com.example.dictsystem.entity.ZiXing;
import com.example.dictsystem.service.XingService;
import com.example.dictsystem.service.ZiService;
import com.example.dictsystem.service.ZiXingService;
import com.example.dictsystem.utils.ImageUtil;
import com.example.dictsystem.vo.DataVO;
import com.example.dictsystem.vo.DetailVO;
import com.example.dictsystem.vo.MsgVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.Format;
import java.time.LocalDate;
import java.util.*;

@Controller
public class ZiController {
    @Autowired
    private ZiService ziService;

    @Autowired
    private ZiXingService ziXingService;

    @Autowired
    private XingService xingService;

    @ResponseBody
    @RequestMapping("testPhoto")
    public MsgVO testUpDate(MultipartFile file, int ID) throws FileNotFoundException {
        String ori = file.getOriginalFilename();
        String fileName = UUID.randomUUID() +  ori.substring(ori.indexOf("."));
        File path = new File("\\usr\\local\\runtest\\");
        if(!path.exists()) {
            path = new File("");
        }
        File upload_file_dir_file = new File(path.getAbsolutePath(),"static/images/" + ID + "/");
        if(!upload_file_dir_file.exists()) {
            upload_file_dir_file.mkdirs();
        }

        File targetFile = new File(upload_file_dir_file, fileName);
        try {
            if (ImageUtil.getSmallImage(file, targetFile)) {
                return new MsgVO(0, "", 0, fileName);
            }
            file.transferTo(targetFile);
        } catch (IOException e) {
            e.printStackTrace();
            return new MsgVO(1, "", 0, null);
        }
        return new MsgVO(0, "", 0, fileName);
    }

    @ResponseBody
    @RequestMapping("/updateXingPhoto")
    public DataVO testXing(MultipartFile file, int ID, String xing){
        int i = 1;
        try {
            return ziXingService.insertXing(ID, file.getBytes(), xing);
        } catch (IOException e) {
            e.printStackTrace();
            return new DataVO(1, "", 0, null);
        }
    }

    @ResponseBody
    @RequestMapping("/getAllZi")
    public DataVO getAllZis(int page, int limit) {
        return ziService.getAllZi(page, limit);
    }

    @ResponseBody
    @RequestMapping("/getZiById")
    public Zi getZiById(int ID) {
        Zi zi = ziService.getZiById(ID);
        return zi;
    }

    @RequestMapping("/getPicsUrl")
    @ResponseBody
    public DetailVO getPics(int ID) {
        final DataVO<Xing> ziXings = xingService.getZiXings(ID);
        final Zi ziById = ziService.getZiById(ID);
        DetailVO detailVO = DetailVO.builder().zi(ziById)
                .count(ziXings.getCount())
                .xings(ziXings.getData()).build();
        return detailVO;
    }

    @RequestMapping("/getPicsById")
    public void getPicsById(int n, int ID, HttpServletResponse response) {
        final DataVO<ZiXing> ziXingDataVO = ziXingService.getZiXings(ID);
        if (ziXingDataVO.getData() == null || ziXingDataVO.getData().size() == 0) {
            return;
        }
        final List<ZiXing> data = ziXingDataVO.getData();
        if (n >= data.size()) {
            return;
        }
        byte[] zixing;
        try {
            ServletOutputStream sos = response.getOutputStream();
            zixing = data.get(n).getZixing();
            sos.write(zixing);
            sos.flush();
            sos.close();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        //禁止图片缓存
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/*");
    }

    @ResponseBody
    @RequestMapping("/getZiByYin")
    public DataVO<ZiPre> getZiByYin(String ziyin, int page, int limit) {

        return ziService.getZiByYin(ziyin, page, limit);
    }
}
