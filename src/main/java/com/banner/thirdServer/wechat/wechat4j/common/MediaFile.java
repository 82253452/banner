/**
 *
 */
package com.banner.thirdServer.wechat.wechat4j.common;

import java.io.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import com.alibaba.fastjson.JSON;
import com.banner.thirdServer.wechat.lang.HttpUtils;
import com.banner.thirdServer.wechat.wechat4j.token.TokenProxy;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 * 上传下载多媒体文件
 * @author ChengNing
 * @date   2015年1月6日
 */
public class MediaFile extends CommonMedia{


	/**
	 * 文件上传
	 * success: {"type":"TYPE","media_id":"MEDIA_ID","created_at":123456789}
	 * error:   {"errcode":40004,"errmsg":"invalid media type"}
	 * @return  media_id  成功返回 media_id, 失败返回null
	 */
	public MediaFile(String appId){
		super.appId=appId;
	}
	public String upload(File file,MediaType type){
		super.UPLOAD = "http://file.api.weixin.qq.com/cgi-bin/media/upload?access_token=";//临时素材
		this.file = file;
		this.type = type;
		String url = uploadUrl();
		String result = HttpUtils.postFile(url+ getToken(), PARAM_FILE, file);
		parseUploadResult(result);
		if(StringUtils.isNotBlank(this.mediaId))
			return this.mediaId;
		return null;
	}




}
