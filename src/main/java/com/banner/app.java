package com.banner;

import com.banner.thirdServer.quartz.SchedulerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by Administrator on 2016/2/24 0024.
 */
@EnableWebMvc
@SpringBootApplication
@Import({SchedulerConfig.class})
@ServletComponentScan
public class app {
    public static void main(String[] args) {
        SpringApplication.run(app.class, args);
    }
}
