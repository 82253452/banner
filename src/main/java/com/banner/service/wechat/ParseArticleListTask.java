package com.banner.service.wechat;

import com.banner.thirdServer.wechat.utils.source;
import com.banner.thirdServer.wechat.wechat4j.common.*;
import com.banner.util.UUIDGenarator;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

/**
 * Created by admin on 2016/4/9.
 */
public class ParseArticleListTask extends RecursiveTask {
    private Integer num;
    private Elements elements;
    private Element element;
    private String appId;
    ParseArticleListTask(Elements elements,Integer num,String appId){
        this.elements=elements;
        this.num=num;
        this.appId=appId;
    }
    ParseArticleListTask(Element element,String appId){
        this.element=element;
        this.appId=appId;
    }
    @Override
    protected Object compute() {
        List<GraMaterialEntity> list=new ArrayList<>();
        if(elements==null){
            String linkHref = element.getElementsByTag("img").attr("src");
            String h2 = element.getElementsByTag("h2").get(0).getElementsByTag("a").html();
            String conLink = element.getElementsByTag("h2").get(0).getElementsByTag("a").get(0).attr("href");
            String author = element.getElementsByClass("muted").get(0).text();
            GraMaterialEntity graMaterialEntity = new GraMaterialEntity();
            File file =CommonMedia.getUrlFile(linkHref,Config.instance().getTempImg()+UUIDGenarator.generateNumber()+".jpg");
            MediaPerFile mediaFile=new MediaPerFile(appId);
            String mediaId=mediaFile.upload(file, MediaType.image);
            graMaterialEntity.setThumb_media_id(mediaId);
            graMaterialEntity.setAuthor(author);
            graMaterialEntity.setContent_source_url(Config.instance().getBaseWebUrl() + conLink);
            graMaterialEntity.setTitle(h2);
            list.add(graMaterialEntity);
        }else{
            for(Element e:elements){
                num--;
                ParseArticleListTask parseArticleListTask=new ParseArticleListTask(e,appId);
                parseArticleListTask.fork();
                List<GraMaterialEntity> re= (List<GraMaterialEntity>) parseArticleListTask.join();
                list.addAll(re);
                if(num==0){
                    break;
                }
            }
        }
        return list;
    }
}
