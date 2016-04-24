package com.banner.listener;

import com.banner.mapper.LyWeInfoMapper;
import com.banner.model.LyWeInfo;
import com.banner.service.wechat.WechatTaskFactory;
import com.banner.thirdServer.quartz.ScheduleJob;
import com.banner.thirdServer.quartz.TaskUtils;
import com.banner.thirdServer.wechat.wechat4j.token.Tokens;
import com.banner.thirdServer.wechat.wechat4j.token.timer.TokenTaskFactory;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2016/4/13.
 */

@WebListener
public class WechatListener implements ServletContextListener {
    private static Logger logger = Logger.getLogger(WechatListener.class);

    @Resource
    private LyWeInfoMapper lyWeInfoMapper;
    @Resource
    private TaskUtils taskUtils;
    private static final String TOKEN_PREX="token_";
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.info("开始添加定时器");
        List<LyWeInfo> wechatList=lyWeInfoMapper.selectAll();
        Map<String,Object> dataMap=new HashMap<String,Object>();
        //添加发布微信任务
        for(LyWeInfo w:wechatList){
            ScheduleJob job = new ScheduleJob();
            job.setJobId(w.getId().toString());
            job.setJobName(w.getAppId());
            job.setJobGroup(w.getSecret());
            job.setJobStatus("1");
            job.setCronExpression(parseCronExperssion(w.getStartime()));
            job.setDesc(w.getUrl());
            taskUtils.addJob(job, WechatTaskFactory.class, dataMap);
            //tocken 定时器 2个小时执行一次
            String tocken= new Tokens(w.getAppId(),w.getSecret()).install();
            logger.info("jobId："+job.getJobId()+"jobCronExp："+job.getCronExpression()+"jobName："+job.getJobName()+"jobGroup："+job.getJobGroup());
            if(StringUtils.isNotBlank(tocken)){
                ScheduleJob jobToken = new ScheduleJob();
                jobToken.setJobId(TOKEN_PREX+w.getId().toString());
                jobToken.setJobName(TOKEN_PREX + w.getAppId());
                jobToken.setJobGroup(TOKEN_PREX + w.getSecret());
                jobToken.setJobStatus("1");
                jobToken.setCronExpression("0 0 0/2 * * ?");
                jobToken.setDesc("Token定时");
                taskUtils.addJob(jobToken, TokenTaskFactory.class, dataMap);
                logger.info("jobId:："+jobToken.getJobId()+"jobCronExp："+jobToken.getCronExpression()+"jobName："+jobToken.getJobName()+"jobGroup："+jobToken.getJobGroup());

            }
        }
        logger.info("定时器完成");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
    public String parseCronExperssion(String time){
        if (time == null || "".equals(time)) {
            return "";
        }
        String times[]=time.split(":");
        String cronExp="";
        for(int i=times.length-1;i>=0;i--){
            cronExp+=times[i]+" ";
        }
        return cronExp+="* * ?";
    }
}

