package com.sliansoft.slianOA.utils;

import com.sliansoft.slianOA.service.utils.Const;

public class SysConst extends Const {
	
	public static String QUERY_URL = "/pcbas-query/loginSpringboard.html";

	public static String ERROR_PAGE = "error.html";

	public static String[] ERROR_TYPE = { "你无权执行该操作", "你不是系统的员工，不能登陆报价管理系统" };
	
	public static String SUCCESS_MSG = "success";
	static class ERROR_MSG{
		
		public static String DB_ERROR ="数据库访问失败";
		
		public static String WECHAT_ERROR = "fail,need wechatAccount";
		
	}

}
