package com.banner.thirdServer.wechat.wechat4j.common;

import com.banner.thirdServer.wechat.lang.HttpUtils;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by admin on 2016/4/9.
 */
public class MediaPerFile extends CommonMedia{
    public MediaPerFile(String appId,String secret){
        super.appId=appId;
        super.secret=secret;
    }
    public String upload(File file,MediaType type){
        super.UPLOAD = "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=";//永久素材
        /*this.file = imgCompress(file);*/
        this.type = type;
        String url = uploadUrl();
        String result = HttpUtils.postFile(url, PARAM_FILE, file);
        parseUploadResult(result);
        if(StringUtils.isNotBlank(this.mediaId))
            return this.mediaId;
        return null;
    }
    private File imgCompress(File file) {
        long s=0;
        if (file.exists()) {
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(file);
                s= fis.available();
                logger.info("图片大小："+s);
                if(s>1000){
                    logger.info("压缩图片");
                   /* ImgCompress imgCompress=new ImgCompress(file);
                    file=imgCompress.resize(500,500);*/
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("文件不存在");
        }

        return file;
    }
}
