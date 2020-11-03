package com.slianOAsys.service;

import java.util.List;

import com.slianOAsys.model.SysResources;

public interface SysResourcesService {

	public boolean getChildResources(String pid);
	
	public void init_RESOURCESTREE_UNINCLUDE_BUSINESS();
	
	public List<SysResources> getResources(List<String> types);

	public boolean insert(SysResources res);

	public boolean delete(SysResources res);
	
	public boolean delete(String id);

	public boolean update(SysResources res);

	public void init_RESOURCESTREE();
}
