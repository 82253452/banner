/**
 *
 */
package com.banner.thirdServer.wechat.wechat4j.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.github.ansell.propertyutil.PropertyUtil;
import org.apache.log4j.Logger;

/**
 * @author ChengNing
 * @date   2014年12月8日
 */
public class Config {

	private static Logger logger = Logger.getLogger(Config.class);

	private static final String configFile = "wechat4j";

	private String url;
	private String token;
	private String encodingAESKey;
	private String appid;
	private String appSecret;
	private String accessTokenServer;
	private String jsApiTicketServer;
	private String baseWebUrl;
	private String tempImg;
	private static Config config = new Config();
	private static PropertyUtil WechatProperty=null;
	private Config(){
		if(WechatProperty == null){
			PropertyUtil p=new PropertyUtil(configFile);
			this.WechatProperty=p;
		}
		this.url = WechatProperty.get("wechat.url","").trim();
		this.encodingAESKey = WechatProperty.get("wechat.encodingaeskey","").trim();
		this.token = WechatProperty.get("wechat.token","").trim();
		this.appid = WechatProperty.get("wechat.appid","").trim();
		this.appSecret = WechatProperty.get("wechat.appsecret","").trim();
		this.accessTokenServer = WechatProperty.get("wechat.accessToken.server.class","").trim();
		this.jsApiTicketServer = WechatProperty.get("wechat.ticket.jsapi.server.class","").trim();
		this.baseWebUrl=WechatProperty.get("web.base.url","").trim();
		this.tempImg=WechatProperty.get("web.img.temp","").trim();
		logger.info("load wechat4j.properties success");
	}

	public static Config instance(){
		return config;
	}
	public String getToken() {
		return token;
	}
	public String getAppid() {
		return appid;
	}
	public String getAppSecret() {
		return appSecret;
	}

	public String getUrl() {
		return url;
	}

	public String getEncodingAESKey() {
		return encodingAESKey;
	}

	public String getAccessTokenServer(){
		return accessTokenServer;
	}

	public String getJsApiTicketServer() {
		return jsApiTicketServer;
	}

	public String getBaseWebUrl() {
		return baseWebUrl;
	}

	public String getTempImg() {
		return tempImg;
	}
}
