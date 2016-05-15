package com.banner.service.wechat;

import com.banner.model.LyWeInfo;
import com.banner.thirdServer.quartz.ScheduleJob;
import com.banner.thirdServer.quartz.TaskUtils;
import org.apache.log4j.Logger;
import org.quartz.SchedulerException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by admin on 2016/4/24.
 */
@Service
public class WechatJobService {
    public final Logger log = Logger.getLogger(TaskUtils.class);
    @Resource
    private TaskUtils taskUtils;

    public void addOrUpdateJob(LyWeInfo wechat){
        ScheduleJob job = new ScheduleJob();
        job.setJobId(wechat.getId().toString());
        job.setJobName(wechat.getAppId());
        job.setJobGroup(wechat.getSecret());
        job.setJobStatus("1");
        job.setCronExpression(parseCronExperssion(wechat.getStartime()));
        job.setDesc(wechat.getUrl());
        taskUtils.addJob(job, WechatTaskFactory.class);;
        log.info("job增加成功！id:"+job.getJobId()+"appId"+job.getJobName());
    }
    public void delete(LyWeInfo wechat){
        ScheduleJob job = new ScheduleJob();
        job.setJobId(wechat.getId().toString());
        job.setJobName(wechat.getAppId());
        job.setJobGroup(wechat.getSecret());
        try {
            taskUtils.deleteJob(job);
            log.info("job删除成功！jobName:"+job.getJobName()+"jobGroup:"+job.getJobGroup());
        } catch (SchedulerException e) {
            log.info("job删除异常！");
            e.printStackTrace();
        }
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
