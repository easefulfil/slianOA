package com.slianOAsys.service;

import java.util.List;

import java.util.Map;

import com.slianOAsys.model.SysLog;

public interface SysLogService {
	
	public List<SysLog> getLogs(String keys);
	
	public Map<String, Object>getLogsByPage(String keys,Integer pageSize,Integer pageIndex);
	

}

	

