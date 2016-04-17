package com.banner.service.wechat;


import com.banner.thirdServer.wechat.wechat4j.common.*;
import com.banner.util.UUIDGenarator;
import net.sf.json.JSONObject;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.util.concurrent.RecursiveTask;

/**
 * Created by Administrator on 2016/4/8 0008.
 */
public class UploadMediaTask extends RecursiveTask<Elements> {
    private Elements lisImg;
    private Element img;
    private String appId;
    UploadMediaTask(Elements lisImg,String appId){
        this.appId=appId;
        this.lisImg=lisImg;
    }
    UploadMediaTask(Element img,String appId){
        this.img=img;
        this.appId=appId;
    }
    @Override
    protected Elements compute() {
        Elements result=new Elements();
        if(lisImg==null){
            File file =CommonMedia.getUrlFile(img.attr("src"),Config.instance().getTempImg()+UUIDGenarator.generateNumber()+".jpg");
            MediaContentFile mediaContentFile = new MediaContentFile(appId);
            String contentUrl = mediaContentFile.upload(file, MediaType.image);
            if (contentUrl == null) {
                img.attr("src", "");
                img.append("<span style='color:#CCCCCC;font-family:Microsoft YaHei;font-size:14px;'>(因微信限制，图片过大删除，请<span style='color:#337FE5;'><a href='" + Config.instance().getBaseWebUrl() + "'>点击阅读原文</a></span>查看完整版!)</span>");
            } else {
                img.attr("src", contentUrl.replaceAll("\\\\", ""));
            }
            result.add(img);
        }else{
            for(Element imgChild:lisImg){
                UploadMediaTask contentTask=  new UploadMediaTask(imgChild,appId);
                contentTask.fork();
                Elements partImg=contentTask.join();
                result.addAll(partImg);
            }
        }
        return result;
    }
}
