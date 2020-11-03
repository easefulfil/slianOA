package com.slianOAsys.util;


public class Constants {
	/**
	 * 常量说明：
	 * 此处定义的常量需要持久化，可以保存在数据库中，在需要的地方读取。
	 * 在多企业号中，最好以每个应用来定义。
	 */
	public static final int AGENTID = 1;
	public static final String TOKEN = "X6id0TthEFxQEp1itanr7cSGculhYS";
	public static final String CORPID = "wx6dfdff9bb253670b";
	public static final String SECRET = "CPG1L3lz2iNZe3Aq914pgEkSqdFBKpmpXiuDGwWhhnPZbhwqeUTHAgMo5Uqr9bac";
	public static final String encodingAESKey = "gBoLNMxnSWjJ8nN6qB6MV7eWKuCTwcWB1rIkWxeGzaf";
	public static final String OPTTYPE_CHANGESCHEDULE = "1"; //调班申请
	public static final String OPTTYPE_LEAVEFORSCHEDULE = "2";//按照班次请假
	public static final String OPTTYPE_LEAVEFORDATE = "3";//按照时间申请
	//排班申请操作状态
	public static final String OPERATE_STATUE_APPLY ="1"; //调班申请
	public static final String OPERATE_STATUE_AGREE ="2";//按照班次请假
	public static final String OPERATE_STATUE_REFUSE ="3";//按照时间申请
	//public static List<Object> CURRENT_USER_LIST = new ArrayList<Object>();
	
	//public static Map<String,String> CURRENT_USER_MAP = new HashMap<String,String>();
	public static final Integer SCHEDULE_STATUE_WEEKDAY=0;//周末
	public static final Integer SCHEDULE_STATUE_WORKWEEKDAY=1;//值休
	public static final Integer SCHEDULE_STATUE_NORMAL =2; //正常班次
	public static final Integer SIGNIN_NOSIGNOFF =3; //签到未签退
	public static final Integer SIGNIN_LATE_NOSIGNOFF=4;//签到迟到
	public static final Integer NOSIGNIN_SIGNOFF_EARlY=5;//未签到早退
	public static final Integer SIGNIN_SIGNOFF_EARlY=6;//签到早退
	public static final Integer SIGNIN_LATE_SIGNOFF_EARlY=7;//迟到早退
	public static final Integer NOSIGNIN_SIGNOFF=8;//未签到签退
	public static final Integer SIGNIN_SIGNOFF=9;//完成打卡
	public static final Integer SIGNIN_LATE_SIGNOFF=10;//迟到签退
	public static final Integer LEAVE_OFF_STATUS=11;//请假
	
	public static final String NOSIGNIN="1";//未签到
	public static final String SIGNIN="2";//签到
	public static final String SIGNIN_LATE="3";//迟到
	
	public static final String NOSIGNOFF="1";//未签退
	public static final String SIGNOFF="2";//签退
	public static final String SIGNOFF_EARLY="3";//早退

	
	public static final String WECHAT_API_URL="http://apis.map.qq.com/ws/geocoder/v1/";//微信地图api
	public static final String WECHAT_API_KEY="QL7BZ-WELC3-K743Q-3VG54-ANLOT-XYF36";//微信地图KEY
	
	
	
}
