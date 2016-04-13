package com.banner.listener;

import com.banner.mapper.WechatMapper;
import com.banner.service.wechat.WechatTaskFactory;
import com.banner.thirdServer.quartz.ScheduleJob;
import com.banner.thirdServer.quartz.TaskUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

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
    private WechatMapper wechatMapper;
    @Resource
    private TaskUtils taskUtils;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.info("开始添加定时器");
        List wechatList=wechatMapper.selectAll();
        JSONArray jsonArray=JSONArray.fromObject(wechatList);
        Map<String,Object> dataMap=new HashMap<String,Object>();
        for(Object o:jsonArray){
            JSONObject w=JSONObject.fromObject(o);
            ScheduleJob job = new ScheduleJob();
            job.setJobId(w.getString("id"));
            job.setJobName(w.getString("appId"));
            job.setJobGroup(w.getString("secret"));
            job.setJobStatus("1");
            job.setCronExpression(parseCronExperssion(w.getString("startime")));
            job.setDesc("系统导入定时");
            dataMap.put("url",w.getString("url"));
            taskUtils.addJob(job, WechatTaskFactory.class,dataMap);
            logger.info("jobId:"+job.getJobId()+"jobCronExp"+job.getCronExpression()+"jobName"+job.getJobName()+"jobGroup"+job.getJobGroup());
        }
        logger.info("定时器完成");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
    private String parseCronExperssion(String time){
        if(time!=null&&!"".equals(time)){
            String times[]=time.split(":");
            String cronExp="";
            for(int i=times.length-1;i>=0;i--){
                cronExp+=times[i]+" ";
            }
            return cronExp+="* * ?";
        }
        return "";
    }
}
