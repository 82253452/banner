package com.banner.thirdServer.wechat.wechat4j.common;

import com.banner.thirdServer.wechat.lang.HttpUtils;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.io.File;

/**
 * Created by admin on 2016/4/9.
 */
public class MediaContentFile extends CommonMedia{
    public String upload(File file,MediaType type){
        super.UPLOAD = "https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=";//素材不占用永久空间
        this.file = file;
        this.type = type;
        String url = uploadUrl();
        String result = HttpUtils.postFile(url, PARAM_FILE, file);
        JSONObject jsonObject=JSONObject.fromObject(result);
        if(StringUtils.isNotBlank(jsonObject.getString("url")))
            return jsonObject.getString("url");
        return null;

    }
}
