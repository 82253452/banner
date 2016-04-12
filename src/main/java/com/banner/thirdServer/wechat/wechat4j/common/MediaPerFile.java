package com.banner.thirdServer.wechat.wechat4j.common;

import com.banner.thirdServer.wechat.lang.HttpUtils;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.io.File;

/**
 * Created by admin on 2016/4/9.
 */
public class MediaPerFile extends CommonMedia{
    public String upload(File file,MediaType type){
        super.UPLOAD = "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=";//永久素材
        this.file = file;
        this.type = type;
        String url = uploadUrl();
        String result = HttpUtils.postFile(url, PARAM_FILE, file);
        parseUploadResult(result);
        if(StringUtils.isNotBlank(this.mediaId))
            return this.mediaId;
        return null;
    }
}
