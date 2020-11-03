package com.slianOAsys.service;

import net.sf.json.JSONObject;

public interface SmsService {
	
	public JSONObject sendSMS(String mobiles,String content);
	
//	public JSONObject sendMessage(MessageSendBean message);
//	public JSONObject sendMessageCommon(MessageSendBean message);

}
