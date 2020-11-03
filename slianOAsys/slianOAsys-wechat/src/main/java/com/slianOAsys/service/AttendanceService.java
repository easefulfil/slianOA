package com.slianOAsys.service;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public interface AttendanceService {
	// public JSONObject signInJudge(String scheduleId, double latitude, double
	// longitude);

	public JSONObject signoffJudge(double latitude, double longitude, String wechatId);

	public JSONObject signInJudge(double latitude, double longitude, String wechatId);
	
	public List<JSONObject>  attendanceCalendar(String startTime, String endTime,String userId);
	
	public JSONObject  showAttendanceInfo(String userId);
	
	public JSONObject  submitAppeal(String formUserId,String toUserId,String content,String flag);
	
	public List<JSONObject>  showAppeal(String userId,String status);
	
	public List<JSONObject> showAppealNeedToHandled(String userId,String status);
	
	public JSONObject handleAppeal(String userId,String appealTime,String abnormalStatus,String handleStatus);
}
