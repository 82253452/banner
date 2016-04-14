package com.banner.thirdServer.wechat.wechat4j.message;

import com.alibaba.fastjson.JSON;
import com.banner.thirdServer.wechat.lang.HttpUtils;
import com.banner.thirdServer.wechat.wechat4j.token.TokenProxy;
import net.sf.json.JSONObject;

/**
 * Created by admin on 2016/4/9.
 */
public class MassMsg {
    private static final String URL="https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token=";
    private String media_id;
    public MassMsg(String media_id){
        this.media_id=media_id;
    }
    public String send(){
        String result=HttpUtils.post(uploadUrl(),getParamData(media_id));
        return respon(result);
    }
    private String getParamData(String media_id){
        JSONObject jsonObject=new JSONObject();
        JSONObject filter=new JSONObject();
        JSONObject media=new JSONObject();

        filter.put("is_to_all",true);
        media.put("media_id",media_id);
        jsonObject.put("filter",filter);
        jsonObject.put("mpnews",media);
        jsonObject.put("msgtype","mpnews");
        return jsonObject.toString();
    }

    /**
     * 素材上传url
     * @return
     */
    private String uploadUrl(){
        String url = URL + TokenProxy.accessToken();
        return url;
    }
    private String respon(String result){
        JSONObject jsonObject=JSONObject.fromObject(result);
        if(jsonObject.getString("errcode").equals("0")){
            return "图文发送发送成功!";
        }else{
            return "图文发送失败！原因："+jsonObject.getString("errmsg");
        }
    }
}
