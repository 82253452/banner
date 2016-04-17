package com.banner.service.generator;

import com.banner.generator.util.CommonUtil;
import com.banner.generator.util.TableBean;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * Created by admin on 2016/4/16.
 */

public class CreateTemplateTask extends RecursiveAction {
    private List<TableBean> tables;
    private TableBean table;
    private String  projectPath=System.getProperty("user.dir")+"/src/main/";
    private Properties generator;

    public CreateTemplateTask(List<TableBean> tables, Properties generator){
        this.tables=tables;
        this.generator=generator;
    }
    public CreateTemplateTask(TableBean table,Properties generator){
        this.table=table;
        this.generator=generator;
    }

    @Override
    protected void compute() {
        if (tables==null){
            try {
                for(String name:generator.stringPropertyNames()){
                    String templateName=getTemplate(name);
                    if(!"".equals(templateName)){
                        String fileType=generator.getProperty(name);
                        String target=getTarget(name);
                        String method=generator.getProperty("method");
                        String template=generator.getProperty("template");
                        CommonUtil.createTemplate(projectPath,method, templateName, table, template, target,fileType);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            for(TableBean table:tables){
                CreateTemplateTask contentTask=  new CreateTemplateTask(table,generator);
                contentTask.fork();
            }
        }
    }
    public  String getTemplate(String name){
        String nameArray[]= StringUtils.split(name,".");
        if (nameArray!=null&&nameArray.length>0&&nameArray[0].equals("template")){
            if(nameArray[nameArray.length-1].equals("ftl")){
                return nameArray[nameArray.length-2]+".ftl";
            }
        }
        return "";
    }
    public  String getTarget(String name){
        String nameArray[]= StringUtils.split(name,".");
        if (nameArray!=null&&nameArray.length>0&&nameArray[0].equals("template")){
            if(nameArray[nameArray.length-1].equals("ftl")){
                return generator.getProperty("target."+nameArray[nameArray.length-2]);
            }
        }
        return "";
    }
}
