/**
 * 
 */
package com.banner.thirdServer.wechat.wechat4j.token;


import com.banner.thirdServer.wechat.wechat4j.token.server.AccessTokenServer;
import com.banner.thirdServer.wechat.wechat4j.token.server.JsApiTicketServer;
import com.banner.thirdServer.wechat.wechat4j.token.server.TicketServer;
import com.banner.thirdServer.wechat.wechat4j.token.server.TokenServer;

/**
 * AccessToken代理
 * 所有获取accessToken的地方都通过此代理获得
 * 获得方法String token = AccessTokenProxy.token()
 * @author ChengNing
 * @date   2015年1月9日
 */
public class TokenProxy {
	
	/**
	 * 通过代理得到accessToken的串
	 */
	public static String accessToken(){
		TokenServer accessTokenServer = new AccessTokenServer();
		return accessTokenServer.token();
	}
	
	/**
	 * 通过代理得到jsapi_ticket
	 */
	public static String jsApiTicket(){
		TicketServer ticketServer = new JsApiTicketServer();
		return ticketServer.ticket();
	}
	

	
	
}
