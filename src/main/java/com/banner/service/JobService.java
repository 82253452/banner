package com.banner.service;

import com.banner.thirdServer.quartz.ScheduleJob;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/4/6 0006.
 */
@Service
public class JobService {
    /** 计划任务map */
    private static Map<String, ScheduleJob> jobMap = new HashMap<String, ScheduleJob>();
    static {
        for (int i = 0; i < 5; i++) {
            ScheduleJob job = new ScheduleJob();
            job.setJobId("10001" + i);
            job.setJobName("data_import" + i);
            job.setJobGroup("dataWork");
            job.setJobStatus("1");
            job.setCronExpression("0/5 * * * * ?");
            job.setDesc("数据导入任务");
            addJob(job);
        }
    }
    public List<ScheduleJob> getAllJob(){
        for (int i = 0; i < 5; i++) {
            ScheduleJob job = new ScheduleJob();
            job.setJobId("10001" + i);
            job.setJobName("data_import" + i);
            job.setJobGroup("dataWork");
            job.setJobStatus("1");
            job.setCronExpression("0/5 * * * * ?");
            job.setDesc("数据导入任务");
            addJob(job);
        }
        List<ScheduleJob> list= new ArrayList<>();
        for(Map.Entry entry:jobMap.entrySet()){
            list.add(jobMap.get(entry.getKey()));
        }
        return list;
    }
        /**
         * 添加任务
         * @param scheduleJob
         */
        public static void addJob(ScheduleJob scheduleJob) {
            jobMap.put(scheduleJob.getJobGroup() + "_" + scheduleJob.getJobName(), scheduleJob);
        }
}
