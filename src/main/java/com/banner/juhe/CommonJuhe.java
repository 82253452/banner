package com.banner.juhe;

import com.github.ansell.propertyutil.PropertyUtil;

/**
 * Created by Administrator on 2016/3/31 0031.
 */
public class CommonJuhe {
    public static PropertyUtil propertyUtil=new PropertyUtil("juhe");
    public static String APPKEY=null;
    public static String getAppKey(){
        if(APPKEY==null){
            APPKEY=propertyUtil.get("app.key","");
        }
        return APPKEY;
    }
}
