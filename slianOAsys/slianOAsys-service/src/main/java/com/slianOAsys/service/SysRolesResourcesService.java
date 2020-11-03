package com.slianOAsys.service;

import java.util.List;

import com.slianOAsys.service.utils.SysOrganizationStructureTreeNode;
import com.slianOAsys.service.utils.SysResourcesTreeNode;

import net.sf.json.JSONArray;

public interface SysRolesResourcesService {

	/**
	 * 根据resourceId 返回其所有的叶子节点,并将其保存到role_resources表中
	 * 
	 * @param roleId
	 * @param resourceId
	 * @return
	 */
	public boolean insert(String roleId, String resourceId);
	
	public boolean insert(String roleId, String resourceId,String orgStrId);

	public List<SysResourcesTreeNode> getRolesResources(String roleId);
	
	public List<SysOrganizationStructureTreeNode> getRolesResourcesOS(String roleId,String resourceId);
	
	public boolean delete(Integer roleId);

	public boolean delete(String roleId, String resourceId);
	
	public boolean delete(String roleId, String resourceId,String orgStrId);
	
	/**
	 * 根据指定角色返回以 逗号分割的“,”资源Id字符串,用于前端设置菜单是否可以点击用
	 * @param roleIds 返回形式RESOURCE_1,RESOURCE_2,RESOURCE_3
	 * @return
	 */
	public List<Integer> getResourcesIdList(Integer userId);
	
	
	/**
	 * 根据指定角色返回以 逗号分割的“,”资源Id字符串,用于前端设置菜单是否可以点击用
	 * @param roleIds 返回形式RESOURCE_1,RESOURCE_2,RESOURCE_3
	 * @return
	 */
	public String getResourcesIds(Integer userId);
	
	public void init_ROLE_RESOURCE();

	public JSONArray getRolesResourcesOSTest(String parameter, String parameter2);

	public JSONArray getRolesResourcesInitOS();


}
