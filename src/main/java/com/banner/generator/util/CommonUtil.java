package com.banner.generator.util;


import org.apache.commons.lang3.StringUtils;

import java.io.File;

public class CommonUtil {

	/**
	 * 转为骆驼命名 首字母小写
	 * @param columnName 字段名
	 * @return
	 */
	public static String getJavaName(String columnName){  	 
    	String [] columnSplit = columnName.toLowerCase().split("_");
    	if(columnSplit.length==1){
    		return columnSplit[0];
    	}else{
    		StringBuffer nameStr = new StringBuffer(columnSplit[0]);
    		for(int i=1; i<columnSplit.length ;i++ ){
	    		nameStr.append(toUpperCaseFirstOne(columnSplit[i]));
	    	}
    		return nameStr.toString();
    	}
    	
    }
    
    /**
     * 转为骆驼命名 首字母大写  用于set/get方法拼接
     * @param columnName
     * @return
     */
    public static String getJavaName2(String columnName){  	 
    	String [] columnSplit = columnName.toLowerCase().split("_");
		StringBuffer nameStr = new StringBuffer("");
		for(int i=0; i<columnSplit.length ;i++ ){
    		nameStr.append(toUpperCaseFirstOne(columnSplit[i]));
    	}
		return nameStr.toString();
    }
    
    public static String toLowerCaseFirstOne(String s)
    {
       return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
    }
    //首字母转大写
    public static String toUpperCaseFirstOne(String s)
    {
       return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
    }
    
    /**
     * 自动生成代码
     * @param projectPath
     * @param ftlName
     * @param tb
     * @param saveFilePath
     * @throws Exception
     */
    /*public static void createTemplate(String projectPath,String ftlName,TableBean tb,String saveFilePath)throws Exception{
    	// 获取文件分隔符
        String separator = File.separator;
        System.out.println("Project Path: "+ projectPath);
    	// 模板文件路径
        String tplPath = StringUtils.replace(projectPath + "/src/main/java/com/dmw/boss/generate/template", "/", separator);
        System.out.println("Template Path: "+tplPath);
    	 // 代码模板配置
        Configuration cfg = new Configuration();
        cfg.setDefaultEncoding("UTF-8");
        cfg.setDirectoryForTemplateLoading(new File(tplPath));
    	// 生成 Entity
        Template template = cfg.getTemplate(ftlName);
        String content = FreeMarkers.renderTemplate(template, tb);
        System.out.println("file Path: "+ saveFilePath);
        FileUtils.writeFile(content, saveFilePath);
    }*/
}
