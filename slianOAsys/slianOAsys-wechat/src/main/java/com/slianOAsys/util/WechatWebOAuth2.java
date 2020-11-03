package com.slianOAsys.util;

import com.slianOAsys.enums.EnumMethod;

import net.sf.json.JSONObject;

public class WechatWebOAuth2 {
	private static final String get_weboauth2_url = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=APPID&corpsecret=SECRET";
	private static final String get_user_url = "https://qyapi.weixin.qq.com/cgi-bin/user/getuserinfo?access_token=ACCESS_TOKEN&code=CODE";
	public static String ACCESS_TOCKEN = "";
	
	public static JSONObject getAccessTokenByCode() {
		String menuUrl = get_weboauth2_url.replace("APPID", Constants.CORPID).replace("SECRET", Constants.SECRET);
		JSONObject jo = HttpRequestUtil.httpRequest(menuUrl, EnumMethod.GET.name(), null);
		System.out.println("jo=" + jo);
		ACCESS_TOCKEN = jo.getString("access_token");
		
		return jo;
	}
	public static JSONObject getUserByAccessToken(String code, String token) {
		String menuUrl = get_user_url.replace("ACCESS_TOKEN", token).replace("CODE", code);
		JSONObject jo = HttpRequestUtil.httpRequest(menuUrl, EnumMethod.GET.name(), null);
		System.out.println("jo=" + jo);
		return jo;
	}
}
