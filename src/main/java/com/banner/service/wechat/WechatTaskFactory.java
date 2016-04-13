package com.banner.service.wechat;

import com.banner.thirdServer.quartz.ScheduleJob;
import com.banner.thirdServer.wechat.wechat4j.common.MediaTextPic;
import net.sf.json.JSONArray;
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
        if(dataMap!=null&&!"".equals(dataMap.get("url"))&&!"".equals(dataMap.get("num"))){
            try {
                List list=NetSpider.parseHTMLHrefs(dataMap.get("url").toString(),Integer.valueOf(dataMap.get("num").toString()));
                MediaTextPic mediaTextPic=new MediaTextPic();
                String mediaId=mediaTextPic.upload(JSONArray.fromObject(list).toString());
                if(mediaId!=null){
                    logger.info("上传图文素材成功 mediaId:"+mediaId);
                }else{
                    logger.info("上传图文素材成功失败");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            logger.info("url :"+dataMap.get("url").toString()+"article num :"+dataMap.get("url").toString());
        }
    }
}
