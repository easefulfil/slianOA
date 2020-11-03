package com.sliansoft.slianOA.mobile.controller;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sliansoft.slianOA.dataaccess.model.OaMeetingTrain;
import com.sliansoft.slianOA.dataaccess.model.SysEmployee;
import com.sliansoft.slianOA.dataaccess.model.SysOrganizationStructure;
import com.sliansoft.slianOA.service.EmployeeService;
import com.sliansoft.slianOA.service.OrganizationStructureService;
import com.sliansoft.slianOA.service.httpModels.HttpEmployee;
import com.sliansoft.slianOA.service.utils.DateHandler;
import com.sliansoft.slianOA.service.utils.DateJsonValueProcessor;
import com.sliansoft.slianOA.service.utils.OrganizationStructureTreeNode;
import com.sliansoft.slianOA.utils.SysConst;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

@Controller
@RequestMapping(value="/mobile-ajax/auth/employee")
public class OaEmployeeMobileController {

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private OrganizationStructureService orgService;
	@Autowired
	private HttpSession session;
	
	
	/*
	 * 获取机构列表
	 */
	@RequestMapping(value="/organization.do")
	public @ResponseBody Object getOrganization(HttpServletRequest req){
		
//		List<OrganizationStructureTreeNode> treeNodes = 
//				SysConst.ORGANIZATIONSTRUCTURE_TREE.getOSTreeNodes();
//		List<OrganizationStructureTreeNode> resNodes = new ArrayList<>();
//		
//		for(OrganizationStructureTreeNode node: treeNodes){
//			if("1".equals(node.getSuperior())){
//				if(orgService.getChildOrganizationStructures(node.getId().toString())){
//					resNodes.add(node);
//				}
//			}
//		}
//		
		JsonConfig config = new JsonConfig();
		config.setIgnoreDefaultExcludes(false);
		config.registerJsonValueProcessor(Date.class,
				new DateJsonValueProcessor("yyyy-MM-dd"));
//		
//		return JSONArray.fromObject(resNodes,config);
		
//		List<OrganizationStructureTreeNode> employeeTree = SysConst.EMPLOYEE_TREE.getChildren();
//		List<String> array = new ArrayList<>();System.out.println(employeeTree.size());
//		for(int i=0; i<employeeTree.size();i++){
//			String name = employeeTree.get(i).getName();
//			int id = employeeTree.get(i).getId();
//			System.out.println(name+"+"+id+" "+i);
//			array.add("{\"id\":\""+id+"\",\"name\":\""+name+"\"}");
//		}
		return JSONArray.fromObject(SysConst.EMPLOYEE_TREE,config);
		
	}
	
	/*
	 * 获取当前人的姓名和部门和id
	 */
	@RequestMapping(value="/basicInfo.do")
	public @ResponseBody Object getBasicInfo(HttpServletRequest req){
		
		SysEmployee sysEmployee = (SysEmployee) session.getAttribute("employee");
		int id = sysEmployee.getEmployeeId();
		String name = SysConst.ORGANIZATIONSTRUCTURE_TREE.getNode(
				sysEmployee.getEmployeeDepartment()).getName();
		String res = "{\"name\":\""+sysEmployee.getEmployeeName()+"\","
				+ "\"department\":\""+name+"\","+"\"id\":\""+id+"\"}";
		
		System.out.println(res);
		return JSONObject.fromObject(res);
	}
	/*
	 * 获取部门列表
	 */
	@RequestMapping(value="/department.do")
	public @ResponseBody Object getDepartment(HttpServletRequest req){
		
		String ids = req.getParameter("ids");
		String temp[] = ids.substring(1, ids.length()-1).split(",");
		
		System.out.println(temp[0]);
		
//		Map<String,List<OrganizationStructureTreeNode>> resMap = new HashMap<>();
//			
//		List<OrganizationStructureTreeNode> treeNodes = 
//				SysConst.ORGANIZATIONSTRUCTURE_TREE.getOSTreeNodes();
//		
//		for(int i=0;i<temp.length;i++){
//			List<OrganizationStructureTreeNode> tree = new ArrayList<>();
//			for(OrganizationStructureTreeNode node: treeNodes){
//				if(!node.getSuperior().equals("0")){
//					if(temp[i].equals((node.getSuperior()))){
//						tree.add(node);
//						System.out.println(node.getText());
//					}
//					
//				}
//			}
//			resMap.put(temp[i], tree);
//		}
		
		JsonConfig config = new JsonConfig();
		config.setIgnoreDefaultExcludes(false);
		config.registerJsonValueProcessor(Date.class,
				new DateJsonValueProcessor("yyyy-MM-dd"));
		
		List<OrganizationStructureTreeNode> employeeTree = SysConst.EMPLOYEE_TREE.getChildren();
		List<String> array = new ArrayList<>();System.out.println(employeeTree.size());
		Map<String, List<OrganizationStructureTreeNode>> resMap = new HashMap<>();
		for(int i=0;i<temp.length;i++){
			for(int j=0; j<employeeTree.size();j++){
				if(employeeTree.get(j).getId() == Integer.parseInt(temp[i])){
					resMap.put(temp[i], employeeTree.get(j).getChildren());
				}
			}
		}
		return JSONObject.fromObject(resMap,config);
	}
	
	/*
	 * 获取人员信息
	 */
	@RequestMapping(value="/employee.do")
	public @ResponseBody Object getEmployee(HttpServletRequest req){
		
		String employeeId = req.getParameter("employeeId");
		HttpEmployee employee = new HttpEmployee();
		employee.setEmployeeId(Integer.parseInt(employeeId));
		
		JsonConfig config = new JsonConfig();
		config.setIgnoreDefaultExcludes(false);
		config.registerJsonValueProcessor(Date.class,
				new DateJsonValueProcessor("yyyy-MM-dd"));
		System.out.println("employeeid:"+employee.getEmployeeId());
		return JSONObject.fromObject(
				employeeService.getEmployeeById(Integer.parseInt(employeeId)),config);
	}
	/*
	 * 获取人员列表
	 */
	/*@RequestMapping(value="/list.do")
	public @ResponseBody Object getEmployeeList(HttpServletRequest req){
		
		int pageSize = 15;
		int page = Integer.parseInt((req.getParameter("pageNow")));
		HttpEmployee employee = new HttpEmployee();

		return JSONObject.fromObject(
				employeeService.getEmployeeByPage(employee, pageSize, page));
	}*/
	
	/*
	 * 获取人员全部列表
	 */
	@RequestMapping(value="/listAll.do")
	public @ResponseBody Object getEmployeeListAll(HttpServletRequest req){
		
		int pageSize = 0;
		int page = Integer.parseInt((req.getParameter("pageNow")));
		HttpEmployee employee = new HttpEmployee();

		return JSONObject.fromObject(
				employeeService.getEmployeeByPage(employee, pageSize, page));
	}

	/*
	 * 获取人员列表
	 */
	@RequestMapping(value="/list.do")
	public @ResponseBody Object getEmployeeList2(HttpServletRequest req){
		
		int pageSize = 15;
		int page = Integer.parseInt((req.getParameter("pageNow")));
		HttpEmployee employee = new HttpEmployee();

		String keys = req.getParameter("keys");
		
		try {

			keys = URLDecoder.decode(keys, "utf-8");

		}
		catch (Exception e) {

			e.printStackTrace();

		}
		
		JSONObject obj = JSONObject.fromObject(keys);
		if(obj.containsKey("name")){
			employee.setEmployeeName(obj.getString("name"));
		}
		
		JsonConfig config = new JsonConfig();
		config.setIgnoreDefaultExcludes(false);
		config.registerJsonValueProcessor(Date.class,
				new DateJsonValueProcessor("yyyy-MM-dd"));
		System.out.println("这里是测试公共通讯录："+employee.getEmployeeName()+keys);
		return JSONObject.fromObject(
				employeeService.getEmployeeByPage(employee, pageSize, page),config);
	}
	
	/*
	 * 获取机构信息
	 */
	@RequestMapping(value="/getOrganization.do")
	public @ResponseBody Object getOrganizationInfo(HttpServletRequest req){
		
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		SysOrganizationStructure os = new SysOrganizationStructure();
		if(id != null){
			int tid = Integer.parseInt(id);
			os.setId(tid);
		}else{
			try {

				name = URLDecoder.decode(name, "utf-8");

			}
			catch (Exception e) {

				e.printStackTrace();

			}
			os.setName(name); System.out.println("测试："+os.getName()+name);
		}
		
		
		JsonConfig config = new JsonConfig();
		config.setIgnoreDefaultExcludes(false);
		config.registerJsonValueProcessor(Date.class,
				new DateJsonValueProcessor("yyyy-MM-dd"));
		
		return JSONObject.fromObject(
				orgService.getOrganizationByPage(os, 1, 1),config);
	}
	@RequestMapping(value = "/getOSbyKey.do")
	public @ResponseBody Object getOSbyKey(String osId){ 
		
		//List<OrganizationStructure> list= organizationStructureService.getTreegrid(id);
		
		if(StringUtils.isEmpty(osId))
			return null;
		
		JsonConfig config = new JsonConfig();
		config.setIgnoreDefaultExcludes(false);
		config.registerJsonValueProcessor(Date.class,
				new DateJsonValueProcessor("yyyy-MM-dd"));
		
		
		return JSONObject.fromObject(orgService.getOSbyId(Integer.parseInt(osId)),config);
		
	}
	/*
	 * 获取机构列表
	 */
	@RequestMapping(value="/orgList.do")
	public @ResponseBody Object getOrgList(HttpServletRequest req){
		
		int pageSize = 15;
		int page = Integer.parseInt(req.getParameter("pageNow"));
		SysOrganizationStructure os = new SysOrganizationStructure();
		
		return JSONObject.fromObject(
				orgService.getOrganizationByPage(os, pageSize, page));
	}
	
	@RequestMapping(value="/insert.do")
	public @ResponseBody Object insert(HttpServletRequest req){
		
		String name = req.getParameter("name"); //人数
		String department = req.getParameter("department"); // 地点
		String Idcard = req.getParameter("Idcard"); //开会时间
		String cellphone = req.getParameter("cellphone");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		String wechatAccount = req.getParameter("wexin");
		String school = req.getParameter("school");
		//String viewEmployeeIds = req.getParameter("viewEmployeeIds");
		
		try {

			name = URLDecoder.decode(name, "utf-8");
			address = URLDecoder.decode(address, "utf-8");
			school = URLDecoder.decode(school, "utf-8");
		}
		catch (Exception e) {

			e.printStackTrace();

		}
		
		SysEmployee emp = new SysEmployee();
	    emp.setEmployeeName(name);
	    emp.setEmployeeDepartment(Integer.parseInt(department));
	    emp.setEmployeeIdcard(Idcard);
	    emp.setEmployeeCellPhone(cellphone);
	    emp.setEmail(email);
	    emp.setHomeAddress(address);
	    emp.setWechatAccount(wechatAccount);
	    emp.setEmployeeGraduate(school);
		//mt.setViewEmployeeIds(viewEmployeeIds); // 转成ids
		String res = employeeService.insert(emp);
		return emp.getEmployeeId();
	}
}
