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
    GetHrefContentTask(List<GraMaterialEntity> list){
        this.list=list;
    }
    GetHrefContentTask(GraMaterialEntity sourceChild){
        this.sourceChild=sourceChild;
    }
    @Override
    protected List<GraMaterialEntity> compute() {
         List<GraMaterialEntity> result=new ArrayList<>();
        if(list==null){
            String content =HttpClientUtil.sendGetRequest(sourceChild.getContent_source_url(),"gbk");
            try {
                sourceChild.setContent(NetSpider.paseContentHTML(content,""));
            } catch (IOException e) {
                e.printStackTrace();
            }
            result.add(sourceChild);
        }else{
            for(GraMaterialEntity sourceChild:list){
                GetHrefContentTask contentTask=  new GetHrefContentTask(sourceChild);
                contentTask.fork();
                List<GraMaterialEntity> resultChild= (List<GraMaterialEntity>) contentTask.join();
                result.addAll(resultChild);
            }
        }
        return result;
    }
}
