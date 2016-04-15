package com.banner.listener;

import com.banner.generator.util.TableBean;
import com.banner.service.CommonToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/4/15 0015.
 */
@Configuration
@WebListener
class Generator implements ServletContextListener {
    @Autowired
    private CommonToolService commonToolService;
    @Autowired
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${generator.method}")
    private String method;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        List<TableBean> tables= commonToolService.getAllTables(getDBName());
        if(method!=null&&!"".equals(method)){
            String projectPath=getClass().getResource("/").getFile().toString();

        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
    public  String getDBName(){
        String [] urlSP=url.split("/");
        return urlSP[urlSP.length-1];
    }
   /* public void installTemplate(String path){
        String xmlFilePath = StringUtils.replace(projectPath + "/src/main/resources/file/" + tb.getEntityName() + ".xml", "/", File.separator);
        CommonUtil.createTemplate(projectPath, "entityXML2.ftl", tb, xmlFilePath);
    }*/
}
