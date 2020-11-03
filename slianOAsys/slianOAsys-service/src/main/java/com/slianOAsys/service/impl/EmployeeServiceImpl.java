package com.slianOAsys.service.impl;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.slianOAsys.dao.SlianoaAttendanceMapper;
import com.slianOAsys.dao.ex.SlianoaAttendanceExMapper;
import com.slianOAsys.dao.ex.SlianoaEmployeeExMapper;
import com.slianOAsys.model.ex.DateAndStatus;
import com.slianOAsys.model.ex.EmployeeEx;
import com.slianOAsys.model.ex.EmployeeExExample;
import com.slianOAsys.page.Page;
import com.slianOAsys.service.EmployeeService;
import com.slianOAsys.service.utils.DateJsonValueProcessor;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private SlianoaAttendanceMapper SlianoaAttendanceMapper;
	@Autowired
	private SlianoaAttendanceExMapper SlianoaAttendanceExMapper;
	@Autowired
	private SlianoaEmployeeExMapper SlianoaEmployeeExMapper;
	
	@Override
	public Object getAttendanceMonth1(String className,String start,String end,String employeeName,String departName,Integer pageSize, Integer pageIndex) throws ParseException {
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
	public Object getAttendanceMonth(String className, String start, String end, String employeeName, String departName, Integer pageSize,
			Integer pageIndex) throws ParseException {
		
		EmployeeExExample example = new EmployeeExExample();
		com.slianOAsys.model.ex.EmployeeExExample.Criteria criteria = example.createCriteria();
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
		
		List<EmployeeEx> list1=SlianoaEmployeeExMapper.selectALL(example);
		Date d1=list1.get(0).getstartTime();
		Date d2=list1.get(0).getendTime();
		List<EmployeeEx> list2=new ArrayList();
		list2.add(list1.get(0));
		for(int i=0;i<list1.size();i++){
			for(int j=0;j<i;j++){
				if(list1.get(j).getEmployeeId()!=list1.get(i).getEmployeeId()){
					if(j+1==i){
					list2.add(list1.get(i));
					}
					else{
						continue;
					}
				}else{
					break;
				}
			}
			
		}
		int latecount=0;
		int beforecount=0;
		float workhour=0;
		int latetime=0;
		int beforetime=0;
		for(int i=0;i<list2.size();i++){
			List<DateAndStatus> dateAndStatus=new  ArrayList();
			latecount=0;
			beforecount=0;
			workhour=0;
			latetime=0;
			beforetime=0;
			for(int j=0;j<list1.size();j++){
				if(list2.get(i).getEmployeeId()==list1.get(j).getEmployeeId()){
					DateAndStatus dateAndStatuses=new DateAndStatus();
					dateAndStatuses.setattendanceTime(list1.get(j).getattendanceTime());
					dateAndStatuses.setattendanceTotalStatus(list1.get(j).getattendanceTotalStatus());
					dateAndStatus.add(dateAndStatuses);
					if(list1.get(j).getattendanceSignstatus().equals("迟到")){
						latecount+=1;
						Date a=list1.get(j).getattendanceSigntime();
						Date b=list1.get(j).getstartTime();
						long diff = a.getTime() - b.getTime();//这样得到的差值是微秒级别  
					    long days = diff / (1000 * 60 * 60 * 24);  
					    long hours = (diff-days*(1000 * 60 * 60 * 24))/(1000* 60 * 60);  
					    int minutes = (int)(diff-days*(1000 * 60 * 60 * 24)-hours*(1000* 60 * 60))/(1000* 60);  
					    latetime+=minutes;
					}
					if(list1.get(j).getattendanceOffstatus().equals("早退")){
						beforecount+=1;
						Date a=list1.get(j).getendTime();
						Date b=list1.get(j).getattendanceOfftime();
						long diff = a.getTime() - b.getTime();//这样得到的差值是微秒级别  
					    long days = diff / (1000 * 60 * 60 * 24);  
					    long hours = (diff-days*(1000 * 60 * 60 * 24))/(1000* 60 * 60);  
					    int minutes = (int)(diff-days*(1000 * 60 * 60 * 24)-hours*(1000* 60 * 60))/(1000* 60);  
					    beforetime+=minutes;
					}
					workhour+=list1.get(j).getworkHour();
				}
			}
			list2.get(i).setDateAndStatus(dateAndStatus);
			list2.get(i).setactualworkday(dateAndStatus.size());
			list2.get(i).setlatecount(latecount);
			list2.get(i).setbeforecount(beforecount);
			list2.get(i).setworkHours(workhour);
			list2.get(i).setlatetime(latetime);
			list2.get(i).setbeforetime(beforetime);
			NumberFormat nFormat=NumberFormat.getNumberInstance(); 
			nFormat.setMaximumFractionDigits(2);//设置小数点后面位数为
			float workhour1=list2.get(i).getworkHours();
			float workHour2=Float.parseFloat(nFormat.format(workhour1));
			list2.get(i).setworkHours(workHour2);
		}
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date startdate=df.parse(start);
		Date enddate=df.parse(end);
		int days = (int) ((enddate.getTime()-startdate.getTime()) / (1000 * 60 * 60 * 24))+1;
		int weekend=0;
		Date temp=startdate;
		for(int i=0;i<days;i++){
			temp=com.slianOAsys.service.utils.DateHandler.addDay(temp,1);
			if(com.slianOAsys.service.utils.DateHandler.isWeekday(temp)){
				weekend++;
			}
		}
		
		for(int i=0;i<list2.size();i++){
			Date start1= list2.get(i).getstartTime();
			Date end1= list2.get(i).getendTime();
			SimpleDateFormat sdf = new SimpleDateFormat("HH:MM:SS");
			String start2=sdf.format(start1);
			String end2=sdf.format(end1);
			Date starttime=com.slianOAsys.service.utils.DateHandler.strToDate(start2,"HH:MM:SS");
			Date endtime=com.slianOAsys.service.utils.DateHandler.strToDate(end2,"HH:MM:SS");
			long between=endtime.getTime()-starttime.getTime();
			int hour = (int)(between/(1000 * 60 * 60));
			int minute=(int) ((between / (60 * 1000))- hour * 60);
			float shouldworktime=0;
			shouldworktime=hour+minute/60;
			list2.get(i).setshouldworktime(shouldworktime*(days-weekend));
			list2.get(i).settotalday(days);
			list2.get(i).setworkday(days-weekend);
		}
		Map<String, Object> map = new HashMap<String, Object>();		
		JsonConfig config = new JsonConfig();
		config.setIgnoreDefaultExcludes(false);
		config.registerJsonValueProcessor(Date.class,
				new DateJsonValueProcessor("HH:mm:ss"));
		JSONArray o =JSONArray.fromObject(list2, config);
		map.put("total", list2.size());
		map.put("rows", o);
		return map;	
	}
}
