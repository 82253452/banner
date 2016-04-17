package com.banner.generator.util;


import freemarker.template.Configuration;
import freemarker.template.Template;
import org.apache.commons.lang3.StringUtils;

import java.io.File;

public class CommonUtil {

	/**
	 * 转为骆驼命名 首字母小写
	 * @param columnName 字段名
	 * @return
	 */
	public static String getJavaName(String columnName){  	 
    	String [] columnSplit = columnName.split("_");
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
    	String [] columnSplit = columnName.split("_");
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
     * @param template
     * @throws Exception
     */
    public static void createTemplate(String projectPath,String method,String ftlName,TableBean tb,String template,String saveFilePath,String fileType)throws Exception{
    	// 获取文件分隔符
        String separator = File.separator;
    	// 模板文件路径
        String tplPath = StringUtils.replace(projectPath+packageToPath(template), "/", separator);
        // 保存文件路径
        String savePath = StringUtils.replace(projectPath+packageToPath(saveFilePath)+separator, "/", separator);
        //保存文件类型
        String fileName=getSaveName(tb.getEntityName(), fileType);
        // 代码模板配置
        Configuration cfg = new Configuration();
        cfg.setDefaultEncoding("UTF-8");
        cfg.setDirectoryForTemplateLoading(new File(tplPath));
    	// 生成 Entity
        Template templateEntity = cfg.getTemplate(ftlName);
        String content = FreeMarkers.renderTemplate(templateEntity, tb);
        FileUtils.writeFile(content, savePath+fileName,method);
    }
    private static String packageToPath(String packages){
        return StringUtils.replace(packages,".", File.separator);
    }
    private static String getSaveName(String name,String fileType){
        //获取包第一个包名 如果是resources类型为xml 其他为JAVA
            String fileName=StringUtils.replace(fileType,"*",name);
            return fileName;
    }
}
