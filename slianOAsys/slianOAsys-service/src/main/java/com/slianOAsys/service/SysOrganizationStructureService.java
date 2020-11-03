package com.slianOAsys.service;

import java.util.List;
import java.util.Map;

import com.slianOAsys.model.SysOrganizationStructure;

import net.sf.json.JSONArray;

public interface SysOrganizationStructureService {
	
	public boolean getChildOrganizationStructures(String pid);

	public void init_ORGANIZATIONSTRUCTURE_TREE();
	
	public List<SysOrganizationStructure> getOrganizationStructure();

	public boolean insert(SysOrganizationStructure os);

	public boolean delete(SysOrganizationStructure os);


	public boolean update(SysOrganizationStructure os);
	
	
	public Map<String,Object> getOrganizationByPage(SysOrganizationStructure os, Integer pageSize,Integer pageNow);
	
//	public String deleteOsById(String  ids[]);
	
	public String delete(Integer  id);

	
	

	public boolean updateDefault(SysOrganizationStructure organizationStructure);
}
