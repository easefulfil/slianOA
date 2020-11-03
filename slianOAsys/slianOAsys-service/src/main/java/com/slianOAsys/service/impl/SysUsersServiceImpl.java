package com.slianOAsys.service.impl;

import java.sql.Connection;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.slianOAsys.dao.SysUsersMapper;
import com.slianOAsys.model.*;
import com.slianOAsys.model.SysUsersExample.Criteria;
import com.slianOAsys.model.ex.SysUsersEx;
import com.slianOAsys.page.Page;
import com.slianOAsys.service.SysAuthenticationInfoService;
import com.slianOAsys.service.SysUsersRolesService;
import com.slianOAsys.service.SysUsersService;
import com.slianOAsys.service.utils.CommonUtils;

public class SysUsersServiceImpl implements SysUsersService {

	@Autowired
	private SysUsersMapper usersMapper;

	@Autowired
	private SysUsersRolesService usersRolesService;

	@Autowired
	private DataSource dataSource;

	@Autowired
	private SysAuthenticationInfoService authenticationInfoService;

	public Map<String,Object> getHttpUsers(Integer pageSize,Integer pageIndex,SysUsers user) {

		// 获取包含员工或客户信息的用户对象
		/*
		 * select
		 * id,username,createtime,status,last_login_time,last_login_ip,type
		 * ,user_detail_id, case when type ='员工' then (SELECT employee_name from
		 * employee where employee_id = user_detail_id) when type = '客户'then
		 * (SELECT customer_name from customer where customer_id =
		 * user_detail_id) end user_detail_name from users
		 * 
		 * select u.id
		 * id,username,createtime,status,last_login_time,last_login_ip
		 * ,type,e.employee_id detail_id, e.employee_name name from users u LEFT
		 * JOIN employee e on u.user_detail_id = e.employee_id where type = '员工'
		 * or type is NULL UNION select u.id
		 * id,username,createtime,status,last_login_time
		 * ,last_login_ip,type,c.customer_id detail_id, c.customer_name name
		 * from users u LEFT JOIN customer c on u.user_detail_id = c.customer_id
		 * where type = '客户'
		 */
		
		SysUsersExample example=new SysUsersExample();
		Criteria criteria = example.createCriteria();
		
		List<String> typeList = new ArrayList<String>();
		 if(user.getType() == null ){
			typeList.add("员工");
			typeList.add("嘉宾");
			typeList.add("客商");
			
			
		}else{
			String[] types = user.getType().split(",");
			for(String type:types)
				typeList.add(type);
			
			
		}
		 criteria.andTypeIn(typeList);//criteria.andTypeEqualTo(user.getType());
			
		
		if (!StringUtils.isEmpty(user.getUserName())) {
			criteria.andUserNameLike("%" +user.getUserName() + "%");
		}
		
		int totalrecords=usersMapper.countByExample(example);
		/**
		 * for my sql db
		 */
			Page page = new Page();
			
			page.setBegin((pageIndex-1)*pageSize);
			page.setLength(pageSize);
			
			example.setPage(page);
			
			List<SysUsers> list = usersMapper.selectByExample(example);
			
		/**
		 * for  sql server db
		 */
//		example.setPageIndex(pageIndex);
//		example.setPageSize(pageSize);
//	
//		example.setOrderByClause("id desc");
//		
//		List<SysUsers> list=usersMapper.selectPage(example);
		
		if(list == null || list.size() <1){
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("total", totalrecords);
			map.put("rows",list);
			return map;
		}
		
		StringBuffer sb=new StringBuffer();
		sb.append('(');
		for(int i=0;i<list.size()-1;i++){
			sb.append(list.get(i).getUserId());
			sb.append(',');
		}
		sb.append(list.get(list.size()-1).getUserId());
		sb.append(')');
		
		
		Connection conn = null;
		Statement stmt = null;
		
		
		ResultSet rs = null;
		
		
		List<SysUsersEx> listHttpUsers = new ArrayList<SysUsersEx>();

		try {
			conn = dataSource.getConnection();

			stmt = conn.createStatement();
			System.out.println(sb);
			// 按照起运港，目的港，分组获取推荐的报价
			String sql =
//					"select  u.id id,username,createtime,last_login_time,last_login_ip,type,user_detail_id,e.employee_name detail_name"
//					+ " from sys_users u LEFT JOIN sys_employee e on u.user_detail_id = e.employee_id "
//					+ " where (type =  '员工' or type is NULL ) and u.id in "+ sb
//					+ " UNION"
//					+ " select u.id id,username,createtime,last_login_time,last_login_ip,u.type type,user_detail_id,c.customer_name detail_name"
//					+ " from sys_users u LEFT JOIN sys_customer c on u.user_detail_id = c.customer_id"
//					+ " where u.type in( '嘉宾','客商') and u.id in "+sb;
						
					"select  u.user_id ,u.employee_id,user_name,u.create_time,last_login_time,last_login_ip,type,user_detail_id,e.employee_name detail_name"
			+ " from sys_users u LEFT JOIN sys_employee e on u.employee_id = e.employee_id "
			+ " where (type =  '员工' or type is NULL ) and u.user_id in "+ sb;
//			if(name == null || "".equals(name))
//				;
//			else
//				sql = "select * from ("+sql+") t where username like '%"+name+"%' ";

			rs = stmt.executeQuery(sql);

			this.RestuSetToListHttpUsers(conn,rs, listHttpUsers);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				rs.close();
				stmt.close();
				conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", totalrecords);
		map.put("rows",listHttpUsers);

		return map;
		
	}


	
	private String getRoleNames(Connection conn,Integer userId) throws SQLException{
		
		
//		select * 
//		from users_roles u,roles r
//		where u.rid = r.id and uid=1
		
		String roleName = "";
		String sql = "select u.role_id,name from sys_users_roles u,sys_roles r where u.role_id = r.role_id and user_id="+userId;
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		while (rs.next()) {
			
			roleName += rs.getString("name") +"  ";
		}
		
		rs.close();
		stmt.close();
		
		return roleName;
	}
	private void RestuSetToListHttpUsers(Connection conn,ResultSet rs, List<SysUsersEx> listHttpUsers)
			throws SQLException {
		
		
		Integer userId = 0;

		while (rs.next()) {

			SysUsersEx hu = new SysUsersEx();
			
			userId = rs.getInt("user_id");
			hu.setUserId(userId);
			hu.setUserName(rs.getString("user_name"));
			hu.setEmployeeId(rs.getInt("employee_id"));
			hu.setsCreateTime(rs.getString("create_time"));
//			hu.setStatus(rs.getString("status"));
			hu.setsLastLoginTime(rs.getString("last_login_time"));
			hu.setLastLoginIp(rs.getString("last_login_ip"));
			hu.setType(rs.getString("type"));
			hu.setUserDetailId(rs.getInt("user_detail_id"));
			hu.setUserDetailName(rs.getString("detail_name"));
			
			hu.setRoleNames(this.getRoleNames(conn, userId));

			
			listHttpUsers.add(hu);
		}

	}

	public List<SysUsers> getUsers() {

		return usersMapper.selectByExample(null);
	}

	public SysUsersServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isExistUsers(Integer roleId) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean insert(SysUsers user) {

		// TODO Auto-generated method stub
		
		user.setCreateTime(new Date());
		return usersMapper.insertSelective(user) == 1 ? true : false;
	}

	@Override
	@Transactional
	public boolean delete(String ids) {


		SysUsersExample example = new SysUsersExample();

		example.or().andUserIdIn(CommonUtils.idsArrayToList(ids));
		
		List<SysUsers> userList = usersMapper.selectByExample(null);
		
		
		try{
			
			for(SysUsers user:userList){
				
				// 将用户定义的角色删除 ,将分配该用户的认证信息删除
				if(!usersRolesService.delete(user.getUserId().toString(),"") ||
							!authenticationInfoService.deleteByUserId(user.getUserId()))
					return false;
				
			}
			usersMapper.deleteByExample(example) ;
			
			
		}catch(Exception e){
			e.printStackTrace();
			
			return false;
			
		}

		return true;
	}

	@Override
	public boolean update(SysUsers user) {
		// TODO Auto-generated method stub
		return usersMapper.updateByPrimaryKeySelective(user) == 1 ? true : false;
	}



	@Override
	public SysUsers getUsers(Integer userId) {
		// TODO Auto-generated method stub
		return usersMapper.selectByPrimaryKey(userId);
	}



	@Override
	public boolean deleteByUserDetailId(List<Integer> userDetailIds,List<String> types) {
		// TODO Auto-generated method stub
		SysUsersExample example = new SysUsersExample();

		example.or().andUserDetailIdIn(userDetailIds).andTypeIn(types);
		
		return usersMapper.deleteByExample(example) > 0 ? true:false;
	}



}
