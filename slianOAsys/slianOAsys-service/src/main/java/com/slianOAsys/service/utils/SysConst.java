package com.slianOAsys.service.utils;
/**
 * 
 */


import java.math.BigDecimal;
import java.util.Map;

/**
 * Copyright@宁波高新区敏智科技有限公司 www.mz3co.com
 * Copyright@浙江大学软件学院S309实验室
 *
 * @author chengxl
 * Cteated time：2015年1月17日 上午9:44:25   
 *
 */


//servcie层常量类,被web继承，在web层启动时做初始化
public abstract class SysConst {
	
	public static String SMS_SENDURL = "http://www.tosms.cn/Api/SendSms.ashx" ;

	public static String SMS_USERNAME = "zy87302728";

	public static String SMS_PASSWORD = "9389796395346BE90FD6D4E57DC4D479";
	
	public static String ADMIN_URL = "cnsce-index.html";
	
	public static String PORTALSYSTEM_URL = "";
	
	/**
	 * 系统员工id，name map
	 */
	public static Map<Integer,String> EMPLOYEE_MAP = null;

	
	/**
	 * 系统参数设置
	 */
	public static Map<String,String> SYSTEMSETTING = null;
	
	/**
	 * 系统资源tree,不包含业务级资源
	 */
	public static SysResourcesTree RESOURCESTREE_UNINCLUDE_BUSINESS = null;
	/**
	 * 系统资源tree
	 */
	public static SysResourcesTree RESOURCESTREE = null;
	
	/**
	 * 系统组织架构 tree
	 */
	public static SysOrganizationStructureTree ORGANIZATIONSTRUCTURE_TREE = null;
	
	/**
	 * 基础数据集tree
	 */
	public static SysBasicDataSetTree BASICDATASET_TREE = null;
	
	
	
	/**
	 * 角色、资源、组织架构映射常量
	 */
	public static RoleResourceOrganization ROLE_RESOURCE = null;

	public static Map<Integer, String> PARAMETER_MAP = null;
	
	public static Map<Integer, String> PRODUCER_MAP = null;

	public static Map<Integer, String> EQUIPMENT_MAP = null;
	
	public static Map<Integer, String> MEETING_MAP = null;
	
	public static Map<Integer, String> MEETING_EMPLOYEE_MAP = null;

	public static Map<BigDecimal, String> INSPECTIONRECORD_MAP = null;
	
	
	public static class  ExcelConst{
		
		public static final   String[] HEAD_ATTENDANCE_BYDAY = {"账号","姓名","工号",
				"部门","考勤日","签到时间","签退时间","工作时长",
				"迟到","早退","考勤规则","考勤开始时间","考勤结束时间"
				};
				
			
		public static final   String[] FIELDNAMES_ATTENDANCE_BYDAY= {"employeeWechat","employeeName","employeeId",
				"departName","attendanceTime","attendanceSigntime","attendanceOfftime","workHour",
				"late","before","className","startTime","endTime"};
		
		public static final   String[] HEAD_ATTENDANCE_DETAIL = {
				"姓名","考勤日期","考勤状态","签到时间","签退时间","考勤规则"};
				
			
		public static final   String[] FIELDNAMES_ATTENDANCE_DETAIL= {
				"employeeName","attendanceTime","attendanceTotalStatusToString",
				"attendanceSigntime","attendanceOfftime","className"};
		
		public static final   String[] HEAD_ATTENDANCE_APPEAL = {
				"姓名","账号","部门","考勤日","异常情况","审批状态"};
				
			
		public static final   String[] FIELDNAMES_ATTENDANCE_APPEAL= {
				"employeeName","employeeWechat","departName",
				"appealTime","abnormalStatus","appealStatus"};
		
	}

}
