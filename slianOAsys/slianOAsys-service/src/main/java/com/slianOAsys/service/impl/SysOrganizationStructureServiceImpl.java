package com.slianOAsys.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.codehaus.plexus.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slianOAsys.dao.SysOrganizationStructureMapper;
import com.slianOAsys.model.SysOrganizationStructure;
import com.slianOAsys.model.SysOrganizationStructureExample;
import com.slianOAsys.model.SysOrganizationStructureExample.Criteria;
import com.slianOAsys.page.Page;
import com.slianOAsys.service.SysOrganizationStructureService;
import com.slianOAsys.service.utils.DateJsonValueProcessor;
import com.slianOAsys.service.utils.SysConst;
import com.slianOAsys.service.utils.SysOrganizationStructureTree;
import com.slianOAsys.service.utils.SysOrganizationStructureTreeNode;

@Service
public class SysOrganizationStructureServiceImpl implements
		SysOrganizationStructureService {

	@Autowired
	private SysOrganizationStructureMapper sysOrganizationStructureMapper;
	@Autowired
	@Override
	public void init_ORGANIZATIONSTRUCTURE_TREE() {
		// TODO Auto-generated method stub

		SysConst.ORGANIZATIONSTRUCTURE_TREE = new SysOrganizationStructureTree(
				this.getOrganizationStructure());// basicDataSetService.getALLBasicDataSet();
	}

	@Override
	public List<SysOrganizationStructure> getOrganizationStructure() {
		// TODO Auto-generated method stub

		 SysOrganizationStructureExample example = new
		 SysOrganizationStructureExample();
		 
		/* example.setOrderByClause("id asc");*/
		//
		// example.or().andTypeIn(types);

		return sysOrganizationStructureMapper.selectByExample(example);
	}

	@Override
	public boolean insert(SysOrganizationStructure os) {
		// TODO Auto-generated method stub
		
		if(StringUtils.isEmpty(os.getSuperior()))
				os.setSuperior( "0");
		
		if (sysOrganizationStructureMapper.insertSelective(os) != 1)
			return false;

		this.init_ORGANIZATIONSTRUCTURE_TREE();

		return true;

	}

	@Override
	public boolean delete(SysOrganizationStructure os) {
		// TODO Auto-generated method stub

		if (sysOrganizationStructureMapper.deleteByPrimaryKey(os.getOsId()) != 1)
			return false;

		this.init_ORGANIZATIONSTRUCTURE_TREE();

		return true;

	}

	@Override
	public boolean update(SysOrganizationStructure os) {
		// TODO Auto-generated method stub

		if (sysOrganizationStructureMapper.updateByPrimaryKey(os) != 1)
			return false;

		this.init_ORGANIZATIONSTRUCTURE_TREE();

		return true;

	}

	@Override
	public boolean getChildOrganizationStructures(String pid) {
		// TODO Auto-generated method stub

		if (pid == null || "".equals(pid))
			return false;

		SysOrganizationStructureExample example = new SysOrganizationStructureExample();

		example.or().andSuperiorEqualTo(pid);

		List<SysOrganizationStructure> resList = sysOrganizationStructureMapper
				.selectByExample(example);

		if (resList == null || resList.size() < 1)
			return false;
		else
			return true;

	}

	@Override
	public Map<String, Object> getOrganizationByPage(SysOrganizationStructure os,
			Integer pageSize, Integer pageNow) {
		// public Map<String, Object> getOrganizationByPage(Integer pageSize,
		// Integer pageNow) {
		SysOrganizationStructureExample example = new SysOrganizationStructureExample();
		Criteria criteria = example.createCriteria();
		if (StringUtils.isNotEmpty(os.getName())) {
			criteria.andNameLike("%" + os.getName() + "%");
		}
		if (StringUtils.isNotEmpty(os.getPhone())) {
			criteria.andPhoneLike("%" + os.getPhone() + "%");
		}
		criteria.andOsIdIsNotNull();
		int total = sysOrganizationStructureMapper.countByExample(example);
		/**
		 * for my sql db
		 */
			Page page = new Page();
			
			page.setBegin((pageNow-1)*pageSize);
			page.setLength(pageSize);
			
			List<SysOrganizationStructure> oslist = sysOrganizationStructureMapper.selectByExample(example);

			
		/**
		 * for  sql server db
		 */
//		example.setPageIndex(pageNow);
//		example.setPageSize(pageSize);
//		List<SysOrganizationStructure> oslist = sysOrganizationStructureMapper
//				.selectPage(example);
		JsonConfig config = new JsonConfig();
		config.setIgnoreDefaultExcludes(false);
		config.registerJsonValueProcessor(Date.class,
				new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rows", JSONArray.fromObject(oslist, config));
		map.put("total", total);

		return map;
	}

	@Override
	public String delete(Integer id) {
		
		SysOrganizationStructureTreeNode  ostn = SysConst.ORGANIZATIONSTRUCTURE_TREE.getNode(id);
		
		//如果存在子节点不允许删除
		if(ostn.getChildren() != null && ostn.getChildren().size() >0 )
			return "该节点有子节点不允许删除！";
		
		try{
			if (sysOrganizationStructureMapper.deleteByPrimaryKey(id) != 1)
				return "error";
		}catch(Exception e){
			String message = e.getMessage();
			if(message.contains("employee_department"))
				return "删除失败！<br>该部门有员工。";
			else
				return "删除失败！<br>数据库异常。";
		}
		this.init_ORGANIZATIONSTRUCTURE_TREE();
		return "success";
	}
	//
	// @Override
	// public String deleteOsById(String[] ids) {
	// for(String id :ids){
	// sysOrganizationStructureMapper.deleteByPrimaryKey(Integer.parseInt(id));
	// }
	// return "success" ;
	// }

	

	@Override
	public boolean updateDefault(SysOrganizationStructure os) {
		int i = sysOrganizationStructureMapper.updateByPrimaryKeySelective(os);
		if(i>0){
			return true;
		}else{
			return false;
		}

		
	}


}
