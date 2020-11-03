package com.sliansoft.slianOA.dataaccess.daoEx.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.sliansoft.slianOA.dataaccess.dao.SysCustomerMapper;
import com.sliansoft.slianOA.dataaccess.dao.SysEmployeeMapper;
import com.sliansoft.slianOA.dataaccess.daoEx.SysCustomerMapperEx;
import com.sliansoft.slianOA.dataaccess.model.SysCustomer;
import com.sliansoft.slianOA.dataaccess.model.SysCustomerExample;
import com.sliansoft.slianOA.dataaccess.model.SysCustomerExample.Criteria;
import com.sliansoft.slianOA.dataaccess.model.SysEmployee;
import com.sliansoft.slianOA.dataaccess.model.SysUser;
import com.sliansoft.slianOA.dataaccess.utils.DataAuthorityRegister;

public class SysCustomerMapperExImpl implements SysCustomerMapperEx {
	
	@Autowired
	private SysCustomerMapper sysCustomerMapper;
	
	@Autowired
	private SysEmployeeMapper sysEmployeeMapper;
	
	@Autowired
	protected HttpSession session;

	@Override
	public int countByExample(SysCustomerExample example) {
		// TODO Auto-generated method stub
		this.setExample(example);
		return sysCustomerMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(SysCustomerExample example) {
		// TODO Auto-generated method stub
		//检查波及范围
		setExample(example);
		return sysCustomerMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer customerId) {
		// TODO Auto-generated method stub
		if(testId(customerId)==1)
			return sysCustomerMapper.deleteByPrimaryKey(customerId);
		else
			return 0;
	}

	@Override
	public int insert(SysCustomer record) {
		// TODO Auto-generated method stub
		int re=0;
		try{
			SysEmployee sysEmployee=(SysEmployee) session.getAttribute("employee");
			if(record.getCustomerCounterman()==null){
				record.setCustomerCounterman(sysEmployee.getEmployeeId());
				record.setAccessGroup(sysEmployee.getEmployeeDepartment());
			}
			else{
				record.setAccessGroup(sysEmployeeMapper.selectByPrimaryKey(record.getCustomerCounterman()).getEmployeeDepartment());
			}
			record.setCreator(sysEmployee.getEmployeeId());
			record.setCreateTime(new Date());
			re=sysCustomerMapper.insert(record);
		}catch(Exception e){
			re=0;
		}
		return re;
	}

	@Override
	public int insertSelective(SysCustomer record) {
		// TODO Auto-generated method stub
		int re=0;
		try{
			SysEmployee sysEmployee=(SysEmployee) session.getAttribute("employee");
			if(record.getCustomerCounterman()==null){
				record.setCustomerCounterman(sysEmployee.getEmployeeId());
				record.setAccessGroup(sysEmployee.getEmployeeDepartment());
			}
			else{
				record.setAccessGroup(sysEmployeeMapper.selectByPrimaryKey(record.getCustomerCounterman()).getEmployeeDepartment());
			}
			record.setCreator(sysEmployee.getEmployeeId());
			record.setCreateTime(new Date());
			re=sysCustomerMapper.insertSelective(record);
		}catch(Exception e){
			re=0;
		}
		return re;
	}

	@Override
	public List<SysCustomer> selectByExample(SysCustomerExample example) {
		// TODO Auto-generated method stub
		setExample(example);
		return sysCustomerMapper.selectByExample(example);
	}

	@Override
	public SysCustomer selectByPrimaryKey(Integer customerId) {
		// TODO Auto-generated method stub
		SysCustomer sysCustomer=sysCustomerMapper.selectByPrimaryKey(customerId);
		if(testId(customerId)!=0)
			return sysCustomer;
		else
			return null;
	}

	@Override
	public int updateByExampleSelective(SysCustomer record, SysCustomerExample example) {
		// TODO Auto-generated method stub
		//检查波及范围
		setExample(example);
		if(record.getCustomerCounterman()==null)
			record.setAccessGroup(null);
		else{
			record.setAccessGroup(sysEmployeeMapper.selectByPrimaryKey(record.getCustomerCounterman()).getEmployeeDepartment());
		}
		record.setCreator(null);
		record.setCreateTime(null);
		return sysCustomerMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(SysCustomer record, SysCustomerExample example) {
		// TODO Auto-generated method stub
		//检查波及范围
		return this.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(SysCustomer record) {
		// TODO Auto-generated method stub
		Integer customerId=record.getCustomerId();
		if(testId(customerId)==1){
			if(record.getCustomerCounterman()==null)
				record.setAccessGroup(record.getAccessGroup());
			else
				record.setAccessGroup(sysEmployeeMapper.selectByPrimaryKey(record.getCustomerCounterman()).getEmployeeDepartment());
			record.setCreator(null);
			record.setCreateTime(null);
			return sysCustomerMapper.updateByPrimaryKeySelective(record);
		}else
			return -4001;
	}

	@Override
	public int updateByPrimaryKey(SysCustomer record) {
		// TODO Auto-generated method stub
		return this.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<SysCustomer> selectPage(SysCustomerExample example) {
		// TODO Auto-generated method stub
//		DataAuthorityRegister dataAuthorityRegister=(DataAuthorityRegister)session.getAttribute("dataAuthorityRegister");
//		if(dataAuthorityRegister!=null){
//			Thread currentTh=Thread.currentThread();
//			if(dataAuthorityRegister.isDataUnderControl(currentTh.getId())){
//				Set<Integer> orgList=dataAuthorityRegister.getOrgList(currentTh.getId());
//				List<String> orgStringList=new ArrayList<String>();
//				if(orgList.size()==1 && orgList.contains(new Integer(-1))){
//					for(Criteria criteria:example.getOredCriteria()){
//						criteria.andCustomerCountermanEqualTo(((Employee) session.getAttribute("employee")).getEmployeeId());
//					}
//				}else{
//					for(Integer org:orgList){
//						orgStringList.add(org);
//					}
//					if(example.getOredCriteria().size()==0){
//						example.createCriteria().andAccessGroupIn(orgStringList);
//					}else{
//						for(Criteria criteria:example.getOredCriteria()){
//							criteria.andAccessGroupIn(orgStringList);
//						}
//					}
//				}
//			}
//		}
		return sysCustomerMapper.selectPage(example);
	}

	@Override
	public int insertAndGetId(SysCustomer record) {
		int re=0;
		try{
			/*Integer employeeId = ((Employee) session.getAttribute("employee")).getEmployeeId();
			Employee employee = employeeMapper.selectByPrimaryKey(employeeId);*/
			SysEmployee sysEmployee = (SysEmployee) session.getAttribute("employee");
			if(record.getCustomerCounterman()==null){
				record.setCustomerCounterman(sysEmployee.getEmployeeId());
				record.setAccessGroup(sysEmployee.getEmployeeDepartment());
			}
			else{
				record.setAccessGroup(sysEmployeeMapper.selectByPrimaryKey(record.getCustomerCounterman()).getEmployeeDepartment());
			}
			record.setCreator(sysEmployee.getEmployeeId());
			record.setCreateTime(new Date());
			re=sysCustomerMapper.insertAndGetId(record);
		}catch(Exception e){
			e.printStackTrace();
			re=0;
		}
		return re;
	}
	
	//设置条件
	protected void setExample(SysCustomerExample example){
		DataAuthorityRegister dataAuthorityRegister=(DataAuthorityRegister)session.getAttribute("dataAuthorityRegister");
		if(dataAuthorityRegister!=null){
			Thread currentTh=Thread.currentThread();
			if(dataAuthorityRegister.isDataUnderControl(currentTh.getId())){
				Set<Integer> orgList=dataAuthorityRegister.getOrgList(currentTh.getId());
				List<Integer> orgStringList=new ArrayList<Integer>();
				
				if(orgList.size()==1 && orgList.contains(new Integer(-1))){
					if(example.getOredCriteria()==null||example.getOredCriteria().isEmpty())
						example.createCriteria();
					for(Criteria criteria:example.getOredCriteria()){
					
//						criteria.andCustomerCountermanEqualTo(((Employee) session.getAttribute("employee")).getEmployeeId());
						
						criteria.andCustomerCountermanEqualTo(dataAuthorityRegister.getCurrentSessionEmployeeeId(currentTh.getId()));
						
						//example.or().andCustomerIdIn(values);
						
					}
				}else{
					for(Integer org:orgList){
						orgStringList.add(org);
					}
					if(example.getOredCriteria().size()==0){
						example.createCriteria().andAccessGroupIn(orgStringList);
					}else{
						for(Criteria criteria:example.getOredCriteria()){
							criteria.andAccessGroupIn(orgStringList);
						}
					}
				}
			}
		}
	}
	//设置ID
	private int testId(Integer id){
		int re=1;
		SysCustomer sysCustomer=sysCustomerMapper.selectByPrimaryKey(id);
		SysUser user = (SysUser)session.getAttribute("user");
		Integer userDetailId = user.getUserDetailId();
		DataAuthorityRegister dataAuthorityRegister=(DataAuthorityRegister)session.getAttribute("dataAuthorityRegister");
		if(dataAuthorityRegister == null && id.equals(userDetailId))
			return re;
		if(dataAuthorityRegister!=null){
			Thread currentTh=Thread.currentThread();
			if(dataAuthorityRegister.isDataUnderControl(currentTh.getId())){
				Set<Integer> orgList=dataAuthorityRegister.getOrgList(currentTh.getId());
				List<String> orgStringList=new ArrayList<String>();
				if(orgList.size()==1 && orgList.contains(new Integer(-1))){
					if(!sysCustomer.getCustomerCounterman().equals(((SysEmployee) session.getAttribute("employee")).getEmployeeId())){
						re=0;
					}
				}else{
					for(Integer org:orgList){
						orgStringList.add(Integer.toString(org));
					}
					if(!orgStringList.contains(sysCustomer.getAccessGroup())){
						re=0;
					}
				}
			}
		}else
			re=-1;
		return re;
	}

	@Override
	public List<SysCustomer> selectByExampleForInit(SysCustomerExample example) {
		return sysCustomerMapper.selectByExample(example);
	}

	@Override
	public List<SysCustomer> selectAll(String customerCompany, String cname, String mobile, String customerType,
			String attitude, String department, String customerCounterman) {
		// TODO Auto-generated method stub
		
		return sysCustomerMapper.selectAll(customerCompany, cname, mobile, customerType, attitude, department, customerCounterman);
	}

	

}
