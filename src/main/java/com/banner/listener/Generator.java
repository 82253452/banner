package com.banner.listener;

import com.banner.generator.util.ColumnBean;
import com.banner.generator.util.TableBean;
import com.banner.service.CommonToolService;
import com.sun.corba.se.impl.encoding.OSFCodeSetRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
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

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        List<TableBean> tables= commonToolService.getAllTables(getDBName());

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
    public  String getDBName(){
        String [] urlSP=url.split("/");
        return urlSP[urlSP.length-1];
    }
}
