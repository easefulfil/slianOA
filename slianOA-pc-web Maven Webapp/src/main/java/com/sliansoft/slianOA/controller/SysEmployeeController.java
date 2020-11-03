package com.sliansoft.slianOA.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONUtils;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sliansoft.slianOA.dataaccess.dao.SysAuthenticationMapper;
import com.sliansoft.slianOA.dataaccess.dao.SysOrganizationStructureMapper;
import com.sliansoft.slianOA.dataaccess.dao.SysUserMapper;
import com.sliansoft.slianOA.dataaccess.model.SysEmployee;
import com.sliansoft.slianOA.service.AuthenticationInfoService;
import com.sliansoft.slianOA.service.EmployeeService;
import com.sliansoft.slianOA.service.OrganizationStructureService;
import com.sliansoft.slianOA.service.UsersService;
import com.sliansoft.slianOA.service.httpModels.HttpEmployee;
import com.sliansoft.slianOA.service.httpModels.HttpJson;
import com.sliansoft.slianOA.service.utils.Const;
import com.sliansoft.slianOA.service.utils.DateHandler;
import com.sliansoft.slianOA.service.utils.DateJsonValueProcessor;
import com.sliansoft.slianOA.service.utils.DateMorpherEx;
import com.sliansoft.slianOA.utils.SysConst;
import com.sliansoft.wechat.WeChat;

//import antlr.ParserSharedInputState;

@Controller
@RequestMapping(value="/employee")
 
public class SysEmployeeController {

	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private DataSource dataSourceWebeconitl;
	
	@Autowired
	private UsersService usersService;
	
	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Autowired
	private AuthenticationInfoService authenticationService;
	@Autowired
	private SysAuthenticationMapper sysAuthenticationMapper;
	
	@Autowired
	private OrganizationStructureService OrganizationStructureService;
	
	@Autowired
	private SysOrganizationStructureMapper sysOrganizationStructureMapper;
	
	
	
	@RequestMapping(value = "/listEmployeeTree.do")
	public @ResponseBody Object listOSTreeNodes(){ 
		
		//List<OrganizationStructure> list= organizationStructureService.getTreegrid(id);
		
		JsonConfig config = new JsonConfig();
		config.setIgnoreDefaultExcludes(false);
		config.registerJsonValueProcessor(Date.class,
				new DateJsonValueProcessor("yyyy-MM-dd"));
		
		JSONArray ja = JSONArray.fromObject(SysConst.EMPLOYEE_TREE,config);//.getOSTreeNodes()
		System.out.println("员工树"+SysConst.EMPLOYEE_TREE);
		System.out.println("员工array"+ja);
		return  ja;// SysConst.EMPLOYEE_TREE.getOSTreeNodes();
		
	}
	
	@RequestMapping(value = "/listProject.do")
	public @ResponseBody Object listOSListNodes(){ 
		
		//List<OrganizationStructure> list= organizationStructureService.getTreegrid(id);
		
		JsonConfig config = new JsonConfig();
		config.setIgnoreDefaultExcludes(false);
		config.registerJsonValueProcessor(Date.class,
				new DateJsonValueProcessor("yyyy-MM-dd"));
		
		JSONArray ja = JSONArray.fromObject(SysConst.PROJECT_EMPLOYEE_MAP,config);//.getOSTreeNodes()
		return  ja;// SysConst.EMPLOYEE_TREE.getOSTreeNodes();
	}
	
	
	@RequestMapping(value = "/syncEmployeeData.do")
	public @ResponseBody Object syncEmployeeData(HttpServletRequest req) {
		
		String userIds = req.getParameter("userIds");
		System.out.println("userIDs:"+userIds);
		String[] ids= userIds.split(",");
		
		HttpJson hjResult = new HttpJson();
		
		List<String> useridList = null;
		
		//如果同步的userid为空，同步所有的员工数据
		if(StringUtils.isEmpty(userIds))
			useridList = employeeService.getWechatAccounts();
		
		else{
			useridList = Arrays.asList(ids);
		}
		
		for (String userid : useridList) {
			
			hjResult.setSuccess(true);
			hjResult.setMsg(userid + this._doSyncEmployeeData(userid) + ";");
			
		}
		return hjResult;
        
   }
	
	private String _doSyncEmployeeData(String userid){
		System.out.println("userid112:"+userid);
		JSONObject joUser = WeChat.getUser(userid);
		
		if(joUser == null)
			return "未找到该微信企业号账号对应的员工，同步失败";
		else{
			
			SysEmployee e = new SysEmployee();
			e.setWechatAccount(userid);
			
//			if(joUser.containsKey("department"))
//				e.setWechatDepartment(joUser.getString("department"));
			
			if(joUser.containsKey("weixinid"))
				e.setWechatId(joUser.getString("weixinid"));
			
			if(joUser.containsKey("avatar"))
				e.setWechatPictureUrl(joUser.getString("avatar"));
			
			if(joUser.containsKey("name"))
				e.setWeixinName(joUser.getString("name"));
			
			return employeeService.updateByWechatAccount(e);
		}
			

	}
	
	@RequestMapping(value = "/getYouEmployeeTree.do")
	public @ResponseBody Object getYouEmployeeTree(HttpServletRequest req, SysEmployee sysEmployee) {
		
		JsonConfig config = new JsonConfig();
		config.setIgnoreDefaultExcludes(false);
		config.registerJsonValueProcessor(Date.class,
				new DateJsonValueProcessor("yyyy-MM-dd"));
//		SysEmployee sysEmployee =(SysEmployee) session.getAttribute("employee");
	    System.out.println("员工的信息："+sysEmployee.getEmployeeId()+sysEmployee.getAccountNumber());
 		return  JSONArray.fromObject(employeeService.getYouEmployeesContainOrganiztion(),config);
	}
	
	@RequestMapping(value = "/getEmployeeTree.do")
	public @ResponseBody Object getEmployeeTree(HttpServletRequest req, SysEmployee sysEmployee) {
		
		JsonConfig config = new JsonConfig();
		config.setIgnoreDefaultExcludes(false);
		config.registerJsonValueProcessor(Date.class,
				new DateJsonValueProcessor("yyyy-MM-dd"));
	
 		return  JSONArray.fromObject(employeeService.getEmployeesContainOrganiztion(),config);
	}
	
	@RequestMapping(value = "/listAll.do")
	public @ResponseBody Object listAll(HttpServletRequest req, SysEmployee sysEmployee) {
		
		JsonConfig config = new JsonConfig();
		config.setIgnoreDefaultExcludes(false);
		config.registerJsonValueProcessor(Date.class,
				new DateJsonValueProcessor("yyyy-MM-dd"));
	
 		return  JSONArray.fromObject(employeeService.getEmployees(),config);
	}
	/**
	 * employeeName(dempartMentName)
	 * @param req
	 * @param sysEmployee
	 * @return
	 */
	@RequestMapping(value = "/listIdName.do")
	public @ResponseBody Object listIdName(HttpServletRequest req, SysEmployee sysEmployee) {
		List<HttpEmployee> httpEmployees = employeeService.listIdNameEmployees();
		JSONArray jsonArray = new JSONArray();
		for(HttpEmployee httpEmployee : httpEmployees){
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("employeeId", httpEmployee.getEmployeeId());
			jsonObject.put("employeeNameDepartment", httpEmployee.getEmployeeName()+"("+Const.ORGANIZATIONSTRUCTURE_TREE.getNode(httpEmployee.getEmployeeDepartment()).getName()+")");
			jsonArray.add(jsonObject);
		}
 		return  jsonArray;
	}
	
	/**
	 * employeeName(dempartMentName)
	 * @param req
	 * @param sysEmployee
	 * @return
	 */
	@RequestMapping(value = "/listEmployeeIdName.do")
	public @ResponseBody Object listEmloyeeIdName(HttpServletRequest req, SysEmployee sysEmployee) {
		List<HttpEmployee> httpEmployees = employeeService.listIdNameEmployees();
		JSONArray jsonArray = new JSONArray();
		for(HttpEmployee httpEmployee : httpEmployees){
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("employeeId", httpEmployee.getEmployeeId());
			jsonObject.put("employeeName", httpEmployee.getEmployeeName());
			jsonArray.add(jsonObject);
		}
 		return  jsonArray;
	}
	
	@RequestMapping(value = "/list.do")
	public @ResponseBody Object list(HttpServletRequest req, HttpEmployee employee) {
		Integer pageSize = Integer.parseInt(req.getParameter("rows"));
		Integer pageNow = Integer.parseInt(req.getParameter("page"));
		Map<String, Object> map = employeeService.getEmployeeByPage(employee,
				pageSize, pageNow);
 		return JSONObject.fromObject(map);
	}
	@RequestMapping(value = "/listInfo.do")
	public @ResponseBody Object listInfo(HttpServletRequest req, HttpEmployee employee) {
		Integer pageSize = Integer.parseInt(req.getParameter("rows"));
		Integer pageNow = Integer.parseInt(req.getParameter("page"));
		Map<String, Object> map = employeeService.getEmployeeByPage(employee,
				pageSize, pageNow);
 		return JSONObject.fromObject(map);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/saveInfo.do")
	public @ResponseBody
	String saveInfo(HttpServletRequest req) {
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// String deleted = req.getParameter("deleted");
		String inserted = req.getParameter("inserted");
		String updated = req.getParameter("updated");

			JSONUtils.getMorpherRegistry().registerMorpher(  
            new DateMorpherEx(new String[] { "yyyy-MM-dd" },(Date)null));
			
	if (inserted != null) {
		 
		inserted = "["+inserted+"]";
		
		JSONArray jsonArray = JSONArray.fromObject(inserted);
		
		List<SysEmployee> listInserted = (List<SysEmployee>) JSONArray
				.toCollection(jsonArray, SysEmployee.class);
		
		for (SysEmployee sysEmployee : listInserted) {
			sysEmployee.setCreateTime(new Date());
			return employeeService.insert(sysEmployee);
		}
	}

	if (updated != null) {
	 
		JSONArray jsonArray = JSONArray.fromObject(updated);
		List<SysEmployee> listUpdated = (List<SysEmployee>) JSONArray
				.toCollection(jsonArray, SysEmployee.class);
		for (SysEmployee sysEmployee : listUpdated) {
			sysEmployee.setCreateTime(new Date());
			return employeeService.update(sysEmployee);
		}
	}			
		
		


		return "false";
	} 
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/save.do")
	public @ResponseBody
	String save(HttpServletRequest req) {
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// String deleted = req.getParameter("deleted");
		String inserted = req.getParameter("inserted");
		String updated = req.getParameter("updated");
		
		JSONUtils.getMorpherRegistry().deregisterMorpher(JSONUtils.getMorpherRegistry().getMorpherFor(Date.class));
		JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpherEx(new String[]{"yyyy-MM-dd","yyyy-MM-dd HH:mm:ss"},(Date) null));
		
//		System.out.println("dd"+updated);
//			JSONUtils.getMorpherRegistry().registerMorpher(  
//            new DateMorpherEx(new String[] { "yyyy-MM-dd" },(Date)null));
	if (inserted != null) {
		 
		JSONArray jsonArray = JSONArray.fromObject(inserted);
		List<SysEmployee> listInserted = (List<SysEmployee>) JSONArray
				.toCollection(jsonArray, SysEmployee.class);
		for (SysEmployee sysEmployee : listInserted) {
			sysEmployee.setCreateTime(new Date());

//			if(!insertWebeconitl(employee))
//				return "2008系统员工编号已存在";
			return employeeService.insert(sysEmployee);
		}
	}

	if (updated != null) {
		if(updated.indexOf("[") != 0){
			updated = "["+updated+"]";
		}
		
	
		
		JSONArray jsonArray = JSONArray.fromObject(updated); 
		List<SysEmployee> listUpdated = (List<SysEmployee>) JSONArray
				.toCollection(jsonArray, SysEmployee.class);
		for (SysEmployee sysEmployee : listUpdated) {
			sysEmployee.setCreateTime(new Date());
//			if(!updateWebeconitl(employee))
//				return "2008系统员工编号已存在";
			return employeeService.update(sysEmployee);
		}
	}			
	
		return "false";
	} 
	
	@RequestMapping(value="/getContent.do")
	public @ResponseBody Object getContent(HttpServletRequest req){
		
		String employeeStringId = req.getParameter("employeeId");
		int employeeIntId = Integer.parseInt(employeeStringId);
		SysEmployee sysEmployee = employeeService.getEmployeeById(employeeIntId);
		
		JsonConfig config = new JsonConfig();
		config.setIgnoreDefaultExcludes(false);
		config.registerJsonValueProcessor(Date.class,
				new DateJsonValueProcessor("yyyy-MM-dd"));
		
		return JSONObject.fromObject(sysEmployee,config);
	}
	
	 
	@RequestMapping(value = "/delete.do")
	public @ResponseBody String delete(HttpServletRequest req) {
		String ids = req.getParameter("ids"); 
		String[] cIds= ids.split(",");
		String s = employeeService.deleteEmpById(cIds);   
		
		
        return s;
        
   }
	
	@RequestMapping(value = "/newEmployee.do")
	public @ResponseBody
	Object newEmployee(HttpServletRequest req, HttpServletResponse res) throws UnsupportedEncodingException {

		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		String type =   java.net.URLDecoder.decode(req.getParameter("fileType"), "UTF-8"); 
		
//		String type = req.getParameter("fileType");
		
//		if(StringUtils.isEmpty(type));
//			return null;
		SysEmployee odd = new SysEmployee();
//		odd.setType(type);
		
		SysEmployee od = employeeService.insertEmployee(odd);
System.out.println("这里是测试是否获得头偶素ID： "+ od.getEmployeeId());
		// // 处理json数据中的日期格式
		JsonConfig config = new JsonConfig();
		config.setIgnoreDefaultExcludes(false);
		config.registerJsonValueProcessor(Date.class,
				new DateJsonValueProcessor("yyyy-MM-dd"));// HH:mm:ss
		//
		return JSONObject.fromObject(od, config);

	}
      
	  @RequestMapping(value = "/exportExcel.do")
	  	public void exportExcel(HttpServletRequest request,HttpServletResponse response ) {
//			String scheduleMonth = request.getParameter("scheduleMonth");
			String keys = request.getParameter("keys");
			System.out.println(keys);
			String excelFileName;
			try {
				excelFileName = new String(
						(DateHandler.dateToStr(new Date(), "yyyyMMddhhmmss") + ".xls").getBytes("gb2312"), "ISO8859-1");
				response.setContentType("octets/stream");
				response.addHeader("Content-Disposition", "attachment;filename=" + excelFileName);
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
			JSONUtils.getMorpherRegistry()
					.registerMorpher(new DateMorpherEx(new String[] { "yyyy-MM-dd HH:mm:ss" }, (Date) null));
			try {
				OutputStream out = response.getOutputStream();
				employeeService.exportExcel(keys, out);
				out.close();
				System.out.println("excel out");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	  	}
	  
//	  @RequestMapping(value = "/listIdName.do")
//		public @ResponseBody Object listName(HttpServletRequest req, SysEmployee sysEmployee) {
//			List<HttpEmployee> httpEmployees = employeeService.listIdNameEmployees();
//			JSONArray jsonArray = new JSONArray();
//			for(HttpEmployee httpEmployee : httpEmployees){
//				JSONObject jsonObject = new JSONObject();
//				jsonObject.put("employeeId", httpEmployee.getEmployeeId());
//				jsonObject.put("employeeName", httpEmployee.getEmployeeName()+"("+Const.ORGANIZATIONSTRUCTURE_TREE.getNode(httpEmployee.getEmployeeDepartment()).getName()+")");
//				jsonArray.add(jsonObject);
//			}
//	 		return  jsonArray;
//		}


}
