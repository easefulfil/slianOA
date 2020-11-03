package com.sliansoft.slianOA.dataaccess.daoEx.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.sliansoft.slianOA.dataaccess.dao.SysEmployeeMapper;
import com.sliansoft.slianOA.dataaccess.daoEx.SysEmployeeMapperEx;
import com.sliansoft.slianOA.dataaccess.model.SysEmployee;
import com.sliansoft.slianOA.dataaccess.model.SysEmployeeExample;
import com.sliansoft.slianOA.dataaccess.model.SysEmployeeExample.Criteria;
import com.sliansoft.slianOA.dataaccess.model.SysUser;
import com.sliansoft.slianOA.dataaccess.utils.DataAuthorityRegister;

public class SysEmployeeMapperExImpl implements SysEmployeeMapperEx {

	@Autowired
	private SysEmployeeMapper sysEmployeeMapper;

	@Autowired
	private HttpSession session;

	@Override
	public int countByExample(SysEmployeeExample example) {
		// TODO Auto-generated method stub
		if (session.getAttribute("dataAuthorityRegister") == null)
			return sysEmployeeMapper.countByExample(example);

		this.setExample(example);

		return sysEmployeeMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(SysEmployeeExample example) {
		// TODO Auto-generated method stub

//		if (session.getAttribute("dataAuthorityRegister") == null)
//			return employeeMapper.deleteByExample(example);
//
//		this.setExample(example);

		return sysEmployeeMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer employeeId) {
		// TODO Auto-generated method stub

//		if (session.getAttribute("dataAuthorityRegister") == null)
//			return 0;
//
//		Employee employee = employeeMapper.selectByPrimaryKey(employeeId);
//
//		DataAuthorityRegister dataAuthorityRegister = (DataAuthorityRegister) session
//				.getAttribute("dataAuthorityRegister");
//
//		// if (dataAuthorityRegister != null) {
//		Thread currentTh = Thread.currentThread();
//		if (dataAuthorityRegister.isDataUnderControl(currentTh.getId())) {
//
//			Set<Integer> orgList = dataAuthorityRegister.getOrgList(currentTh
//					.getId());
//			List<Integer> orgStringList = new ArrayList<Integer>();
//
//			if (orgList.size() == 1 && orgList.contains(new Integer(-1))) {
//				if (!employee.getEmployeeId().equals(
//						((Employee) session.getAttribute("employee"))
//								.getEmployeeId())) {
//					employeeId = -1;
//				}
//			} else {
//				for (Integer org : orgList) {
//					orgStringList.add(org);
//				}
//				if (!orgStringList.contains(employee.getEmployeeAccessGroup())) {
//					employeeId = -1;
//				}
//			}
//		}

		return sysEmployeeMapper.deleteByPrimaryKey(employeeId);
		// } else
		// return 0;
	}

	@Override
	public int insert(SysEmployee record) {
		// TODO Auto-generated method stub
		int re = 0;
		try {
			SysEmployee sysEmployee = (SysEmployee) session.getAttribute("employee");

			record.setCreator(sysEmployee.getEmployeeId());
			record.setCreateTime(new Date());

			if (record.getEmployeeDepartment() == null)
				re = 0;
			else {
				record.setAccessGroup(record.getEmployeeDepartment());

				re = sysEmployeeMapper.insert(record);
			}
		} catch (Exception e) {
			re = 0;
		}
		return re;
	}

	@Override
	public int insertSelective(SysEmployee record) {
		// TODO Auto-generated method stub
		int re = 0;
		try {
			SysEmployee sysEmployee = (SysEmployee) session.getAttribute("employee");
			record.setCreator(sysEmployee.getEmployeeId());
			record.setCreateTime(new Date());
			if (record.getEmployeeDepartment() == null)
				re = 0;
			else {
				record.setAccessGroup(record.getEmployeeDepartment());
				re = sysEmployeeMapper.insertSelective(record);
			}
		} catch (Exception e) {
			re = 0;
		}
		return re;
	}

	private void setExample(SysEmployeeExample example) {

		DataAuthorityRegister dataAuthorityRegister = (DataAuthorityRegister) session
				.getAttribute("dataAuthorityRegister");

		// if (dataAuthorityRegister != null) {
		Thread currentTh = Thread.currentThread();

		if (dataAuthorityRegister.isDataUnderControl(currentTh.getId())) {

			Set<Integer> orgList = dataAuthorityRegister.getOrgList(currentTh
					.getId());

			List<Integer> orgStringList = new ArrayList<Integer>();

			if (orgList.size() == 1 && orgList.contains(new Integer(-1))) {

				if (example.getOredCriteria().size() == 0) {

					example.createCriteria().andEmployeeIdEqualTo(
							((SysEmployee) session.getAttribute("employee"))
									.getEmployeeId());

				} else {
					for (Criteria criteria : example.getOredCriteria()) {

						criteria.andEmployeeIdEqualTo(((SysEmployee) session
								.getAttribute("employee")).getEmployeeId());
					}

				}

			} else {

				for (Integer org : orgList) {

					orgStringList.add(org);
				}

				if (example.getOredCriteria().size() == 0) {

					example.createCriteria().andAccessGroupIn(
							orgStringList);
				} else {

					for (Criteria criteria : example.getOredCriteria()) {
						criteria.andAccessGroupIn(orgStringList);
					}
				}
			}
		}
	}

	@Override
	public List<SysEmployee> selectByExample(SysEmployeeExample example) {
		// TODO Auto-generated method stub

		if (session.getAttribute("dataAuthorityRegister") == null)
			return sysEmployeeMapper.selectByExample(example);

		this.setExample(example);
		// }
		return sysEmployeeMapper.selectByExample(example);
	}
	@Override
	public List<SysEmployee> selectByExampleWithOutAuth(SysEmployeeExample example) {
		return sysEmployeeMapper.selectByExample(example);
	}
	@Override
	public SysEmployee selectByPrimaryKey(Integer employeeId) {
		// TODO Auto-generated method stub
		SysEmployee sysEmployee = sysEmployeeMapper.selectByPrimaryKey(employeeId);

//		if (session.getAttribute("dataAuthorityRegister") == null)
//			return employee;
//
//		DataAuthorityRegister dataAuthorityRegister = (DataAuthorityRegister) session
//				.getAttribute("dataAuthorityRegister");
//
//		// if(dataAuthorityRegister!=null){
//
//		Thread currentTh = Thread.currentThread();
//
//		if (dataAuthorityRegister.isDataUnderControl(currentTh.getId())) {
//
//			Set<Integer> orgList = dataAuthorityRegister.getOrgList(currentTh
//					.getId());
//
//			List<Integer> orgStringList = new ArrayList<Integer>();
//
//			if (orgList.size() == 1 && orgList.contains(new Integer(-1))) {
//
//				if (!employeeId.equals(((Employee) session
//						.getAttribute("employee")).getEmployeeId())) {
//					employee = null;
//				}
//			} else {
//				for (Integer org : orgList) {
//					orgStringList.add(org);
//				}
//				if (!orgStringList.contains(employee.getEmployeeAccessGroup())) {
//					employee = null;
//				}
//			}
//		}
		// }else
		// employee=null;
		return sysEmployee;
	}

	@Override
	public int updateByExampleSelective(SysEmployee record, SysEmployeeExample example) {
		// TODO Auto-generated method stub

//		if (session.getAttribute("dataAuthorityRegister") == null)
//			;
//		else
//			this.setExample(example);

		// DataAuthorityRegister dataAuthorityRegister = (DataAuthorityRegister)
		// session
		// .getAttribute("dataAuthorityRegister");
		//
		// // if (dataAuthorityRegister != null) {
		// Thread currentTh = Thread.currentThread();
		// if (dataAuthorityRegister.isDataUnderControl(currentTh.getId())) {
		//
		// Set<Integer> orgList = dataAuthorityRegister.getOrgList(currentTh
		// .getId());
		//
		// List<String> orgStringList = new ArrayList<String>();
		//
		// if (orgList.size() == 1 && orgList.contains(new Integer(-1))) {
		//
		// for (Criteria criteria : example.getOredCriteria()) {
		// criteria.andEmployeeIdEqualTo(((Employee) session
		// .getAttribute("employee")).getEmployeeId());
		// }
		// } else {
		// for (Integer org : orgList) {
		// orgStringList.add("{\"department\":" + org + "}");
		// }
		// if (example.getOredCriteria().size() == 0) {
		// example.createCriteria().andAccessGroupIn(
		// orgStringList);
		// } else {
		// for (Criteria criteria : example.getOredCriteria()) {
		// criteria.andAccessGroupIn(orgStringList);
		// }
		// }
		// }
		// }
//		record.setAccessGroup(null);
//		record.setCreator(null);
//		record.setCreateTime(null);
		return sysEmployeeMapper.updateByExampleSelective(record, example);
		// } else
		// return 0;
	}

	@Override
	public int updateByExample(SysEmployee record, SysEmployeeExample example) {

//		if (session.getAttribute("dataAuthorityRegister") == null)
//			;
//		else
//			this.setExample(example);

		// TODO Auto-generated method stub
		// DataAuthorityRegister dataAuthorityRegister = (DataAuthorityRegister)
		// session
		// .getAttribute("dataAuthorityRegister");
		// // if (dataAuthorityRegister != null) {
		// Thread currentTh = Thread.currentThread();
		// if (dataAuthorityRegister.isDataUnderControl(currentTh.getId())) {
		// Set<Integer> orgList = dataAuthorityRegister.getOrgList(currentTh
		// .getId());
		// List<String> orgStringList = new ArrayList<String>();
		// if (orgList.size() == 1 && orgList.contains(new Integer(-1))) {
		// for (Criteria criteria : example.getOredCriteria()) {
		// criteria.andEmployeeIdEqualTo(((Employee) session
		// .getAttribute("employee")).getEmployeeId());
		// }
		// } else {
		// for (Integer org : orgList) {
		// orgStringList.add("{\"employee\":" + org + "}");
		// }
		// if (example.getOredCriteria().size() == 0) {
		// example.createCriteria().andAccessGroupIn(
		// orgStringList);
		// } else {
		// for (Criteria criteria : example.getOredCriteria()) {
		// criteria.andAccessGroupIn(orgStringList);
		// }
		// }
		// }
		// }
		return sysEmployeeMapper.updateByExample(record, example);
		// } else
		// return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(SysEmployee record) {
//
//		if (session.getAttribute("dataAuthorityRegister") == null){
//			record.setAccessGroup(null);
//			record.setCreateTime(null);
//			record.setCreator(null);
//			return employeeMapper.updateByPrimaryKeySelective(record);
//		}
//
//		// TODO Auto-generated method stub
//
//		Integer employeeId = record.getEmployeeId();
//
//		Employee employee = employeeMapper.selectByPrimaryKey(employeeId);
//		// Employee employee = employeeMapper.selectByPrimaryKey(employeeId);
//		DataAuthorityRegister dataAuthorityRegister = (DataAuthorityRegister) session
//				.getAttribute("dataAuthorityRegister");
//
////		if (dataAuthorityRegister != null) {
//			Thread currentTh = Thread.currentThread();
//			if (dataAuthorityRegister.isDataUnderControl(currentTh.getId())) {
//				Set<Integer> orgList = dataAuthorityRegister
//						.getOrgList(currentTh.getId());
//				List<Integer> orgStringList = new ArrayList<Integer>();
//				if (orgList.size() == 1 && orgList.contains(new Integer(-1))) {
//					if (!employee.getEmployeeId().equals(
//							((Employee) session.getAttribute("employee"))
//									.getEmployeeId())) {
//						employeeId = -1;
//					}
//				} else {
//					for (Integer org : orgList) {
//						orgStringList.add(org);
//					}
//					if (!orgStringList.contains(employee
//							.getEmployeeAccessGroup())) {
//						employeeId = -1;
//					}
//				}
//			}
//			if (employeeId.equals(new Integer(-1)))
//				return 0;
//			else {
////				record.setAccessGroup(null);
//				record.setCreateTime(null);
//				record.setCreator(null);
				return sysEmployeeMapper.updateByPrimaryKeySelective(record);
//			}
		// } else
		// return 0;
	}

	@Override
	public int updateByPrimaryKey(SysEmployee record) {
		// TODO Auto-generated method stub
//		if (session.getAttribute("dataAuthorityRegister") == null){
//			Integer employeeId = record.getEmployeeId();
//			Employee employee = employeeMapper.selectByPrimaryKey(employeeId);
//			record.setAccessGroup(employee.getEmployeeAccessGroup());
//			record.setCreateTime(employee
//					.getEmployeeCreationTime());
//			record.setCreator(employee.getEmployeeCreator());
//			return employeeMapper.updateByPrimaryKey(record);
//		}
//		
//		Integer employeeId = record.getEmployeeId();
//		Employee employee = employeeMapper.selectByPrimaryKey(employeeId);
//		DataAuthorityRegister dataAuthorityRegister = (DataAuthorityRegister) session
//				.getAttribute("dataAuthorityRegister");
////		if (dataAuthorityRegister != null) {
//			Thread currentTh = Thread.currentThread();
//			if (dataAuthorityRegister.isDataUnderControl(currentTh.getId())) {
//				Set<Integer> orgList = dataAuthorityRegister
//						.getOrgList(currentTh.getId());
//				List<Integer> orgStringList = new ArrayList<Integer>();
//				if (orgList.size() == 1 && orgList.contains(new Integer(-1))) {
//					if (!employee.getEmployeeId().equals(
//							((Employee) session.getAttribute("employee"))
//									.getEmployeeId())) {
//						employeeId = -1;
//					}
//				} else {
//					for (Integer org : orgList) {
//						orgStringList.add(org);
//					}
//					if (!orgStringList.contains(employee
//							.getEmployeeAccessGroup())) {
//						employeeId = -1;
//					}
//				}
//			}
//			if (employeeId.equals(new Integer(-1)))
//				return 0;
//			else {
//				record.setAccessGroup(employee.getEmployeeAccessGroup());
//				record.setCreateTime(employee
//						.getEmployeeCreationTime());
//				record.setCreator(employee.getEmployeeCreator());
				return sysEmployeeMapper.updateByPrimaryKey(record);
//			}
//		} else
//			return 0;
	}

	@Override
	public List<SysEmployee> selectPage(SysEmployeeExample example) {
		
		this.setExample(example);
		// TODO Auto-generated method stub
//		if (session.getAttribute("dataAuthorityRegister") == null)
//			return employeeMapper.selectPage(example);
//		
//		this.setExample(example);
		
//		DataAuthorityRegister dataAuthorityRegister = (DataAuthorityRegister) session
//				.getAttribute("dataAuthorityRegister");
//		if (dataAuthorityRegister != null) {
//			Thread currentTh = Thread.currentThread();
//			if (dataAuthorityRegister.isDataUnderControl(currentTh.getId())) {
//				Set<Integer> orgList = dataAuthorityRegister
//						.getOrgList(currentTh.getId());
//				List<String> orgStringList = new ArrayList<String>();
//				if (orgList.size() == 1 && orgList.contains(new Integer(-1))) {
//					for (Criteria criteria : example.getOredCriteria()) {
//						criteria.andEmployeeIdEqualTo(((Employee) session
//								.getAttribute("employee")).getEmployeeId());
//					}
//				} else {
//					for (Integer org : orgList) {
//						orgStringList.add("{\"department\":" + org + "}");
//					}
//					if (example.getOredCriteria().size() == 0) {
//						example.createCriteria().andAccessGroupIn(
//								orgStringList);
//					} else {
//						for (Criteria criteria : example.getOredCriteria()) {
//							criteria.andAccessGroupIn(orgStringList);
//						}
//					}
//				}
//			}
//		}
		return sysEmployeeMapper.selectPage(example);
	}

	@Override
	public List<SysEmployee> selectInit(SysEmployeeExample example) {
		
//		this.setExample(example);
		return sysEmployeeMapper.selectByExample(example);
	}

	@Override
	public int insertAndGetId(SysEmployee record) {
		int re = 0;
		try {
			/*Integer employeeId = ((Employee) session.getAttribute("employee")).getEmployeeId();
			Employee employee = employeeMapper.selectByPrimaryKey(employeeId);*/
//			SysEmployee sysEmployee =(SysEmployee) session.getAttribute("employee");
//			record.setCreator(sysEmployee.getEmployeeId());
			record.setCreateTime(new Date());
			if (record.getEmployeeDepartment() == null)
				re = 0;
			else {
				record.setAccessGroup(record.getEmployeeDepartment());
				re = sysEmployeeMapper.insertAndGetId(record);
	//			sysEmployeeMapper.updateByPrimaryKeySelective(record);
				int employeeId = record.getEmployeeId();
				record.setCreator(employeeId);
				sysEmployeeMapper.updateByPrimaryKeySelective(record);
	//			System.out.println("ID是什么呀"+record.getEmployeeId());
			}
		} catch (Exception e) {
			re = 0;
		}
		return re;
	}

//	@Override
//	public List<Employee> selectByExampleWithBLOBs(EmployeeExample example) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public int updateByExampleWithBLOBs(Employee record, EmployeeExample example) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public int updateByPrimaryKeyWithBLOBs(Employee record) {
//		// TODO Auto-generated method stub
//		return 0;
//	}



}
