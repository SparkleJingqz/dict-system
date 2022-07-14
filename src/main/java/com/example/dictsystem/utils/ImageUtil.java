package com.example.dictsystem.utils;

import net.coobird.thumbnailator.Thumbnails;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class ImageUtil {
    //将file转换至文件夹file1中
    public static boolean getSmallImage(MultipartFile file, File targetFile) throws IOException {
        InputStream in = file.getInputStream();
        BufferedImage image = ImageIO.read(in);
        int width = image.getWidth();
        if (width > 600) {
            System.out.println(600.0 / width);
            Thumbnails.of(image).scale((600.0 / width)).toFile(targetFile);
            return true;
        } else {
            return false;
        }
    }
}
