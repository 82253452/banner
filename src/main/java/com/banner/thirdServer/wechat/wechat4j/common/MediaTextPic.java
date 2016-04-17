package com.banner.thirdServer.wechat.wechat4j.common;

import com.banner.thirdServer.wechat.lang.HttpUtils;
import com.banner.thirdServer.wechat.wechat4j.token.TokenProxy;
import org.apache.commons.lang3.StringUtils;

import java.io.File;

/**
 * Created by admin on 2016/4/9.
 */
public class MediaTextPic extends CommonMedia{
    public MediaTextPic(String appId){
        super.appId=appId;
    }
    public String upload(File file,MediaType type){

        return null;
    }
    public String upload(String data){
        super.UPLOAD="https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=";
        String result=HttpUtils.post(UPLOAD+ getToken(),data);
        parseUploadResult(result);
        if(StringUtils.isNotBlank(this.mediaId))
            return this.mediaId;
        return null;
    }
}
