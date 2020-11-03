package com.slianOAsys.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.slianOAsys.dao.SlianoaDepartmentMapper;
import com.slianOAsys.dao.ex.SlianoaEmployeeExMapper;
import com.slianOAsys.model.SlianoaDepartment;
import com.slianOAsys.model.SlianoaDepartmentExample;
import com.slianOAsys.model.SlianoaEmployee;
import com.slianOAsys.model.ex.EmployeeEx;
import com.slianOAsys.page.Page;
import com.slianOAsys.service.DepartmentService;
import com.slianOAsys.service.utils.DateJsonValueProcessor;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

public class DepartmentServiceImpl implements DepartmentService{
	@Autowired
	private SlianoaDepartmentMapper SlianoaDepartmentMapper;
	@Autowired
	private SlianoaEmployeeExMapper SlianoaEmployeeExMapper;
	@Override
	public Object getDepartment(Integer pageSize, Integer pageIndex) {
		SlianoaDepartmentExample example = new SlianoaDepartmentExample();
		int totalrecords =SlianoaDepartmentMapper.countByExample(example);
			
		Page page = new Page();
		int pageBegin=(pageIndex-1)*pageSize;
		
		page.setBegin((pageIndex-1)*pageSize);
		page.setLength(pageSize);
		
		
		example.setPage(page);	
		
		List<SlianoaDepartment> stlist = SlianoaDepartmentMapper.selectByExample(example);
		
		Map<String, Object> map = new HashMap<String, Object>();	
		map.put("total", totalrecords);
		if (totalrecords % pageSize == 0)
			map.put("totalPages", totalrecords / pageSize);
		else
			map.put("totalPages", totalrecords / pageSize + 1);
			
			JsonConfig config = new JsonConfig();
			config.setIgnoreDefaultExcludes(false);
			config.registerJsonValueProcessor(Date.class,
					new DateJsonValueProcessor("HH:mm:ss"));
			JSONArray o =JSONArray.fromObject(stlist, config);
			
			map.put("rows", o);
			return map;
	}
	@Override
	public List<Integer> getEmployeeIdByDepartId(Integer departid) {
		List<EmployeeEx> stlist = SlianoaEmployeeExMapper.getEmployeeIdByDepartId(departid);
		List<Integer> employeeid = new ArrayList<Integer>();
		for(int i=0;i<stlist.size();i++){
			System.out.println("stlist:"+stlist.get(i).getEmployeeId());  
			employeeid.add(i, stlist.get(i).getEmployeeId());
		}
		return employeeid;
	}
}
