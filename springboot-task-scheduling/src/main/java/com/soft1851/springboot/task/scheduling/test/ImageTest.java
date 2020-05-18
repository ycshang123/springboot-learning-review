package com.soft1851.springboot.task.scheduling.test;

import cn.hutool.core.img.ImgUtil;
import cn.hutool.core.io.FileUtil;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageTest {
    public static void main(String[] args) throws IOException {
        //图片缩放
        ImgUtil.scale(
                FileUtil.file("D:/images/2.jpg"),
                FileUtil.file("D:/images/2_result.jpg"),
                0.3f
        );

        //添加文字水印
        ImgUtil.pressText(
                FileUtil.file("D:/images/2.jpg"),
                FileUtil.file("D:/images/2_font.jpg"),
                "添加文字", Color.BLACK,
                new Font("宋体",Font.BOLD,32),
                0,
                0,
                0.5f
        );

        //图片类型转换
        ImgUtil.convert(FileUtil.file("D:/images/2.jpg"),FileUtil.file("D:/images/2.png"));


        //彩色转为黑白
        ImgUtil.gray(FileUtil.file("D:/images/2.jpg"),FileUtil.file("D:/images/2_gray.jpg"));


        //剪裁图片
        ImgUtil.cut(
                FileUtil.file("D:/images/2.jpg"),
                FileUtil.file("D:/images/2_cut.jpg"),
                new Rectangle(200,200,100,100)
        );

        //旋转图片
        Image image = ImgUtil.rotate(ImageIO.read(FileUtil.file("D:/images/2.jpg")),45);
        ImgUtil.write(image,FileUtil.file("D:/images/2_rec.jpg"));



    }
}
