/**
 * 
 */
package com.slianOAsys.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.springframework.beans.factory.annotation.Autowired;

import com.slianOAsys.dao.SysLogMapper;
import com.slianOAsys.model.SysLog;
import com.slianOAsys.model.SysLogExample;
import com.slianOAsys.model.SysLogExample.Criteria;
import com.slianOAsys.page.Page;
import com.slianOAsys.service.SysLogService;
import com.slianOAsys.service.utils.DateHandler;
import com.slianOAsys.service.utils.DateJsonValueProcessor;

/**
 * Copyright@宁波高新区敏智科技有限公司 www.mz3co.com Copyright@浙江大学软件学院S309实验室
 * 
 * @author chengxl Cteated time：2015年1月8日 上午9:13:48
 * @param <JSONArray>
 * 
 */
public class SysLogServiceImpl implements SysLogService {

	@Autowired
	private SysLogMapper logMapper;

	

	@Override
	public List<SysLog> getLogs(String keys) {
		// TODO Auto-generated method stub

		SysLogExample example = new SysLogExample();

		JSONObject jKeys = JSONObject.fromObject(keys);

		Criteria criteria = example.createCriteria();

		// 设置截关日期
		if (jKeys.containsKey("startDate"))
			criteria.andLogTimeGreaterThanOrEqualTo(DateHandler.strToDate(
					jKeys.getString("startDate"), "yyyy-MM-dd"));

		if (jKeys.containsKey("endDate"))
			criteria.andLogTimeLessThanOrEqualTo(DateHandler.strToDate(
					jKeys.getString("endDate"), "yyyy-MM-dd"));

		return logMapper.selectByExample(example);
	}

	@Override
	public Map<String, Object> getLogsByPage(String keys, Integer pageSize,
			Integer pageIndex) {
		// TODO Auto-generated method stub

		JSONObject jKeys = JSONObject.fromObject(keys);
		
		SysLogExample example = new SysLogExample();
		
		Criteria criteria = example.createCriteria();
		
		if(jKeys.containsKey("userId")  && !"".equals(jKeys.getString("userId")))
			criteria.andLogUserIdEqualTo(jKeys.getInt("userId"));
		
		if(jKeys.containsKey("type")  && !"".equals(jKeys.getString("type")))
			criteria.andLogTypeEqualTo(jKeys.getString("type"));
//		criteria.andLogUserIdEqualTo(123);

		// 设置截关日期
		if (jKeys.containsKey("startTime") && !"".equals(jKeys.getString("startTime")))
			criteria.andLogTimeGreaterThanOrEqualTo(DateHandler.strToDate(
					jKeys.getString("startTime"), "yyyy-MM-dd"));

		if (jKeys.containsKey("endTime") &&  !"".equals(jKeys.getString("endTime")))
			criteria.andLogTimeLessThanOrEqualTo(DateHandler.strToDate(
					jKeys.getString("endTime"), "yyyy-MM-dd"));

		int totalrecords = logMapper.countByExample(example);

/**
 * for my sql db
 */
	Page page = new Page();
	
	page.setBegin((pageIndex-1)*pageSize);
	page.setLength(pageSize);
	example.setPage(page);
	List<SysLog> listLog = logMapper.selectByExample(example);
		
/**
 * for  sql server db
 */
//		example.setPageIndex(pageIndex);
//		example.setPageSize(pageSize);
//		example.setOrderByClause("log_id desc");
//
//		List<SysLog> listLog = logMapper.selectPage(example);

		// 处理json数据中的日期格式
		JsonConfig config = new JsonConfig();
		config.setIgnoreDefaultExcludes(false);
		config.registerJsonValueProcessor(Date.class,
				new DateJsonValueProcessor("yyyy-MM-dd HH:ss:mm"));

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", totalrecords);
		if (totalrecords % pageSize == 0)
			map.put("totalPages", totalrecords / pageSize);
		else
			map.put("totalPages", totalrecords / pageSize + 1);

		map.put("rows", JSONArray.fromObject(listLog, config));

		return map;
	};
}
