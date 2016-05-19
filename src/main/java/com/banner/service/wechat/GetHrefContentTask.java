package com.banner.service.wechat;


import com.banner.thirdServer.wechat.utils.source;
import com.banner.thirdServer.wechat.wechat4j.common.GraMaterialEntity;
import com.banner.util.HttpClientUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

/**
 * Created by Administrator on 2016/4/8 0008.
 */
public class GetHrefContentTask extends RecursiveTask {
    private List<GraMaterialEntity> list;
    private GraMaterialEntity sourceChild;
    private String appId;
    private String secret;
    GetHrefContentTask(List<GraMaterialEntity> list,String appId,String secret){
        this.list=list;
        this.appId=appId;
        this.secret=secret;
    }
    GetHrefContentTask(GraMaterialEntity sourceChild,String appId,String secret){
        this.sourceChild=sourceChild;
        this.appId=appId;
        this.secret=secret;
    }
    @Override
    protected List<GraMaterialEntity> compute() {
         List<GraMaterialEntity> result=new ArrayList<>();
        if(list==null){
            String content =HttpClientUtil.sendGetRequest(sourceChild.getContent_source_url(),"gbk");
            try {
                sourceChild.setContent(NetSpider.paseContentHTML(content,"",appId,secret));
            } catch (IOException e) {
                e.printStackTrace();
            }
            result.add(sourceChild);
        }else{
            for(GraMaterialEntity sourceChild:list){
                GetHrefContentTask contentTask=  new GetHrefContentTask(sourceChild, appId,secret);
                contentTask.fork();
                List<GraMaterialEntity> resultChild= (List<GraMaterialEntity>) contentTask.join();
                result.addAll(resultChild);
            }
        }
        return result;
    }
}
