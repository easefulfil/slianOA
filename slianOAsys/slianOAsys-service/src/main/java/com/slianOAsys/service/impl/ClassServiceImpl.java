package com.slianOAsys.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;


import com.slianOAsys.service.utils.DateJsonValueProcessor;
import com.slianOAsys.dao.SlianoaClassMapper;
import com.slianOAsys.dao.ex.SlianoaClassExMapper;
import com.slianOAsys.model.SlianoaClass;
import com.slianOAsys.model.SlianoaClassExample;
import com.slianOAsys.model.SlianoaClassExample.Criteria;
import com.slianOAsys.page.Page;
import com.slianOAsys.service.ClassService;
import com.slianOAsys.dao.ex.SlianoaClassEmployeeExMapper;
import com.slianOAsys.model.ex.ClassEmployeeEx;
import com.slianOAsys.model.ex.ClassEx;
import com.slianOAsys.model.slianoaUnattendDays;
import com.slianOAsys.dao.slianoaUnattendDaysMapper;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

public class ClassServiceImpl implements ClassService{
	@Autowired
	private slianoaUnattendDaysMapper slianoaUnattendDaysMapper;
	@Autowired
	private SlianoaClassMapper SlianoaClassMapper;
	@Autowired
	private SlianoaClassExMapper SlianoaClassExMapper;
	@Autowired
	private SlianoaClassEmployeeExMapper SlianoaClassEmployeeExMapper;
	@Override
	public Object getClass(String classname,String createstarttime,String createendtime,String classstatus,Integer pageSize, Integer pageIndex) throws ParseException {
		SlianoaClassExample example = new SlianoaClassExample();
		Page page = new Page();
		int pageBegin=(pageIndex-1)*pageSize;
		page.setBegin((pageIndex-1)*pageSize);
		page.setLength(pageSize);
		example.setPage(page);	
		Criteria criteria = example.createCriteria();
		if(!"".equals(classname))
			criteria.andClassNameLike("%"+classname+"%");
		if(!"".equals(createstarttime)){
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD"); 
			Date createStarttime = sdf.parse(createstarttime); 
			criteria.andCreateTimeGreaterThanOrEqualTo(createStarttime);
		}
		if(!"".equals(createendtime)){
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD"); 
			Date createEndtime = sdf.parse(createendtime); 
			criteria.andCreateTimeLessThanOrEqualTo(createEndtime);
		}	
		if(!"".equals(classstatus))
			criteria.andClassStatusEqualTo(classstatus);
		int totalrecords =SlianoaClassMapper.countByExample(example);
		List<ClassEx> stlist = SlianoaClassExMapper.selectByExample(example);
		for(int i=0;i<stlist.size();i++){
			int classid=stlist.get(i).getClassId();
			List<ClassEmployeeEx> ceelist=SlianoaClassEmployeeExMapper.selectDepartnameByClass(classid);
			List departname = new ArrayList();
			for(int j=0;j<ceelist.size();j++){
				departname.add(j, ceelist.get(j).getDepartName());
			}
			stlist.get(i).setDepartName(departname);
		}
		
		
		Map<String, Object> map = new HashMap<String, Object>();	
		map.put("total", totalrecords);
		if (totalrecords % pageSize == 0)
			map.put("totalPages", totalrecords / pageSize);
		else
			map.put("totalPages", totalrecords / pageSize + 1);
			
			JsonConfig config = new JsonConfig();
			config.setIgnoreDefaultExcludes(false);
			config.registerJsonValueProcessor(Date.class,
					new DateJsonValueProcessor("YYYY-MM-dd HH:mm:ss"));
			JSONArray o =JSONArray.fromObject(stlist, config);
			
			map.put("rows", o);
			return map;
	}

	@Override
	public String update(SlianoaClass classes) {
		if (SlianoaClassMapper.updateByPrimaryKeySelective(classes) < 1){
			return "修改失败";
		}else{
			return "修改成功";
		}
	}

	@Override
	public String insert(SlianoaClass classes) {
		int b= SlianoaClassMapper.insertSelective(classes);
		if( b==0)
			return "数据库访问失败，位置信息插入失败！";
		else
		return "新增班次成功!";
	}

	@Override
	public Object getClassById(int classid) {
		
		List<ClassEx> clist=SlianoaClassExMapper.getClassById(classid);
		JsonConfig config = new JsonConfig();
		config.setIgnoreDefaultExcludes(false);
		config.registerJsonValueProcessor(Date.class,
				new DateJsonValueProcessor("HH:mm"));
		JSONArray o =JSONArray.fromObject(clist, config);
		return o;
	}

	@Override
	public int delete(int classid) {
		return SlianoaClassMapper.deleteByPrimaryKey(classid);
	}

	@Override
	public int insertDeleteUnattendanceDays(int classid,String date) {
		slianoaUnattendDays slianoaUnattendDays=new slianoaUnattendDays();
		slianoaUnattendDays.setAddOrDelete("delete");
		slianoaUnattendDays.setDate(date);
		slianoaUnattendDays.setClassId(classid);
		return slianoaUnattendDaysMapper.insertSelective(slianoaUnattendDays);
	}

	@Override
	public int insertAddUnattendanceDays(int classid,String date) {
		slianoaUnattendDays slianoaUnattendDays=new slianoaUnattendDays();
		slianoaUnattendDays.setAddOrDelete("add");
		slianoaUnattendDays.setDate(date);
		slianoaUnattendDays.setClassId(classid);
		return slianoaUnattendDaysMapper.insertSelective(slianoaUnattendDays);
	}
}
