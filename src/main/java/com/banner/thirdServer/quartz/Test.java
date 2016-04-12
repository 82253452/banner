package com.banner.thirdServer.quartz;

import com.banner.service.JobService;
import com.banner.thirdServer.wechat.wechat4j.WechatSupport;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2016/4/6 0006.
 */
@Controller
public class Test {
    @Autowired
    private TaskUtils taskUtils;

    @RequestMapping("/addJob")
    @ResponseBody
    public  void addJob(ScheduleJob job,Class cls) {
        job = new ScheduleJob();
        job.setJobId("10001");
        job.setJobName("data_import");
        job.setJobGroup("dataWork");
        job.setJobStatus("1");
        job.setCronExpression("00 43 13 * * ?");
        job.setDesc("数据导入任务");
        cls=QuartzJobFactory.class;
        taskUtils.addJob(job,cls);
       /* try {
            taskUtils.runAJobNow(job);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }*/
    }

}
