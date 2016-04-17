package com.banner.service.wechat;

import com.banner.thirdServer.quartz.ScheduleJob;
import com.banner.thirdServer.wechat.wechat4j.common.MediaTextPic;
import com.banner.thirdServer.wechat.wechat4j.message.MassMsg;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2016/4/13.
 */
@DisallowConcurrentExecution
public class WechatTaskFactory implements Job {
    public final Logger logger = Logger.getLogger(WechatTaskFactory.class);
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        Map<String,Object> dataMap = (Map<String, Object>) context.getMergedJobDataMap().get("dataMap");
        if(dataMap!=null&&!"".equals(dataMap.get("url").toString())&&!"".equals(dataMap.get("num").toString())){
            String appId=dataMap.get("appId").toString();
            try {
                List list=NetSpider.parseHTMLHrefs(dataMap.get("url").toString(),Integer.valueOf(dataMap.get("num").toString()),appId);
                MediaTextPic mediaTextPic=new MediaTextPic(appId);
                JSONObject jsonObject=new JSONObject();
                jsonObject.put("articles",JSONArray.fromObject(list).toString());
                String mediaId=mediaTextPic.upload(jsonObject.toString());
                if(mediaId!=null){
                    logger.info("上传图文素材成功 mediaId:"+mediaId);
                    /*MassMsg massMsg=new MassMsg(mediaId,appId);
                    String result=massMsg.send();
                    logger.info("群发："+result);*/
                }else{
                    logger.info("上传图文素材失败");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            logger.info("url :"+dataMap.get("url").toString()+"article num :"+dataMap.get("num").toString());
        }
    }
}
