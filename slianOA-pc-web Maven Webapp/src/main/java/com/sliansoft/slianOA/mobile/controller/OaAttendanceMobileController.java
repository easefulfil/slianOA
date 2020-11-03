package com.sliansoft.slianOA.mobile.controller;

import java.net.URLDecoder;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sliansoft.slianOA.dataaccess.model.SysBasicDataSet;
import com.sliansoft.slianOA.dataaccess.model.SysEmployee;
import com.sliansoft.slianOA.dataaccess.model.OaAttendance;
import com.sliansoft.slianOA.service.EmployeeService;
import com.sliansoft.slianOA.service.OaAttendanceService;
import com.sliansoft.slianOA.service.utils.BasicDataSetTreeNode;
import com.sliansoft.slianOA.service.utils.DateHandler;
import com.sliansoft.slianOA.service.utils.DateJsonValueProcessor;
import com.sliansoft.slianOA.utils.SysConst;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

@Controller
@RequestMapping(value="/mobile-ajax/auth/oaAttendance")
public class OaAttendanceMobileController {

	
	@Autowired
	private OaAttendanceService oaAttendanceService;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private HttpSession session;
	/*
	 * 签到
	 */
	@RequestMapping(value="/signIn.do")
	public @ResponseBody Object signIn(HttpServletRequest req){
		
		String address = req.getParameter("signinAddress");
		//String address = "沈阳";
		double latitude = Double.parseDouble(req.getParameter("signinLatitude"));
		//double latitude = 111.1;
		double longitude = Double.parseDouble(req.getParameter("signinLongitude"));
		//double longitude = 22.22;
		String time = req.getParameter("signinTime");
		Date signinTime = DateHandler.strToDate(time, "yy-MM-dd HH:mm");
		String remark = req.getParameter("signinRemark");
		//String remark = "jljksdkjljl";
		String temp = ""; // 记录在考勤记录中的状态
		// 处理中文乱码
		try{
			address = URLDecoder.decode(address, "utf-8");
			remark = URLDecoder.decode(remark,"utf-8");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println(address+latitude+
				longitude+remark);
		
		// 更新签到记录
		OaAttendance a = new OaAttendance();
		a.setSigninAddress(address);
		a.setSigninLatitude(latitude);
		a.setSigninLongitude(longitude);
		a.setSigninTime(signinTime);
		a.setSigninRemark(remark);
		//a.setApproval("未读");
		int id = ((SysEmployee)session.getAttribute("employee")).getEmployeeId();
		a.setCreator(id);
		// 判断签到状态
		String status = "";
		status = oaAttendanceService.getStatus("signIn", a); //System.out.println("签到状态："+status);
		if(status.indexOf("异常")!=-1){ // 判断状态是否是异常的
			temp = "异常"; // 包含异常状态，时间异常、位置异常、或两者皆异常
		}else{
			temp = status;
		}
		System.out.println("考勤记录状态："+temp);
		a.setSigninStatus(temp); // TODO
		// 更改当天该员工签到表记录
		String res = oaAttendanceService.update(a);
		return status;
	}
	
	/*
	 * 签退
	 */
	@RequestMapping(value="/signOut.do")
	public @ResponseBody Object signOut(HttpServletRequest req){
		
		String address = req.getParameter("signoutAddress");
		double latitude = Double.parseDouble(req.getParameter("signoutLatitude"));
		double longitude = Double.parseDouble(req.getParameter("signoutLongitude"));
		String time = req.getParameter("signoutTime");
		Date signinTime = DateHandler.strToDate(time, "yy-MM-dd HH:mm");
		String remark = req.getParameter("signoutRemark");
		
		// 处理中文乱码
		try{
			address = URLDecoder.decode(address, "utf-8");
			remark = URLDecoder.decode(remark, "utf-8");
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(address+latitude+
				longitude+remark);
		
		// 更新签退记录
		OaAttendance a = new OaAttendance();
		a.setSignoutAddress(address);
		a.setSignoutLatitude(latitude);
		a.setSignoutLongitude(longitude);
		a.setSignoutTime(signinTime);
		a.setSignoutRemark(remark);
		int id = ((SysEmployee)session.getAttribute("employee")).getEmployeeId();
		a.setCreator(id);
		// 判断签到状态
		String status = "";
		status = oaAttendanceService.getStatus("signOut", a); System.out.println("签到状态："+status);
		a.setSignoutStatus(status); // TODO
	
		String res = oaAttendanceService.update(a);
		return status;
	}
	
	/*
	 * 获取当天的签到信息
	 */
	@RequestMapping(value="/getContent.do")
	public @ResponseBody Object getContent(HttpServletRequest req){
		
		int id = ((SysEmployee)session.getAttribute("employee")).getEmployeeId();
		System.out.println("id:"+id);
		// 处理json数据中的日期格式
		JsonConfig config = new JsonConfig();
		config.setIgnoreDefaultExcludes(false);
		config.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd HH:mm"));
				//System.out.println(oaAttendanceService.getByEmployeeIdAndDate(id).getSigninAddress());
		if(oaAttendanceService.getByEmployeeIdAndDate(id) == null){
			return "null";
		}
		return JSONObject.fromObject(oaAttendanceService.getByEmployeeIdAndDate(id),config);
	}
	
	/*
	 * 查询考勤记录
	 */
	@RequestMapping(value="/attendance/list.do")
	public @ResponseBody Object getBySearch(HttpServletRequest req){
		
		String keys = req.getParameter("keys");
		int pageNow = Integer.parseInt(req.getParameter("pageNow"));
		String wechatAccount = req.getParameter("wechatAccount");
		int pageSize = 45;
		
		// 获取员工ID
		SysEmployee sysEmployee = (SysEmployee) session.getAttribute("employee");
		int id = sysEmployee.getEmployeeId();
		
		// 将keys中的日期转成startDate和endDate
		JSONObject obj = JSONObject.fromObject(keys);
		// 将员工ID存入JSON中
		obj.put("creator", id);
		
		String nkeys = obj.toString();
		System.out.println("nkeys"+nkeys);
		// 处理json数据中的日期格式
		JsonConfig config = new JsonConfig();
		config.setIgnoreDefaultExcludes(false);
		config.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd HH:mm"));
				
		return JSONObject.fromObject(oaAttendanceService.getByPage(nkeys, pageSize, pageNow),config);
	}
	
	

	@RequestMapping(value = "/cancelAttendance.do")
	public @ResponseBody Object cancelAttendance(HttpServletRequest req){ 
	
		SysEmployee sysEmployee = (SysEmployee) session.getAttribute("employee");
		int id = sysEmployee.getEmployeeId();
		String type = req.getParameter("type");
		
		return oaAttendanceService.cancelStatus(type,id);

	}
	
	
	
	@RequestMapping(value = "/getBasicData.do")
	public @ResponseBody JSONArray getBasicDataSetbyPId(){ 
		
		String parentId = "547";
		if(StringUtils.isEmpty(parentId))
			return null;
		
		List<BasicDataSetTreeNode> listBDS =   SysConst.BASICDATASET_TREE.getLeafNodes(SysConst.BASICDATASET_TREE.getNode(Integer.parseInt(parentId)));
		
		for (BasicDataSetTreeNode x : listBDS){
			System.out.println(x.getId());
		}
		
		//按名称进行排序
		Collections.sort(listBDS, new Comparator<SysBasicDataSet>() {
			public int compare(SysBasicDataSet arg0, SysBasicDataSet arg1) {
				return arg0.getEnglishName().compareTo(arg1.getEnglishName());
			}
		});
		
		JSONArray array = new JSONArray();
		for (SysBasicDataSet bds : listBDS) {
			JSONObject json =new JSONObject();
			json.put("id", bds.getBasicDataId());
			json.put("name", bds.getChineseName());//bds.getEnglishName()+" || "+
			array.add(json);
		}
		
		return array;
	}
	
}
