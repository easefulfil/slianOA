package com.slianOAsys.service.impl;

import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.slianOAsys.dao.ex.SlianoaAppealExMapper;
import com.slianOAsys.model.SlianoaEmployee;
import com.slianOAsys.model.SlianoaEmployeeExample;
import com.slianOAsys.dao.SlianoaEmployeeMapper;
import com.slianOAsys.model.ex.AppealExExample.Criteria;
import com.slianOAsys.model.ex.AppealEx;
import com.slianOAsys.model.ex.AppealExExample;
import com.slianOAsys.model.ex.AttendanceEx;
import com.slianOAsys.page.Page;
import com.slianOAsys.service.AppealService;
import com.slianOAsys.service.utils.DateJsonValueProcessor;
import com.slianOAsys.service.utils.ExportExcel;
import com.slianOAsys.service.utils.SysConst;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

public class AppealServiceImpl implements AppealService{

	@Autowired
	private SlianoaAppealExMapper SlianoaAppealExMapper;
	@Autowired
	private SlianoaEmployeeMapper SlianoaEmployeeMapper;
	
	@Override
	public Object getAppeal(String employeename, String departname, String employeewechat, String appeal_status, String startdate,
			String enddate, Integer pageSize, Integer pageIndex) {
		
		AppealExExample example = new AppealExExample();
		Page page = new Page();
		int pageBegin=(pageIndex-1)*pageSize;
		page.setBegin((pageIndex-1)*pageSize);
		page.setLength(pageSize);
		example.setPage(page);	
		Criteria criteria = example.createCriteria();
		if(!"".equals(employeewechat))
			criteria.andEmployeeWechatLike("%"+employeewechat+"%");
		if(!"".equals(employeename))
			criteria.andEmployeeNameLike("%"+employeename+"%");
		if(!"".equals(departname))
			criteria.andDepartNameLike("%"+departname+"%");
		if(!"".equals(appeal_status)&&(!"全部".equals(appeal_status)))
			criteria.andAppealStatusEqualTo(appeal_status);
		if(!"".equals(startdate))
			criteria.andAppealTimeGreaterThanOrEqualTo(startdate);
		if(!"".equals(enddate))
			criteria.andAppealTimeGreaterThanOrEqualTo(enddate);
		int totalrecords =SlianoaAppealExMapper.countByExample(example);
		List<AppealEx> stlist = SlianoaAppealExMapper.selectByExample(example);	
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
	public void exportExcel(String employeename, String departname, String employeewechat, String appeal_status, String startdate,
			String enddate, OutputStream os) {
		AppealExExample example = new AppealExExample();
		Criteria criteria = example.createCriteria();
		
		if(!"".equals(employeewechat))
			criteria.andEmployeeWechatLike("%"+employeewechat+"%");
		if(!"".equals(employeename))
			criteria.andEmployeeNameLike("%"+employeename+"%");
		if(!"".equals(departname))
			criteria.andDepartNameLike("%"+departname+"%");
		if(!"".equals(appeal_status))
			criteria.andAppealStatusEqualTo(appeal_status);
		if(!"".equals(startdate))
			criteria.andAppealTimeGreaterThanOrEqualTo(startdate);
		if(!"".equals(enddate))
			criteria.andAppealTimeGreaterThanOrEqualTo(enddate);
		List<AppealEx> stlist = SlianoaAppealExMapper.selectByExample(example);	
		
		ExportExcel<AppealEx> exportExcel = new ExportExcel<AppealEx>();
		
		exportExcel.exportExcel("导出考勤申诉", SysConst.ExcelConst.HEAD_ATTENDANCE_APPEAL,
				SysConst.ExcelConst.FIELDNAMES_ATTENDANCE_APPEAL, stlist, os,
				"HH:mm:ss");
		
	}

	@Override
	public Object getEmployeeNameById(int employeeId) {
		SlianoaEmployeeExample example = new SlianoaEmployeeExample();
		com.slianOAsys.model.SlianoaEmployeeExample.Criteria criteria = example.createCriteria();
		
		if(!"".equals(employeeId))
			criteria.andEmployeeIdEqualTo(employeeId);
		List<SlianoaEmployee> stlist = SlianoaEmployeeMapper.selectByExample(example);	
		Map<String, Object> map = new HashMap<String, Object>();	
		map.put("EmployeeName", stlist.get(0).getEmployeeName());
		return map;
	}

}
