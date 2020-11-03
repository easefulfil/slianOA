package com.sliansoft.slianOA.mobile.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sliansoft.slianOA.dataaccess.dao.OaAttendanceMapper;
import com.sliansoft.slianOA.dataaccess.dao.OaAttendanceRuleMapper;
import com.sliansoft.slianOA.dataaccess.model.OaAttendance;
import com.sliansoft.slianOA.dataaccess.model.OaAttendanceRule;
import com.sliansoft.slianOA.dataaccess.model.OaAttendanceRuleExample;
import com.sliansoft.slianOA.service.OaAttendanceService;
import com.sliansoft.slianOA.service.utils.Const;
import com.sliansoft.slianOA.service.utils.DateHandler;

/*
 * 该类负责向oa_attendance表中插入该月每位员工应有的考勤记录
 */
@Controller 
@RequestMapping(value="/InitOaAttendance")
public class InitOaAttendance {

	@Autowired
	private OaAttendanceMapper attendanceMapper;
	@Autowired
	private OaAttendanceRuleMapper ruleMapper;
	@Autowired
	private OaAttendanceService oaAttendanceService;
	
	private List<OaAttendanceRule> listrule;
	
	public void test(){
		System.out.println("testing ......");
	}
	
	@RequestMapping(value="/deleteForm.do")
	public @ResponseBody Object deleteForm(HttpServletRequest req){
		String ids = req.getParameter("ids");
		String[] Ids = ids.split(",");
		String status = "success";
		for(String id: Ids){
			int ruleId = Integer.parseInt(ids);

			System.out.println("删除：" + ruleId);
			
			status = oaAttendanceService.deleteById(id);
		}
		return status;
	}
	// 根据考勤规则的变动修改考勤表,针对一条考勤规则的变动
	@RequestMapping(value="/updateForm.do")
	public @ResponseBody Object updateAttendance(HttpServletRequest req){
		String ids = req.getParameter("ids");
		String[] Ids = ids.split(",");
		//String ids = req.getParameter("ids");
		Date resDate = new Date();

		int totalRecords = 0; // 记录更新的总条数
		

			// 先删除更新日期之后的所有考勤记录
			for(String id: Ids){
				int ruleId = Integer.parseInt(ids);
	
				System.out.println("更新：" + ruleId);
				OaAttendanceRule rule = ruleMapper.selectByPrimaryKey(ruleId);
				
				String employeeIds = rule.getViewEmployeeIds();
				List<Integer> listids = getList(employeeIds); //  将rule中的viewEmployeeIds转成list
				List<String> listdates = getDates(rule); // 获取应当签到的天数
				
				OaAttendance temp = new OaAttendance();
				
				// 删除本条考勤对应的未使用的考勤记录
				oaAttendanceService.deleteById(id);
				
				// 更新insert
				for (String date : listdates) {
					// 只更新修改考勤规则后一天以后的考勤记录
					if(DateHandler.strToDate(date, "yyyy-MM-dd").compareTo(resDate) < 0){
						System.out.println("不要更新："+date);
					}else{
						totalRecords++;
						temp.setAttendanceRuleId(ruleId);
						System.out.println("rule_id:" + rule.getAttendanceRuleId());
	
						temp.setSignDate(DateHandler.strToDate(date, "yy-MM-dd"));
						for (Integer tid : listids) {
							temp.setCreator(tid);
							int oid = (Integer) Const.EMPLOYEE_MAP.get(tid).get("orgId");
							System.out.println("部门："+oid);
							temp.setAccessGroup(oid);
							attendanceMapper.insertSelective(temp);
						}
					}
				}
			}

		return totalRecords;
		
	}
	
	@RequestMapping(value="/test.do")
	public @ResponseBody void initAttendance(){
		System.out.println("开始测试、。。。。。。。");
		
//		//获取unattenddays
//		OaUnattendDaysExample example2 = new OaUnattendDaysExample();
//		example2.setOrderByClause(" attendance_rule_id ASC "); // 升序排列
//		listUnattendDays = unattendDaysMapper.selectByExample(example2);
		
		//获取attendanceRule
		OaAttendanceRuleExample example3 = new OaAttendanceRuleExample();
		example3.setOrderByClause(" attendance_rule_id ASC ");
		example3.or().andStatusEqualTo("启用").andViewEmployeeIdsIsNotNull().andViewEmployeeIdsNotEqualTo("");
		listrule = ruleMapper.selectByExample(example3);
		
		for(OaAttendanceRule rule : listrule){
			String ids = rule.getViewEmployeeIds();
			List<Integer> listids = getList(ids);
			List<String> listdates = getDates(rule);
			OaAttendance temp = new OaAttendance();
			
			for (String date : listdates) {
				temp.setAttendanceRuleId(rule.getAttendanceRuleId());
				System.out.println("rule_id:" + rule.getAttendanceRuleId());

				temp.setSignDate(DateHandler.strToDate(date, "yy-MM-dd"));
				for (Integer id : listids) {
					temp.setCreator(id);
					int oid = (Integer) Const.EMPLOYEE_MAP.get(id).get("orgId");
					System.out.println("部门："+oid);
					temp.setAccessGroup(oid);
					attendanceMapper.insertSelective(temp);
				}
			}
		}
	}
	
	// 将rule中的viewEmployeeIds转成list
	public List<Integer> getList(String ids){
		List<Integer> listids = new ArrayList<>();
		String temp[] = ids.split(",");
		for(int i=0; i<temp.length;i++){
			int a = Integer.parseInt(temp[i]);
			if(a>10000){
				listids.add(a-100000); System.out.println("加入员工列表："+(a-100000));
			}
		}
		return listids;
	}
	
	// 获取某一个规则的应有的天数日期，从当前天开始计算
	public List<String> getDates(OaAttendanceRule rule){
		
		List<String> listDates = new ArrayList<>();	
		
		if(rule.getUnattendDays() == null){
			rule.setUnattendDays("");
		}
		
		String temp[] = rule.getUnattendDays().split(",");
		int size = getSize();
		Date d = new Date();
		 
		String resDate = DateHandler.dateToStr(d, "yyyy-MM-dd");
		//用于测试的日期 TODO
		//String resDate = "2017-04-01";
		System.out.println(temp.length);
		// 获取当前考勤规则，计算从本天开始，本月的考勤日期
		for(int i=0; i<size; i++){
			String date = DateHandler.addDay(resDate, i);
			System.out.println("date : "+date);
			for(String s:temp){
				if( !s.equals(date) && isNormal(rule, date)){
					listDates.add(date);
					System.out.println("这一天要上班："+date);
					break;
				}
			}
		}
		return listDates;
	}
	
//	// 判断是否是除去的天 
//	public Boolean isUnattendanceDay(int id, String date){
//		
//		int flag = 0;
//		
//		for(OaUnattendDays day : listUnattendDays){
//			//if(day.getAttendanceRuleId())
//			if(day.getAttendanceRuleId() == id){
//				flag = 1;
//				System.out.println("不参加的天测试："+DateHandler.dateToStr(day.getUnattendDay(), "yyyy-MM-dd"));
//				if(date.equals(DateHandler.dateToStr(day.getUnattendDay(), "yyyy-MM-dd"))){
//					return false;
//				}
//			}else{
//				if(flag == 1)
//					break;
//			}
//		}
//		
//		return true;
//	}
	
	public boolean isNormal(OaAttendanceRule rule,String date){
		
		int week = getWeek(date);
		int flag = 0;
		
				System.out.println("参加的week是星期几: "+week);
				switch(week){
				case 1:
					if(rule.getIsMonday() == 0) return false;
					break;
				case 2:
					if(rule.getIsTuesdany() == 0) return false;
					break;
				case 3:
					if(rule.getIsWednesday() == 0) return false;
					break;
				case 4:
					if(rule.getIsThursday() == 0) return false;
					break;
				case 5:
					if(rule.getIsFriday() == 0) return false;
					break;
				case 6:
					if(rule.getIsSaturday() == 0) {System.out.println("星期六亚~~~~~");return false;}
					break;
				case 7:
					if(rule.getIsSunday() == 0) {System.out.println("星期日亚~~~~~");return false;}
					break;
				default:
					break;
				}
	
		return true;
	}
	
	// 获取本月有几天
	public int getSize(){
		Calendar cal = Calendar.getInstance();
		int size = cal.getActualMaximum(cal.DAY_OF_MONTH);
		int now = cal.get(Calendar.DAY_OF_MONTH);
		System.out.println("本月共有："+size);
		System.out.println("本月过了："+now);
		System.out.println("本月还剩："+(size-now+1));
		return size-now+1;
	}
	
	// 获取星期几
	public int getWeek(String date){
		Date d = DateHandler.strToDate(date, "yy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		int week = cal.get(Calendar.DAY_OF_WEEK)-1;
		if(week == 0){
			week = 7;
		}
		
		return week;
	}
}
