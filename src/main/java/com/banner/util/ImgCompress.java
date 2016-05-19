/*
package com.banner.util;


import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.sun.prism.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

*/
/**
 * Created by admin on 2016/4/17.
 *//*

public class ImgCompress {
    private BufferedImage img;
    private int width;
    private int height;
    private File file;
    */
/**
     * 构造函数
     *//*

    public ImgCompress(File file)  {
        this.file=file;
        try {
            img = ImageIO.read(file);      // 构造Image对象
        } catch (IOException e) {
            e.printStackTrace();
        }
        width = img.getWidth(null);    // 得到源图宽
        height = img.getHeight(null);  // 得到源图长
    }
    */
/**
     * 按照宽度还是高度进行压缩
     * @param w int 最大宽度
     * @param h int 最大高度
     *//*

    public void resizeFix(int w, int h) throws IOException {
        if (width / height > w / h) {
            resizeByWidth(w);
        } else {
            resizeByHeight(h);
        }
    }
    */
/**
     * 以宽度为基准，等比例放缩图片
     * @param w int 新宽度
     *//*

    public void resizeByWidth(int w) throws IOException {
        int h = (int) (height * w / width);
        resize(w, h);
    }
    */
/**
     * 以高度为基准，等比例缩放图片
     * @param h int 新高度
     *//*

    public void resizeByHeight(int h) throws IOException {
        int w = (int) (width * h / height);
        resize(w, h);
    }
    */
/**
     * 强制压缩/放大图片到固定的大小
     * @param w int 新宽度
     * @param h int 新高度
     *//*

    public File resize(int w, int h) throws IOException {
        // SCALE_SMOOTH 的缩略算法 生成缩略图片的平滑度的 优先级比速度高 生成的图片质量比较好 但速度慢
        BufferedImage image = new BufferedImage(w, h,BufferedImage.TYPE_INT_RGB );
        image.getGraphics().drawImage(img, 0, 0, w, h, null); // 绘制缩小后的图
        FileOutputStream out = new FileOutputStream(file); // 输出到文件流
        // 可以正常实现bmp、png、gif转jpg
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
        encoder.encode(image); // JPEG编码
        out.close();
        return file;
    }
}
*/
