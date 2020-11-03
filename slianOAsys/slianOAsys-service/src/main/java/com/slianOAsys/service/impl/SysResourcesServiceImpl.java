package com.slianOAsys.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slianOAsys.dao.SysResourcesMapper;
import com.slianOAsys.model.SysResources;
import com.slianOAsys.model.SysResourcesExample;
import com.slianOAsys.model.SysResourcesExample.Criteria;
import com.slianOAsys.service.SysResourcesService;
import com.slianOAsys.service.utils.SysConst;
import com.slianOAsys.service.utils.SysResourcesTree;

@Service
public class SysResourcesServiceImpl implements SysResourcesService {

	@Autowired
	private SysResourcesMapper resourcesMapper;

	public boolean getChildResources(String pid) {

		if (pid == null || "".equals(pid))
			return false;

		SysResourcesExample example = new SysResourcesExample();
		Criteria criteria = example.createCriteria();

		criteria.andParentIdEqualTo(Integer.valueOf(pid));

		List<SysResources> resList = resourcesMapper.selectByExample(example);

		if (resList == null || resList.size() < 1)
			return false;
		else
			return true;
	}

	public List<SysResources> getResources(List<String> types) {

		SysResourcesExample example = new SysResourcesExample();

		example.or().andTypeIn(types);
		
		example.setOrderByClause(" resource_id asc");

		return resourcesMapper.selectByExample(example);

	}

	public boolean insert(SysResources res) {

		if (resourcesMapper.insertSelective(res) != 1)
			return false;

		this.init_RESOURCESTREE_UNINCLUDE_BUSINESS();
		this.init_RESOURCESTREE();

		return true;
	}

	/**
	 * 需判断资源是否已分配给角色
	 */
	public boolean delete(SysResources res) {
		
		if(res == null)
			return false;
		
		if (this.getChildResources(res.getResourceId().toString()))
			 return false;

		if (resourcesMapper.deleteByPrimaryKey(res.getResourceId()) != 1)
			return false;

		this.init_RESOURCESTREE_UNINCLUDE_BUSINESS();
		this.init_RESOURCESTREE();

		return true;
	}
	

	public boolean update(SysResources res) {

		if (resourcesMapper.updateByPrimaryKey(res) != 1)
			return false;

		this.init_RESOURCESTREE_UNINCLUDE_BUSINESS();
		this.init_RESOURCESTREE();

		return true;
	}

	@Override
	public void init_RESOURCESTREE_UNINCLUDE_BUSINESS() {
		// TODO Auto-generated method stub

		List<String> types = new ArrayList<String>();
		types.add("用户");
		types.add("数据");

		SysConst.RESOURCESTREE_UNINCLUDE_BUSINESS = new SysResourcesTree(
				this.getResources(types));// basicDataSetService.getALLBasicDataSet();

	}
	
	@Override
	public void init_RESOURCESTREE() {
		// TODO Auto-generated method stub

		List<String> types = new ArrayList<String>();
		types.add("用户");
		types.add("数据");
		types.add("业务");

		SysConst.RESOURCESTREE = new SysResourcesTree(
				this.getResources(types));// basicDataSetService.getALLBasicDataSet();

	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

}
