package com.banner.thirdServer.wechat.wechat4j.token;

import com.alibaba.fastjson.JSONObject;
import com.banner.thirdServer.quartz.TaskUtils;
import com.banner.thirdServer.wechat.lang.HttpUtils;
import com.banner.util.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import javax.annotation.Resource;

/**
 * Created by admin on 2016/5/19.
 */
public class RedisToken {
    private static Logger logger = Logger.getLogger(RedisToken.class);
    private static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential";
    private String appId;
    private String secret;
    private Integer time = 60*60;
    @Resource
    private TaskUtils taskUtils;

    public RedisToken(String appId, String secret) {
        this.appId = appId;
        this.secret = secret;
    }

    private String getToken(String appId) {
        String tocken = RedisUtil.getString(appId);
        if (tocken == null || "".equals(tocken)) {
            return install();
        }
        return tocken;
    }

    public String install() {
        String url = accessTokenUrl();
        String result = HttpUtils.get(url);
        if (StringUtils.isNotBlank(result)) {
            JSONObject jsonObject = JSONObject.parseObject(result);
            String token = jsonObject.get("access_token") == null ? "" : jsonObject.get("access_token").toString();
            if (StringUtils.isBlank(token)) {
                logger.error("token获取失败,获取结果" + result);
                return "";
            }
            String expiresIn = jsonObject.get("expires_in") == null ? "" : jsonObject.get("expires_in").toString();
            if (StringUtils.isBlank(expiresIn)) {
                logger.error("token获取失败,获取结果" + expiresIn);
                return "";
            }
            RedisUtil.setString(appId, time, token);
            logger.info("token获取成功");
            return token;
        } else {
            logger.info("服务器响应异常");
        }
        return "";
    }

    private String accessTokenUrl() {
        String url = ACCESS_TOKEN_URL + "&appid=" + appId + "&secret=" + secret;
        return url;
    }
}
