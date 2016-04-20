package com.banner.thirdServer.wechat.wechat4j.token.timer;

import com.banner.service.wechat.NetSpider;
import com.banner.thirdServer.wechat.wechat4j.common.MediaTextPic;
import com.banner.thirdServer.wechat.wechat4j.message.MassMsg;
import com.banner.thirdServer.wechat.wechat4j.token.Tokens;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2016/4/17.
 */
public class TokenTaskFactory implements Job {
    public final Logger logger = Logger.getLogger(TokenTaskFactory.class);
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        Map<String,Object> dataMap = (Map<String, Object>) context.getMergedJobDataMap().get("dataMap");
        if(dataMap!=null&&!"".equals(dataMap.get("appId").toString())&&!"".equals(dataMap.get("secret").toString())){
            String appId=dataMap.get("appId").toString();
            String secret=dataMap.get("secret").toString();
                new Tokens(appId,secret).install();
                logger.info("更新token ："+appId);
        }
    }
}
