package com.slianOAsys.service.impl;

import java.io.OutputStream;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;


import com.slianOAsys.service.utils.DateJsonValueProcessor;
import com.slianOAsys.model.ex.AttendanceExExample.Criteria;
import com.slianOAsys.model.ex.EmployeeEx;
import com.slianOAsys.model.ex.EmployeeExExample;
import com.slianOAsys.service.utils.ExportExcel;
import com.slianOAsys.service.utils.SysConst;
import com.slianOAsys.dao.SlianoaAttendanceMapper;
import com.slianOAsys.dao.ex.SlianoaAttendanceExMapper;
import com.slianOAsys.dao.ex.SlianoaEmployeeExMapper;
import com.slianOAsys.model.SlianoaAttendance;
import com.slianOAsys.model.SlianoaAttendanceExample;
import com.slianOAsys.model.SlianoaClass;
import com.slianOAsys.model.ex.AttendanceEx;
import com.slianOAsys.model.ex.AttendanceExExample;
import com.slianOAsys.page.Page;
import com.slianOAsys.service.AttendanceService;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

public class AttendanceServiceImpl implements AttendanceService{

	@Autowired
	private SlianoaAttendanceMapper SlianoaAttendanceMapper;
	@Autowired
	private SlianoaAttendanceExMapper SlianoaAttendanceExMapper;
	@Autowired
	private SlianoaEmployeeExMapper SlianoaEmployeeExMapper;
	
	@Override
	public Object getAttendance(String employeename,String className,String attendance_total_status,String startdate,String enddate,String departname,Integer pageSize, Integer pageIndex) {
		
		AttendanceExExample example = new AttendanceExExample();
		Page page = new Page();
		int pageBegin=(pageIndex-1)*pageSize;
		page.setBegin((pageIndex-1)*pageSize);
		page.setLength(pageSize);
		example.setPage(page);	
		Criteria criteria = example.createCriteria();
		
		if(!"".equals(employeename))
			criteria.andEmployeeNameLike("%"+employeename+"%");
		if(!"".equals(className))
			criteria.andClassNameEqualTo(className);
		if(!"".equals(departname))
			criteria.andDepartNameLike("%"+departname+"%");
		if(!"".equals(attendance_total_status)){
			if(attendance_total_status.equals("1")){
				criteria.andAttendanceTotalStatusEqualTo("签到签退");
			}else if(attendance_total_status.equals("2")){
				criteria.andAttendanceTotalStatusNotEqualTo("签到签退");
			}
		}
		if(!"".equals(startdate))
			criteria.andAttendanceTimeGreaterThanOrEqualTo(startdate);
		if(!"".equals(enddate))
			criteria.andAttendanceTimeLessThanOrEqualTo(enddate);
		int totalrecords =SlianoaAttendanceExMapper.countByExample(example);
		List<AttendanceEx> stlist = SlianoaAttendanceExMapper.selectByExample(example);	
		Map<String, Object> map = new HashMap<String, Object>();	
		map.put("total", totalrecords);
		if (totalrecords % pageSize == 0)
			map.put("totalPages", totalrecords / pageSize);
		else
			map.put("totalPages", totalrecords / pageSize + 1);
		
		for(int i=0;i<stlist.size();i++){
			String attendancetime=stlist.get(i).getAttendanceTime();
			String attendanceTime=com.slianOAsys.service.utils.DateHandler.changeFormat(attendancetime);
			stlist.get(i).setAttendanceTime(attendanceTime);
			Date signin=stlist.get(i).getAttendanceSigntime();
			Date signoff=stlist.get(i).getAttendanceOfftime();
			Date starttime=stlist.get(i).getStartTime();
			Date endtime=stlist.get(i).getEndTime();
			long late=(signin.getTime()-starttime.getTime())/(60 * 1000);
			long before=(endtime.getTime()-signoff.getTime())/(60 * 1000);
			if(late>0){
				stlist.get(i).setLate(late);
			}else{
				stlist.get(i).setLate(0);
			}
			if(before>0&&(!stlist.get(i).getAttendanceOffstatus().equals("未签退"))){
				stlist.get(i).setBefore(before);
			}else{
				stlist.get(i).setBefore(0);
			}
			NumberFormat nFormat=NumberFormat.getNumberInstance(); 
			nFormat.setMaximumFractionDigits(2);//设置小数点后面位数为
			float workhour=stlist.get(i).getWorkHour();
			float workHour=Float.parseFloat(nFormat.format(workhour));
			stlist.get(i).setWorkHour(workHour);
		}
		
			JsonConfig config = new JsonConfig();
			config.setIgnoreDefaultExcludes(false);
			config.registerJsonValueProcessor(Date.class,
					new DateJsonValueProcessor("HH:mm:ss"));
			JSONArray o =JSONArray.fromObject(stlist, config);
			map.put("rows", o);
			return map;
	}
	
	@Override
	public Object getAttendanceDetail(String signstatus,String employeename,String className,
			String attendance_total_status,String startdate,
			String enddate,String departname,Integer pageSize, Integer pageIndex) {
		AttendanceExExample example = new AttendanceExExample();
		Page page = new Page();
		int pageBegin=(pageIndex-1)*pageSize;
		page.setBegin((pageIndex-1)*pageSize);
		page.setLength(pageSize);
		example.setPage(page);	
		Criteria criteria = example.createCriteria();
		
		if(!"".equals(employeename))
			criteria.andEmployeeNameLike("%"+employeename+"%");
		if(!"".equals(className))
			criteria.andClassNameEqualTo(className);
		if(!"".equals(departname))
			criteria.andDepartNameLike("%"+departname+"%");
		if(!"".equals(signstatus)){
			if(signstatus.equals("1")){
				criteria.andAttendanceSignstatusNotEqualTo("未签到");
			}else if(signstatus.equals("2")){
				criteria.andAttendanceSignstatusEqualTo("未签到");
			}
		}
		if(!"".equals(attendance_total_status)){
			if(attendance_total_status.equals("1")){
				criteria.andAttendanceTotalStatusEqualTo("签到签退");
			}else if(attendance_total_status.equals("2")){
				criteria.andAttendanceTotalStatusNotEqualTo("签到签退");
			}
		}
		if(!"".equals(startdate))
			criteria.andAttendanceTimeGreaterThanOrEqualTo(startdate);
		if(!"".equals(enddate))
			criteria.andAttendanceTimeLessThanOrEqualTo(enddate);	
		
		int totalrecords =SlianoaAttendanceExMapper.countByExample(example);
		List<AttendanceEx> stlist = SlianoaAttendanceExMapper.selectByExample(example);	
		
		Map<String, Object> map = new HashMap<String, Object>();	
		map.put("total", totalrecords);
		if (totalrecords % pageSize == 0)
			map.put("totalPages", totalrecords / pageSize);
		else
			map.put("totalPages", totalrecords / pageSize + 1);
		
			JsonConfig config = new JsonConfig();
			config.setIgnoreDefaultExcludes(false);
			config.registerJsonValueProcessor(Date.class,
					new DateJsonValueProcessor("HH:mm"));
			JSONArray o =JSONArray.fromObject(stlist, config);
			map.put("rows", o);
			return map;
	}
	
	@Override
	public void exportExcel(String employeename,String classname, String attendance_total_status, String startdate, String enddate, String departname,
			OutputStream os) {
		
		AttendanceExExample example = new AttendanceExExample();

		Criteria criteria = example.createCriteria();
		
		if(!"".equals(employeename))
			criteria.andEmployeeNameLike("%"+employeename+"%");
		if(!"".equals(classname))
			criteria.andClassNameEqualTo(classname);
		if(!"".equals(departname))
			criteria.andDepartNameLike("%"+departname+"%");
		if(!"".equals(attendance_total_status)){
			if(attendance_total_status.equals("1")){
				criteria.andAttendanceTotalStatusEqualTo("签到签退");
			}else if(attendance_total_status.equals("2")){
				criteria.andAttendanceTotalStatusNotEqualTo("签到签退");
			}
		}
		if(!"".equals(startdate))
			criteria.andAttendanceTimeGreaterThanOrEqualTo(startdate);
		if(!"".equals(enddate))
			criteria.andAttendanceTimeLessThanOrEqualTo(enddate);
		
		List<AttendanceEx> stlist = SlianoaAttendanceExMapper.selectByExample(example);	
		
		for(int i=0;i<stlist.size();i++){
			String attendancetime=stlist.get(i).getAttendanceTime();
			String attendanceTime=com.slianOAsys.service.utils.DateHandler.changeFormat(attendancetime);
			stlist.get(i).setAttendanceTime(attendanceTime);
			Date signin=stlist.get(i).getAttendanceSigntime();
			Date signoff=stlist.get(i).getAttendanceOfftime();
			Date starttime=stlist.get(i).getStartTime();
			Date endtime=stlist.get(i).getEndTime();
			long late=(signin.getTime()-starttime.getTime())/(60 * 1000);
			long before=(endtime.getTime()-signoff.getTime())/(60 * 1000);
			if(late>0){
				stlist.get(i).setLate(late);
			}else{
				stlist.get(i).setLate(0);
			}
			if(before>0){
				stlist.get(i).setBefore(before);
			}else{
				stlist.get(i).setBefore(0);
			}
			NumberFormat nFormat=NumberFormat.getNumberInstance(); 
			nFormat.setMaximumFractionDigits(2);//设置小数点后面位数为
			float workhour=stlist.get(i).getWorkHour();
			float workHour=Float.parseFloat(nFormat.format(workhour));
			stlist.get(i).setWorkHour(workHour);
		}
		ExportExcel<AttendanceEx> exportExcel = new ExportExcel<AttendanceEx>();
		
		exportExcel.exportExcel("导出考勤日报", SysConst.ExcelConst.HEAD_ATTENDANCE_BYDAY,
				SysConst.ExcelConst.FIELDNAMES_ATTENDANCE_BYDAY, stlist, os,
				"HH:mm:ss");
		
	}
	
	@Override
	public void detailExportExcel(String signstatus, String employeename, String classname, String attendance_total_status,
			String startdate, String enddate, String departname, OutputStream os) {
	
		AttendanceExExample example = new AttendanceExExample();
		Criteria criteria = example.createCriteria();
		
		if(!"".equals(employeename))
			criteria.andEmployeeNameLike("%"+employeename+"%");
		if(!"".equals(classname))
			criteria.andClassNameEqualTo(classname);
		if(!"".equals(departname))
			criteria.andDepartNameLike("%"+departname+"%");
		if(!"".equals(signstatus)){
			if(signstatus.equals("1")){
				criteria.andAttendanceSignstatusNotEqualTo("未签到");
			}else if(signstatus.equals("2")){
				criteria.andAttendanceSignstatusEqualTo("未签到");
			}
		}
		if(!"".equals(attendance_total_status)){
			if(attendance_total_status.equals("1")){
				criteria.andAttendanceTotalStatusEqualTo("1");
			}else if(attendance_total_status.equals("2")){
				criteria.andAttendanceTotalStatusNotEqualTo("1");
			}
		}
		if(!"".equals(startdate))
			criteria.andAttendanceTimeGreaterThanOrEqualTo(startdate);
		if(!"".equals(enddate))
			criteria.andAttendanceTimeLessThanOrEqualTo(enddate);	
		
		List<AttendanceEx> stlist = SlianoaAttendanceExMapper.selectByExample(example);	
		for(int i=0;i<stlist.size();i++){
			String attendanceTotalStatus=stlist.get(i).getAttendanceTotalStatus();
			if(attendanceTotalStatus.equals("签到签退"))
				stlist.get(i).setAttendanceTotalStatusToString("正常");
			else
				stlist.get(i).setAttendanceTotalStatusToString("异常");
		}
		ExportExcel<AttendanceEx> exportExcel = new ExportExcel<AttendanceEx>();
		
		exportExcel.exportExcel("导出考勤明细", SysConst.ExcelConst.HEAD_ATTENDANCE_DETAIL,
				SysConst.ExcelConst.FIELDNAMES_ATTENDANCE_DETAIL, stlist, os,"HH:mm:ss");
	}
	
	
	@Override
	public Object getAttendanceMonth(String className,String start,String end,String employeeName,String departName,Integer pageSize, Integer pageIndex) throws ParseException {
		EmployeeExExample example = new EmployeeExExample();
		EmployeeExExample example2 = new EmployeeExExample();
		Page page = new Page();
		int pageBegin=(pageIndex-1)*pageSize;
		page.setBegin((pageIndex-1)*pageSize);
		page.setLength(pageSize);
		example.setPage(page);	
		
	//	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	//	String startdate=df.format(start);
	//	String enddate=df.format(end);
		com.slianOAsys.model.ex.EmployeeExExample.Criteria criteria = example.createCriteria();
		com.slianOAsys.model.ex.EmployeeExExample.Criteria criteria2 = example2.createCriteria();
		if(!"".equals(start))
			criteria.andAttendanceTimeGreaterThanOrEqualTo(start);
		if(!"".equals(end))
			criteria.andAttendanceTimeLessThanOrEqualTo(end);
		if(!"".equals(className))
			criteria.andClassNameLike("%"+className+"%");
		if(!"".equals(employeeName))
			criteria.andEmployeeNameLike("%"+employeeName+"%");
		if(!"".equals(departName))
			criteria.andDepartNameLike("%"+departName+"%");
		if(!"".equals(employeeName))
			criteria2.andEmployeeNameLike("%"+employeeName+"%");
		if(!"".equals(departName))
			criteria2.andDepartNameLike("%"+departName+"%");
		int totalrecords =SlianoaEmployeeExMapper.countByExample(example2);
		List<EmployeeEx> stlist = SlianoaEmployeeExMapper.selectByExample(example);
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date startdate=df.parse(start);
		Date enddate=df.parse(end);
		int days = (int) ((enddate.getTime()-startdate.getTime()) / (1000 * 60 * 60 * 24));
		int weekend=0;
		Date temp=startdate;
		for(int i=0;i<days;i++){
			temp=com.slianOAsys.service.utils.DateHandler.addDay(temp,1);
			if(com.slianOAsys.service.utils.DateHandler.isWeekday(temp)){
				weekend++;
			}
		}
		Map<String, Object> map = new HashMap<String, Object>();	
		map.put("total", totalrecords);
		if (totalrecords % pageSize == 0)
			map.put("totalPages", totalrecords / pageSize);
		else
			map.put("totalPages", totalrecords / pageSize + 1);
		
		for(int i=0;i<stlist.size();i++){
			
			Date start1= stlist.get(i).getstartTime();
			Date end1= stlist.get(i).getendTime();
			SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
			String start2=sdf.format(start1);
			String end2=sdf.format(end1);
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("starttime"+start2);
			System.out.println("endtime"+end2);
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
			Date starttime=com.slianOAsys.service.utils.DateHandler.strToDate(start2,"hh:mm:ss");
			Date endtime=com.slianOAsys.service.utils.DateHandler.strToDate(end2,"hh:mm:ss");
			long between=endtime.getTime()-starttime.getTime();
			int hour = (int)(between/(1000 * 60 * 60));
			int minute=(int) ((between / (60 * 1000))- hour * 60);
			float shouldworktime=0;
			shouldworktime=hour+minute/60;
			stlist.get(i).setshouldworktime(shouldworktime*(days-weekend));
			
			stlist.get(i).settotalday(days);
			stlist.get(i).setworkday(days-weekend);
			NumberFormat nFormat=NumberFormat.getNumberInstance(); 
			nFormat.setMaximumFractionDigits(2);//设置小数点后面位数为
			float workhour=stlist.get(i).getworkHours();
			float workHour=Float.parseFloat(nFormat.format(workhour));
			stlist.get(i).setworkHours(workHour);
		}
		JsonConfig config = new JsonConfig();
		config.setIgnoreDefaultExcludes(false);
		config.registerJsonValueProcessor(Date.class,
				new DateJsonValueProcessor("HH:mm:ss"));
		JSONArray o =JSONArray.fromObject(stlist, config);	
		map.put("rows", o);
		return map;	
	}
	
	@Override
	public String update(SlianoaAttendance attendance) {
		if (SlianoaAttendanceMapper.updateByPrimaryKeySelective(attendance) < 1){
			return "修改失败";
		}else{
			return "修改成功";
		}
	}

	@Override
	public int delete1(int attendanceid) {
		return SlianoaAttendanceMapper.deleteByPrimaryKey(attendanceid);
	}

}