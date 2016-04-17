package com.banner.listener;

import com.banner.generator.util.CommonUtil;
import com.banner.generator.util.TableBean;
import com.banner.service.CommonToolService;
import com.banner.service.generator.CreateTemplateTask;
import com.banner.thirdServer.wechat.wechat4j.common.GraMaterialEntity;
import com.github.ansell.propertyutil.PropertyUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ForkJoinPool;

/**
 * Created by Administrator on 2016/4/15 0015.
 */
@WebListener
@ConfigurationProperties(locations = "classpath:generator.properties")
class Generator implements ServletContextListener {
    private static Logger logger = Logger.getLogger(WechatListener.class);
    @Autowired
    private CommonToolService commonToolService;
    @Value("${spring.datasource.url}")
    private String url;
    Properties generator;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        String method=generator.getProperty("method");
        if(method.equals("product")){
            logger.info("PRODUCT ENV");
        }else{
            List<TableBean> tables= commonToolService.getAllTables(getDBName());
            ForkJoinPool forkJoinPool=new ForkJoinPool();
            CreateTemplateTask createTemplateTask=new CreateTemplateTask(tables,generator);
            forkJoinPool.execute(createTemplateTask);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
    public  String getDBName(){
        String [] urlSP=url.split("/");
        return urlSP[urlSP.length-1];
    }

    public Properties getGenerator() {
        return generator;
    }

    public void setGenerator(Properties generator) {
        this.generator = generator;
    }
}
