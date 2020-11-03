package com.slianOAsys.sysadmin.security;

/**
 * 
 */
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyAuthenticationListener implements HttpSessionListener {
	
	private static Map<String,Integer> currentLoginUserIds= new HashMap<String,Integer>();

	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		
		currentLoginUserIds.put(se.getSession().getId(), 0);

	}

	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		currentLoginUserIds.remove(se.getSession().getId());
	}
	
	public static void  addUserId(String sessionId,Integer userId){
		
		currentLoginUserIds.put(sessionId, userId);
	}
	
	public static Integer getUserId(String sessionId){
		
		
		return currentLoginUserIds.get(sessionId);
	}
	
	public static void removeUserId(String sessionId){
		
		currentLoginUserIds.remove(sessionId);
		
	}

}
