package com.slianOAsys.service.utils;

public class Constants {
	/**
	 * 常量说明：
	 * 此处定义的常量需要持久化，可以保存在数据库中，在需要的地方读取。
	 * 在多企业号中，最好以每个应用来定义。
	 */
	public static final Integer SCHEDULE_STATUE_NORMAL =2; //正常班次
	public static final Integer SCHEDULE_STATUE_WORKWEEKDAY=1;//值休
	public static final Integer SCHEDULE_STATUE_WEEKDAY=0;//周末
	public static final Integer SIGNIN_NOSIGNOFF =3; //签到未签退
	public static final Integer SIGNIN_LATE_NOSIGNOFF=4;//签到迟到
	public static final Integer NOSIGNIN_SIGNOFF_EARlY=5;//未签到早退
	public static final Integer SIGNIN_SIGNOFF_EARlY=6;//签到早退
	public static final Integer SIGNIN_LATE_SIGNOFF_EARlY=7;//迟到早退
	public static final Integer NOSIGNIN_SIGNOFF=8;//未签到签退
	public static final Integer SIGNIN_SIGNOFF=9;//完成打卡
	public static final Integer SIGNIN_LATE_SIGNOFF=10;//迟到签退
	public static final Integer LEAVE_OFF_STATUS=11;//请假
	public static final Integer CHANGE_OFF_STATUS=13;//调休状态
	
	public static final String OPTTYPE_CHANGESCHEDULE = "1"; //调班申请
	public static final String OPTTYPE_LEAVEFORSCHEDULE = "2";//按照班次请假
	public static final String OPTTYPE_LEAVEFORDATE = "3";//按照时间申请
	
	public static final String IS_ON_WORK ="1"; //在职
	public static final String IS_NOT_WORK="0";//不在职

	
	public static final String OPERATE_AGREE ="2"; //在职
	public static final String OPERATE_REFUSE="3";//不在职

	public static final String NOSIGNIN="1";//未签到
	public static final String SIGNIN="2";//签到
	public static final String SIGNIN_LATE="3";//迟到
	
	public static final String NOSIGNOFF="1";//未签退
	public static final String SIGNOFF="2";//签退
	public static final String SIGNOFF_EARLY="3";//早退
}
