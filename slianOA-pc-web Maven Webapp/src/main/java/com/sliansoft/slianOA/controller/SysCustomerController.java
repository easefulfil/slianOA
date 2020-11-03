package com.sliansoft.slianOA.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sliansoft.slianOA.dataaccess.dao.SysAuthenticationMapper;
import com.sliansoft.slianOA.dataaccess.dao.SysEmployeeMapper;
import com.sliansoft.slianOA.dataaccess.dao.SysUserMapper;
import com.sliansoft.slianOA.dataaccess.daoEx.SysCustomerMapperEx;
import com.sliansoft.slianOA.dataaccess.model.SysAuthenticationExample;
import com.sliansoft.slianOA.dataaccess.model.SysCustomer;
import com.sliansoft.slianOA.dataaccess.model.SysCustomerExample;
import com.sliansoft.slianOA.dataaccess.model.SysUser;
import com.sliansoft.slianOA.dataaccess.model.SysUserExample;
import com.sliansoft.slianOA.service.AuthenticationInfoService;
import com.sliansoft.slianOA.service.CustomerService;
import com.sliansoft.slianOA.service.EmployeeService;
import com.sliansoft.slianOA.service.UsersService;
import com.sliansoft.slianOA.service.httpModels.HttpCustomer;
import com.sliansoft.slianOA.service.utils.DateJsonValueProcessor;
import com.sliansoft.slianOA.service.utils.DateMorpherEx;
import com.sliansoft.slianOA.service.utils.ExcelJson;

@Controller
@RequestMapping(value = "/customer")
public class SysCustomerController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private DataSource dataSourceWebeconitl;
	
	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Autowired
	private SysEmployeeMapper sysEmployeeMapper;
	
	@Autowired
	private UsersService usersService;
	
	@Autowired
	private AuthenticationInfoService authenticationService;
	
	@Autowired
	private SysAuthenticationMapper sysAuthenticationMapper;
	
	@Autowired
	private SysCustomerMapperEx customerMapper;
	
	@Autowired
	protected HttpSession session;
	
//	@Autowired
//	private SalesysCustomerTrackService salesysCustomerTrackService;
	
	@RequestMapping(value = "/listAll.do")
	public @ResponseBody
	Object listAll(HttpServletRequest req){
		
		JsonConfig config = new JsonConfig();
		config.setIgnoreDefaultExcludes(false);
		config.registerJsonValueProcessor(Date.class,
				new DateJsonValueProcessor("yyyy-MM-dd"));
		Object o=JSONArray.fromObject(customerService.getCustomers(),config);
	System.out.println( JSONArray.fromObject(customerService.getCustomers(),config));
 		return  JSONArray.fromObject(customerService.getCustomers(),config);
	}

	
	@RequestMapping(value = "/list.do")
	public @ResponseBody
	Object list(HttpServletRequest req, HttpCustomer httpCustomer) {
		
		Integer pageSize = Integer.parseInt(req.getParameter("rows"));
		Integer pageNow = Integer.parseInt(req.getParameter("page"));
		Map<String, Object> map = customerService.getCusByPage(httpCustomer,
				pageSize, pageNow);
		return JSONObject.fromObject(map);
		}
	
	@RequestMapping(value = "/exportExcel.do")
	public  void exportExcel(String customerCompany, String cname ,String mobile,
			String customerType,String attitude, String department,String customerCounterman,HttpServletRequest request,
			HttpServletResponse response, HttpCustomer httpCustomer) {
		JSONArray dlist =customerService.selectAll
				(customerCompany, cname, mobile, customerType, attitude, department, customerCounterman);
			
		JSONObject obj2 = new JSONObject();
		if(dlist != null){
			obj2.put("data", dlist);

		/*
		 * Object obj1 = Ids.toArray()[0]; JSONObject obj2 = (JSONObject) obj1;
		 */
			String filename="客户管理报表";
		try {
			String excelFileName = new String(("客户管理报表.xls").getBytes("gb2312"), "ISO8859-1");
			response.setContentType("octets/stream");
			response.addHeader("Content-Disposition", "attachment;filename=" + excelFileName);
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		JSONUtils.getMorpherRegistry()
				.registerMorpher(new DateMorpherEx(new String[] { "yyyy-MM-dd HH:mm:ss" }, (Date) null));
		try {
			OutputStream out = response.getOutputStream();
			// scheduleEmployeeService.exportExcel(scheduleMonth,osId, out);
			ExcelJson excelJson = new ExcelJson();
			excelJson.createExcel(out, obj2,filename);
			out.close();
			System.out.println("excel out");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		}else{
			try {
				response.setHeader("Content-Disposition",
						"attachment;fileName=" + URLEncoder.encode("记录不存在", "UTF-8") + ".txt");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}


	@SuppressWarnings("unchecked")
	@Transactional
	@RequestMapping(value = "/save.do")
	public @ResponseBody
	Object save(HttpServletRequest req) {
		// String deleted = req.getParameter("deleted");
		String inserted = req.getParameter("inserted");
		String updated = req.getParameter("updated");
        //得到员工微信帐号：
//		String weixinAcoount = (String) session.getAttribute("wechatAccount");
//		boolean is_weixin = false;		
//		if(weixinAcoount == null){
//			return "fail,need wechatAccount";
//		}else{				
//			is_weixin = true;//微信端新建客户
//		}
		JSONUtils.getMorpherRegistry().registerMorpher(
				new DateMorpherEx(new String[] { "yyyy-MM-dd" }, (Date) null));
		if (inserted != null) {								
			JSONArray jsonArray = JSONArray.fromObject(inserted);
			List<SysCustomer> listInserted = (List<SysCustomer>) JSONArray
					.toCollection(jsonArray, SysCustomer.class);
			for (SysCustomer sysCustomer : listInserted) {
				sysCustomer.setCreateTime(new Date());
//				updateWebeconitl(customer,is_weixin);
				customerService.insert(sysCustomer);
//				if(is_weixin){//微信端添加客户时添加客户轨迹
////					SalesysCustomerTrack salesysCustomerTrack = new SalesysCustomerTrack();
////					salesysCustomerTrack.setCustomerType(customer.getCustomerType());
////					salesysCustomerTrack.setCustomerId(customer.getCustomerId());
////					salesysCustomerTrack.setHappenTime(new Date());
////					salesysCustomerTrackService.insertCustomerTrack(salesysCustomerTrack);
//					if(listInserted.size() == 1){//返回新建客户的id
//						return customer.getCustomerId()+"";
//					}
//				}				
			}
		}

		if (updated != null) {
			JSONArray jsonArray = JSONArray.fromObject(updated);
			List<SysCustomer> listUpdated = (List<SysCustomer>) JSONArray
					.toCollection(jsonArray, SysCustomer.class);
			for (SysCustomer sysCustomer : listUpdated) {
				sysCustomer.setCreateTime(new Date());
/*				UsersExample example = new UsersExample();
				example.createCriteria().andUserDetailIdEqualTo(customer.getCustomerId()).andTypeEqualTo("客户");
				List<Users> user = usersMapper.selectByExample(example);
				int size = authenticationService.getAuthenticationInfo(user.get(0).getId().toString()).size();
				if(customer.getCustomerStatus().equals("封停")){
					//如果有帐号信息则删除
					if(size > 0){
						authenticationService.deleteByUserId(user.get(0).getId());
					}
				}else{
					//如果有帐号信息则无操作，若无帐号信息则新建并修改person
					if(size == 0 && !is_weixin){
						int uid = user.get(0).getId();
						AuthenticationInfo info = new AuthenticationInfo();
						info.setAccount(customer.getCustomerCellPhone());
						info.setUid(uid);
						info.setType("手机");
						info.setStatus("启用");
						int length= customer.getCustomerCellPhone().length();
						info.setPassword(customer.getCustomerCellPhone().substring(length-6, length));
						authenticationInfoMapper.insertSelective(info);
						
						if(customer.getEmail().length()>0){
							AuthenticationInfo info2 = new AuthenticationInfo();
							info2.setAccount(customer.getEmail());
							info2.setUid(uid);
							info2.setType("邮箱");
							info2.setStatus("启用");
							info2.setPassword(customer.getCustomerCellPhone().substring(length-6, length));
							authenticationInfoMapper.insertSelective(info2);
						}
					}
				}*/
//				updateWebeconitl(customer,is_weixin);
				customerService.update(sysCustomer);
			}
		}
		return "success";
	}

	@RequestMapping(value = "/setvip.do")
	public @ResponseBody String vipset(HttpServletRequest req) {
		String ids = req.getParameter("customerIds");
		String type = req.getParameter("type");


		return customerService.setVIP(ids, type);

	}
	//设置付款态度
	@RequestMapping(value = "/setAttitude.do")
	public @ResponseBody String setCustomerStatus(HttpServletRequest req) {
		String ids = req.getParameter("customerIds");
		String type = req.getParameter("type");


		return customerService.setAttitude(ids, type);

	}
//	//获取登陆的用户对应的部门
//	@RequestMapping(value = "/getName.do")
//	public @ResponseBody  Map<String,Object> getName(HttpServletRequest req) {
//		Map<String,Object> map=new HashMap();
//		HttpSession session=req.getSession();
//		Employee employee= (Employee) session.getAttribute("employee");
//		String depentment=employee.getEmployeeType();
//		System.out.println(depentment);
//		map.put("depentment", depentment);
//		return map;  
//
//	}
	
	@RequestMapping(value = "/setCounterman.do")
	public @ResponseBody String setCounterman(HttpServletRequest req) {
		String ids = req.getParameter("customerIds");
		String employeeId = req.getParameter("employeeId");


		return customerService.setCounterman(ids, employeeId);

	}

	@RequestMapping(value = "/delete.do")
	public @ResponseBody
	String delete(HttpServletRequest req) {
		String ids = req.getParameter("ids");

		String[] cIds = ids.split(",");

		
//        String s = deleteWebconitl(cIds);
        return customerService.deleteCusById(cIds);
	}
	
//	   private String deleteWebconitl(String[] cIds) {
//		   List<String> list = new ArrayList<String>();
//		   String rt = "success";
//			for(String id :cIds){
//				Customer customer = customerService.getCustomer(Integer.parseInt(id));
//				String code =customer.getHy2008CustomerId();
//				if(customerService.deleteCusById(new String[]{id}).equals("error")){
//					return "删除失败";
//				}
//				if(code != null && !code.trim().equals("")){
//					CustomerExample example = new CustomerExample();
//					example.createCriteria().andHy2008CustomerIdEqualTo(code);
//					int num = customerMapper.countByExample(example);
//					if(num == 0)
//						list.add(code.toUpperCase());
//				}
//			}
//			if(list.size() == 0){
//				return rt;
//			}
//			else{	
//				Connection connection = null;
//				Statement statement =null;
//				try {
//					connection = dataSourceWebeconitl.getConnection();
//					statement = connection.createStatement();
//					String delete = "delete from PERSON where ";
//							for(String code:list){
//								delete +=" CODE='"+code+"' or ";
//							}
//					delete +=" 1!=1";
//					System.out.println(delete);
//					statement.executeUpdate(delete);
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//					rt = "08系统删除失败！";
//				}finally{
//				
//					try {
//						statement.close();
//						connection.close();
//					} catch (SQLException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//			return rt;			
//				
//			}		
//					
//	}

//	private boolean updateWebeconitl(Customer customer,boolean is_weixin){
//		   boolean bo = false;
//		   String code =  customer.getHy2008CustomerId();	   
//		   if( code == null || code.trim().equals(""))
//			  return bo; 
//		   code = code.trim();
//		   Connection connection = null;
//		   Statement statement = null;
//		   ResultSet rs = null;
//		   try {
//		    connection = dataSourceWebeconitl.getConnection();
//			statement = connection.createStatement();
//			String sql = "select * from PERSON where CODE = '"+code.toUpperCase()+"'";
//			rs =statement.executeQuery(sql);
//			if(rs.next()){//08系统存在此code
//				/*String password = "";
//				if(customer.getCustomerId() != null && customer.getCustomerStatus().equals("正常")&& !is_weixin){//属于更新客户,不是微信操作
//					UsersExample usersExample = new UsersExample();
//	   				usersExample.createCriteria().andUserDetailIdEqualTo(customer.getCustomerId()).andTypeEqualTo("客户");
//	   				List<Users> users = usersMapper.selectByExample(usersExample);
//	   				AuthenticationInfoExample authenticationInfoExample = new AuthenticationInfoExample();
//	   				authenticationInfoExample.createCriteria().andUidEqualTo(users.get(0).getId());
//	   				password = authenticationInfoMapper.selectByExample(authenticationInfoExample).get(0).getPassword();
//	   				String sql1 = "update PERSON set CNAME ='"+customer.getCustomerCompany()+"', PW='"+password+"' where CODE='"+code.toUpperCase()+"'";
//					statement.executeUpdate(sql1);
//				}*/
//				
//				bo = true;
//			}else{//08系统不存在此code
//				if(customer.getCustomerStatus().equals("正常")){
//				String password = "";
//				if(customer.getCustomerId() != null ){//属于更新客户
//					if(is_weixin){
//						password = "123456";
//					}else{
//						UsersExample usersExample = new UsersExample();
//		   				usersExample.createCriteria().andUserDetailIdEqualTo(customer.getCustomerId()).andTypeEqualTo("客户");
//		   				List<Users> users = usersMapper.selectByExample(usersExample);
//		   				AuthenticationInfoExample authenticationInfoExample = new AuthenticationInfoExample();
//		   				authenticationInfoExample.createCriteria().andUidEqualTo(users.get(0).getId());
//		   				password = authenticationInfoMapper.selectByExample(authenticationInfoExample).get(0).getPassword();
//					}					
//				}else{//微信端添加客户时若此code在08不存在，则在08默认生成一个密码为123456的person
//					if(is_weixin){
//						password = "123456";
//					}else {
//						int length= customer.getCustomerCellPhone().length();
//						password = customer.getCustomerCellPhone().substring(length-6, length);
//					}				
//				}
//				String sql2 = "insert into PERSON(CODE,CNAME,WGROUP,BMDM,PW) values('"+code.toUpperCase()+"','"+customer.getCustomerCompany()+"','AH','KH','"+password+"')";//?修改哪些字段
//				statement.executeUpdate(sql2);
//				}
//				bo = true;
//			}
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{		
//			try {
//				rs.close();
//				statement.close();
//				connection.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		   return bo;
//	   }
	
}
