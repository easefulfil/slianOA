/**
 * 
 */
package com.slianOAsys.service.impl;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.slianOAsys.dao.SysAuthenticationInfoMapper;
import com.slianOAsys.dao.SysEmployeeMapper;
import com.slianOAsys.dao.SysUsersMapper;
import com.slianOAsys.model.SysAuthenticationInfo;
import com.slianOAsys.model.SysAuthenticationInfoExample;
import com.slianOAsys.model.SysEmployee;
import com.slianOAsys.model.SysEmployeeExample;
import com.slianOAsys.model.SysUsers;
import com.slianOAsys.model.SysUsersExample;
import com.slianOAsys.model.SysEmployeeExample.Criteria;
import com.slianOAsys.model.ex.SysEmployeeEx;
import com.slianOAsys.page.Page;
import com.slianOAsys.service.SessionService;
import com.slianOAsys.service.SysEmployeeService;
import com.slianOAsys.service.SysUsersService;
import com.slianOAsys.service.utils.CommonUtils;
import com.slianOAsys.service.utils.DateJsonValueProcessor;
import com.slianOAsys.service.utils.ExportExcel;
import com.slianOAsys.service.utils.SysConst;
import com.slianOAsys.service.utils.SysOrganizationStructureTreeNode;


public class SysEmployeeServiceImpl implements SysEmployeeService {

	@Autowired
	private SysEmployeeMapper employeeMapper;// SysEmployeeMapperEx

	@Autowired
	private SysUsersMapper usersMapper;

	@Autowired
	private SysAuthenticationInfoMapper authenticationInfoMapper;

	@Autowired
	private SysUsersService usersService;
	
	
	public Map<String, Object> getEmployeeByPage(SysEmployeeEx employee,
			Integer pageSize, Integer pageNow) {
		SysEmployeeExample example = new SysEmployeeExample();
		Criteria criteria = example.createCriteria();

		this.setCriteria(employee, criteria);

		// criteria.andEmployeeIdIsNotNull();
		int totalrecords = employeeMapper.countByExample(example);

		/**
		 * for my sql db
		 */
		Page page = new Page();

		page.setBegin((pageNow - 1) * pageSize);
		page.setLength(pageSize);

		example.setOrderByClause("employee_id desc");

		example.setPage(page);

		List<SysEmployee> employees = employeeMapper.selectByExample(example);

		/**
		 * for sql server db
		 */

		// example.setPageIndex(pageNow);
		// example.setPageSize(pageSize);
		//
		// List<SysEmployee> employees = employeeMapper.selectPage(example);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", totalrecords);
		if (totalrecords % pageSize == 0)
			map.put("totalPages", totalrecords / pageSize);
		else
			map.put("totalPages", totalrecords / pageSize + 1);
		JsonConfig config = new JsonConfig();
		config.setIgnoreDefaultExcludes(false);
		config.registerJsonValueProcessor(Date.class,
				new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));

		map.put("rows", JSONArray.fromObject(this.convert(employees), config));
		return map;
	}

	private void setCriteria(SysEmployeeEx employee, Criteria criteria) {
		if (!StringUtils.isEmpty(employee.getEmployeeName())) {
			criteria.andEmployeeNameLike("%" + employee.getEmployeeName() + "%");
		}
		
		if (!StringUtils.isEmpty(employee.getEmployeeCellPhone())) {
			criteria.andEmployeeCellPhoneLike("%" + employee.getEmployeeCellPhone() + "%");
		}
		
		if (employee.getDepartmentName() != null
				&& !employee.getDepartmentName().equals("")) {

			List<Integer> osIds = SysConst.ORGANIZATIONSTRUCTURE_TREE
					.getOSIds(employee.getDepartmentName());

			if (osIds.size() == 0)
				osIds.add(-1);

			criteria.andEmployeeDepartmentIn(osIds);
		}
		if (employee.getEmployeeDepartment() != null
				&& !employee.getEmployeeDepartment().equals("")) {
			criteria.andEmployeeDepartmentEqualTo(employee.getEmployeeDepartment());
		}

	}

	private List<SysEmployeeEx> convert(List<SysEmployee> listE) {

		if (listE == null)
			return null;

		List<SysEmployeeEx> listHE = new ArrayList<SysEmployeeEx>();

		for (SysEmployee e : listE) {
			SysEmployeeEx he = new SysEmployeeEx();
			// ReflectionUtils.parentToChild(e, he);

			BeanUtils.copyProperties(e, he);

			if (e.getEmployeeDepartment() == null
					|| "".equals(e.getEmployeeDepartment()))
				;
			else {
				SysOrganizationStructureTreeNode node = SysConst.ORGANIZATIONSTRUCTURE_TREE
						.getNode(e.getEmployeeDepartment());

				he.setDepartmentName(SysConst.ORGANIZATIONSTRUCTURE_TREE
						.getParentsNodeName(node) + node.getName());

			}

			listHE.add(he);

		}

		return listHE;

	}

	public String insert(SysEmployee employee) {
		
		//å‰ç«¯å·²åˆ¤æ–­
//		if (this.isExistEmployeeName(employee.getEmployeeName()) 
//				|| this.isExist(employee.getEmployeeCellPhone(), employee.getEmail()))
//			return "error ç”¨æˆ·æ‰‹æœºå·æˆ–é‚®ç®±å·²å­˜åœ¨";

		this.doInsert(employee);

		this.init_EMPLOYEEMAP();

		// SysConst.initConstFor_QUERY("init_EMPLOYEEMAP");

		return "success";
	}

	@Transactional
	private boolean doInsert(SysEmployee employee) {
		SysEmployeeExample example1 = new SysEmployeeExample();
		example1.or().andEmployeeDepartmentEqualTo(employee.getEmployeeDepartment());
		example1.setOrderByClause("sort desc");
		List<SysEmployee> sysList = employeeMapper.selectByExample(example1);
		if(!sysList.isEmpty()){
			employee.setSort(sysList.get(0).getSort()==null?0:(sysList.get(0).getSort()+1));
		}else{
			employee.setSort(0);
		}
		
		employeeMapper.insertSelective(employee);
		SysEmployeeExample example = new SysEmployeeExample();
		example.or().andEmployeeNameEqualTo(employee.getEmployeeName());
		
		List<SysEmployee> employeeIds = employeeMapper.selectByExample(example);
		int employeeId = employeeIds.get(0).getEmployeeId();
		int uid = 0;
		 //åœ¨æ·»åŠ å‘˜å·¥ä¿¡æ¯æ—¶ï¼Œå°†ç”¨æˆ·åæ·»åŠ å¤§ç‰‡usersè¡¨ä¸­
		 if (employee.getEmployeeName() != null) {
		SysUsers users = new SysUsers();
		users.setUserName(employee.getEmployeeName());
		users.setCreateTime(new Date());
		users.setType("å‘˜å·¥");
		users.setUserDetailId(employeeId);
		usersMapper.insertSelective(users);
		uid = users.getUserId();
		 }
		// å°†æ‰‹æœºå·å’Œé‚®ç®±åˆ†åˆ«æ·»åŠ åˆ°æŽˆæƒè¡¨ä¸­ï¼Œä½œä¸ºç™»å½•ä¿¡æ¯ï¼Œå¯†ç é»˜è®¤ä¸ºæ‰‹æœºå·åŽ6ä½ 
		if (!StringUtils.isEmpty(employee.getEmployeeCellPhone())) {
			// if (employee.getEmployeeCellPhone() != null) {
			SysAuthenticationInfo info = new SysAuthenticationInfo();
			info.setAccount(employee.getEmployeeCellPhone());
			info.setUserId(uid);
			info.setType("æ‰‹æœº");
			info.setStatus("ä¸å¯ç”¨");
			int length = employee.getEmployeeCellPhone().length();
			info.setPassword(employee.getEmployeeCellPhone().substring(
					length - 6, length));
			authenticationInfoMapper.insertSelective(info);

			if (!StringUtils.isEmpty(employee.getEmail())) {

				SysAuthenticationInfo info2 = new SysAuthenticationInfo();
				info2.setAccount(employee.getEmail());
				info2.setUserId(uid);
				info2.setType("é‚®ç®±");
				info2.setStatus("ä¸å¯ç”¨");
				info2.setPassword(employee.getEmployeeCellPhone().substring(
						length - 6, length));
				authenticationInfoMapper.insertSelective(info2);
			}

		}

		return true;
	}

	// åˆ¤æ–­ç”¨æˆ·çš„æ‰‹æœºå·ï¼Œæˆ–é‚®ç®±æ˜¯å¦å­˜åœ¨
	private boolean isExistEmployeeName(String employeeName) {

		SysEmployeeExample example = new SysEmployeeExample();

		example.or().andEmployeeNameEqualTo(employeeName);


		return employeeMapper.countByExample(example) > 0 ? true : false;
	}
	
	// åˆ¤æ–­ç”¨æˆ·çš„æ‰‹æœºå·ï¼Œæˆ–é‚®ç®±æ˜¯å¦å­˜åœ¨
	private boolean isExist(String phone, String email) {

		SysEmployeeExample example = new SysEmployeeExample();

		example.or().andEmployeeCellPhoneEqualTo(phone);
		if (!"".equals(email))
			example.or().andEmailEqualTo(email);

		return employeeMapper.countByExample(example) > 0 ? true : false;
	}

	// åˆ¤æ–­ç”¨æˆ·çš„æ‰‹æœºå·æ˜¯å¦å­˜åœ¨
	private boolean isExistphone(SysEmployee employee) {

		SysEmployeeExample example = new SysEmployeeExample();

		example.or().andEmployeeCellPhoneEqualTo(
				employee.getEmployeeCellPhone());

		List<SysEmployee> employees = employeeMapper.selectByExample(example);

		if (employees.size() < 1)
			return false;

		for (SysEmployee e : employees) {

			if (e.getEmployeeId().equals(employee.getEmployeeId()))
				return false;
			
//			System.out.println(e.getEmployeeId() == employee.getEmployeeId());
		}

		return true;

	}

	// åˆ¤æ–­ç”¨æˆ·çš„é‚®ç®±æ˜¯å¦å­˜åœ¨
	private boolean isExistEmail(SysEmployee employee) {

		if (employee.getEmail().equals("")) {
			return false;
		}
		SysEmployeeExample example = new SysEmployeeExample();

		example.or().andEmailEqualTo(employee.getEmail());

		List<SysEmployee> employees = employeeMapper.selectByExample(example);

		if (employees.size() < 1)
			return false;

		for (SysEmployee e : employees) {

			if (e.getEmployeeId() == employee.getEmployeeId())
				return false;
		}

		return true;

	}

	public String update(SysEmployee employee) {
		SysEmployeeExample example1 = new SysEmployeeExample();
		example1.or().andEmployeeDepartmentEqualTo(employee.getEmployeeDepartment());
		example1.setOrderByClause("sort desc");
		List<SysEmployee> sysList = employeeMapper.selectByExample(example1);
		if(!sysList.isEmpty()){
			employee.setSort(sysList.get(0).getSort()==null?0:(sysList.get(0).getSort()+1));
		}else{
			employee.setSort(0);
		}
		// 判断是否修改了手机号码及邮箱，如果修改了则需要修改相应的user表及authentciaionInfo表
		if (!StringUtils.isEmpty(employee.getEmployeeCellPhone()) && this.isExistphone(employee))
			return "用户手机号已经存在";

		// åˆ¤æ–­æ˜¯å¦ä¿®æ”¹äº†æ‰‹æœºå·ç åŠé‚®ç®±ï¼Œå¦‚æžœä¿®æ”¹äº†åˆ™éœ€è¦ä¿®æ”¹ç›¸åº”çš„userè¡¨åŠauthentciaionInfoè¡¨
		if (!StringUtils.isEmpty(employee.getEmail()) && this.isExistEmail(employee))
			return "用户邮箱已经存在";

		// this.updateUsersAndAuthentication(employee);
		
		if(employee.getEmployeeDepartment().equals(new Integer(0)))
			employee.setEmployeeDepartment(null);

		if (employeeMapper.updateByPrimaryKeySelective(employee) < 1)
			return "修改失败";

		this.init_EMPLOYEEMAP();

		// SysConst.initConstFor_QUERY("init_EMPLOYEEMAP");

		return "success";
	}

	@Transactional
	private void updateUsersAndAuthentication(SysEmployee employee) {

		SysEmployee oldEmployee = employeeMapper.selectByPrimaryKey(employee
				.getEmployeeId());

		// å‘˜å·¥å§“åä¿®æ”¹æ—¶ï¼Œä¿®æ”¹userè¡¨ä¸­çš„username
		if (!oldEmployee.getEmployeeName().equals(employee.getEmployeeName())) {
			SysUsers user = new SysUsers();

			user.setUserName(employee.getEmployeeName());

			SysUsersExample example = new SysUsersExample();

			example.or().andUserDetailIdEqualTo(employee.getCreatorId())
					.andUserNameEqualTo(oldEmployee.getEmployeeName());

			usersMapper.updateByExampleSelective(user, example);

		}

		// å‘˜å·¥æ‰‹æœºä¿®æ”¹æ—¶ï¼Œä¿®æ”¹userè¡¨ä¸­çš„username
		if (!oldEmployee.getEmployeeCellPhone().equals(
				employee.getEmployeeCellPhone())) {
			SysAuthenticationInfo authenInfo = new SysAuthenticationInfo();

			authenInfo.setAccount(employee.getEmployeeCellPhone());

			SysAuthenticationInfoExample example = new SysAuthenticationInfoExample();

			example.or().andAccountEqualTo(oldEmployee.getEmployeeCellPhone());

			authenticationInfoMapper.updateByExampleSelective(authenInfo,
					example);

		}

		// é‚®ç®±ä¿®æ”¹æ—¶ï¼Œä¿®æ”¹authenticationInfoè¡¨ä¸­çš„ account
		if (!oldEmployee.getEmail().equals(employee.getEmail())) {

			SysAuthenticationInfo authenInfo = new SysAuthenticationInfo();

			authenInfo.setAccount(employee.getEmail());

			SysAuthenticationInfoExample example = new SysAuthenticationInfoExample();

			example.or().andAccountEqualTo(oldEmployee.getEmail());

			authenticationInfoMapper.updateByExampleSelective(authenInfo,
					example);
		}

	}

	@Transactional
	public String deleteEmpById(String[] ids) {

		// åˆ é™¤å‘˜å·¥å¯¹åº”çš„ç”¨æˆ·ä¿¡æ¯
		
		List<Integer> intIds = new ArrayList<Integer>();
		for (String id : ids) {
			try {
				employeeMapper.deleteByPrimaryKey(Integer.parseInt(id));
				intIds.add(Integer.parseInt(id));

			} catch (Exception e) {
				if (e.getLocalizedMessage().contains("customer_counterman"))
					return "åˆ é™¤å¤±è´¥ï¼<br>å‘˜å·¥æœ‰ç”¨æˆ·ã€‚";
				else
					return "åˆ é™¤å¤±è´¥ï¼<br>ç³»ç»Ÿå¼‚å¸¸ã€‚";
			}
		}

		List<String> types = new ArrayList<String>();
		types.add("å‘˜å·¥");

	
		
		
		usersService.deleteByUserDetailId(intIds, types);
		
		this.init_EMPLOYEEMAP();

		// SysConst.initConstFor_QUERY("init_EMPLOYEEMAP");

		return "success";
	}

	@Override
	public SysEmployee getEmployeeById(Integer employeeId) {
		// TODO Auto-generated method stub

		return employeeMapper.selectByPrimaryKey(employeeId);
	}

	@Override
	public void init_EMPLOYEEMAP() {
		// TODO Auto-generated method stub

		SysConst.EMPLOYEE_MAP = new HashMap<Integer, String>();

		List<SysEmployee> employeeList = employeeMapper.selectByExample(null);

		for (SysEmployee e : employeeList) {

			SysConst.EMPLOYEE_MAP.put(e.getEmployeeId(), e.getEmployeeName());
		}

	}

	@Override
	public List<SysEmployeeEx> getEmployees() {
		// TODO Auto-generated method stub

		return this.convert(employeeMapper.selectByExample(null));
	}

	/**
	 * æ ¹æ®å‘˜å·¥å§“åæŸ¥æ‰¾å¯¹åº”çš„Id
	 */
	@Override
	public List<Integer> getEmployeeIds(String employeeName) {

		List<Integer> eIdList = new ArrayList<Integer>();

		SysEmployeeExample example = new SysEmployeeExample();

		example.or().andEmployeeNameLike("%" + employeeName.trim() + "%");
		for (SysEmployee e : employeeMapper.selectByExample(example)) {
			eIdList.add(e.getEmployeeId());
		}

		return eIdList;
	}

	@Override
	public void exportExcel(SysEmployeeEx employee, OutputStream os) {

		SysEmployeeExample example = new SysEmployeeExample();

		Criteria criteria = example.createCriteria();

		this.setCriteria(employee, criteria);

		example.setOrderByClause(" work_group asc");
		List<SysEmployeeEx> listEmployeeEx = this.convert(employeeMapper
				.selectByExample(example));

		ExportExcel<SysEmployeeEx> exportExcel = new ExportExcel<SysEmployeeEx>();

//		exportExcel.exportExcel("å¯¼å‡ºå˜‰å®¾ä¿¡æ¯", SysConst.ExcelConst.HEAD_SYSEMPLOYEE,
//				SysConst.ExcelConst.FIELDNAMES_SYSEMPLOYEE, listEmployeeEx, os,
//				"yyyy-MM-dd");

	}

	@Override
	public SysEmployee getByCustomerName(String employeeName) {

		SysEmployeeExample example = new SysEmployeeExample();

		example.or().andEmployeeNameEqualTo(employeeName);

		List<SysEmployee> customers = employeeMapper.selectByExample(example);

		if (customers == null || customers.size() == 0)
			return null;

		
		return customers.get(0);
	}
	
	
	@Override
	public Integer getByFromUserName(String fromusername) {

		SysEmployeeExample example = new SysEmployeeExample();

		example.or().andFromUserNameEqualTo(fromusername);

		List<SysEmployee> customers = employeeMapper.selectByExample(example);

		if (customers == null || customers.size() == 0)
			return null;
		
		return customers.get(0).getEmployeeId();
	}

	@Override
	public SysEmployee getByCellPhone(String cellPhone) {

		SysEmployeeExample example = new SysEmployeeExample();

		example.or().andEmployeeCellPhoneEqualTo(cellPhone);

		List<SysEmployee> customers = employeeMapper.selectByExample(example);

		if (customers == null || customers.size() == 0)
			return null;

		return customers.get(0);
	}

}