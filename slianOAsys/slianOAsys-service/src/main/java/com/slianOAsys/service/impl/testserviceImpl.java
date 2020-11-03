package com.slianOAsys.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;


import com.slianOAsys.service.utils.DateJsonValueProcessor;
import com.slianOAsys.dao.testMapper;
import com.slianOAsys.model.test;
import com.slianOAsys.model.testExample;
import com.slianOAsys.page.Page;
import com.slianOAsys.service.testservice;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

public class testserviceImpl implements testservice{

	@Autowired
	private testMapper testMapper;
	@Override
	public Object getTest(Integer pageSize, Integer pageIndex) {
		testExample example = new testExample();
		int totalrecords =testMapper.countByExample(example);
			
		Page page = new Page();
		int pageBegin=(pageIndex-1)*pageSize;
		
		page.setBegin((pageIndex-1)*pageSize);
		page.setLength(pageSize);
		
		
		example.setPage(page);	
		
		List<test> stlist = testMapper.selectByExample(example);
		
		Map<String, Object> map = new HashMap<String, Object>();	
		map.put("total", totalrecords);
		if (totalrecords % pageSize == 0)
			map.put("totalPages", totalrecords / pageSize);
		else
			map.put("totalPages", totalrecords / pageSize + 1);
			
			JsonConfig config = new JsonConfig();
			config.setIgnoreDefaultExcludes(false);
			config.registerJsonValueProcessor(Date.class,
					new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));
			JSONArray o =JSONArray.fromObject(stlist, config);
			
			map.put("rows", o);
			return map;
	}

}
