package com.slianOAsys.service.impl;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.slianOAsys.dao.SysRolesResourcesMapper;
import com.slianOAsys.model.SysOrganizationStructure;
import com.slianOAsys.model.SysResources;
import com.slianOAsys.model.SysRolesResources;
import com.slianOAsys.model.SysRolesResourcesExample;
import com.slianOAsys.model.SysUsersRoles;
import com.slianOAsys.model.SysRolesResourcesExample.Criteria;
import com.slianOAsys.service.SysRolesResourcesService;
import com.slianOAsys.service.SysUsersRolesService;
import com.slianOAsys.service.utils.RoleResourceOrganization;
import com.slianOAsys.service.utils.SysConst;
import com.slianOAsys.service.utils.SysOrganizationStructureTreeNode;
import com.slianOAsys.service.utils.SysResourcesTreeNode;

@Service
public class SysRolesResourcesServiceImpl implements SysRolesResourcesService {

	@Autowired
	private SysRolesResourcesMapper rolesResourcesMapper;

	@Autowired
	private SysResourcesServiceImpl resourcesService;

	@Autowired
	private SysUsersRolesService usersRolesService;

	@Autowired
	private SysOrganizationStructureServiceImpl organizationStructureService;

	/**
	 * 获得所有的资源，并根据指定角色已分配的资源，设置资源node checked= true
	 */
	public List<SysResourcesTreeNode> getRolesResources(String roleId) {

		if (roleId == null || "".equals(roleId))
			return null;

		SysRolesResourcesExample example = new SysRolesResourcesExample();

		example.or().andRoleIdEqualTo(Integer.parseInt(roleId));
		
		example.setOrderByClause(" resources_id asc");

		List<SysRolesResources> rsList = rolesResourcesMapper
				.selectByExample(example);

		List<String> types = new ArrayList<String>();
		types.add("用户");
		types.add("数据");

		List<SysResources> resList = resourcesService.getResources(types);
		// Map<Integer,ResourcesTreeNode> rtnMap =
		// Const.RESOURCESTREE_UNINCLUDE_BUSINESS.getTree();

		List<SysResourcesTreeNode> rtnList = new ArrayList<SysResourcesTreeNode>();
		for (SysResources res : resList) {

			SysResourcesTreeNode rtNode = new SysResourcesTreeNode();

//			ReflectionUtils.parentToChild(res, rtNode);
			
			BeanUtils.copyProperties(res, rtNode);
			rtNode.setId(res.getResourceId());
			rtNode.setChecked(this.isSelectedResource(rtNode, rsList));
			rtNode.setName(res.getText());
			rtNode.setText(res.getType());
			
			rtnList.add(rtNode);

		}

		// System.out.println(JSONArray.fromObject(rtnList));

		return rtnList;

	}

	/**
	 * 判断指定的节点及其孩子节点是否分配给角色，如分配给角色，则设置checked == true
	 * 
	 * @param rtNode
	 * @param rsList
	 * @return
	 */
	private boolean isSelectedResource(SysResourcesTreeNode rtNode,
			List<SysRolesResources> rsList) {

		// 根据角色已分配的资源，设置资源树的节点是否选中
		for (SysRolesResources rs : rsList) {
			if (rs.getResourcesId().equals(rtNode.getResourceId()))
				return true;

		}


		return false;
	}

	/**
	 * 1 获得指定resourcesId 的所有叶子节点 2 依次插入叶子节点 2.1 需判断 roleId，resourceId 的节点是否已分配
	 * 2.2 将未分配的资源的 roleId，resourceId 插入到 roles_resources表中
	 */
	@Transactional
	public boolean insert(String roleId, String resourceId) {

		if (roleId == null || "".equals(roleId) || resourceId == null
				|| "".equals(resourceId))
			return false;

		// todo1 根据resourceId 返回其所有的叶子节点
		List<SysResourcesTreeNode> childrenTreeNodes = SysConst.RESOURCESTREE_UNINCLUDE_BUSINESS
				.getLeafNodes(SysConst.RESOURCESTREE_UNINCLUDE_BUSINESS
						.getNode(Integer.parseInt(resourceId)));

		boolean re = false;
		for (SysResourcesTreeNode node : childrenTreeNodes) {

			SysRolesResources record = new SysRolesResources();

			record.setRoleId(Integer.parseInt(roleId));
			record.setResourcesId(node.getResourceId());
			String resourceType = SysConst.RESOURCESTREE_UNINCLUDE_BUSINESS
					.typeOfResource(node.getResourceId());
			if (resourceType != null && resourceType.equals("数据"))
				record.setOrganizationId(-1);

			if (this.isExistRoleResource(Integer.parseInt(roleId), node.getResourceId()))
				continue;
			else
				re = rolesResourcesMapper.insertSelective(record) == 1 ? true
						: false;
		}

		if (re) {
			// 同步系统常量
			init_ROLE_RESOURCE();
		}

		return true;
	}

	/**
	 * 判断指定roleId，resourcesId的记录是否存在
	 * 
	 * @param roleId
	 * @param resourceId
	 * @return
	 */
	private boolean isExistRoleResource(Integer roleId, Integer resourceId) {

		SysRolesResourcesExample example = new SysRolesResourcesExample();
		Criteria criteria = example.createCriteria();

		criteria.andRoleIdEqualTo(roleId);
		criteria.andResourcesIdEqualTo(resourceId);

		if (rolesResourcesMapper.countByExample(example) > 0)
			return true;

		return false;

	}

	public boolean insert(String roleId, String resourceId, String orgStrId) {

		if (roleId == null || "".equals(roleId) || resourceId == null
				|| "".equals(resourceId) || orgStrId == null
				|| "".equals(orgStrId))
			return false;

		SysRolesResources rs = new SysRolesResources();

		rs.setRoleId(Integer.parseInt(roleId));
		rs.setResourcesId(Integer.parseInt(resourceId));
		Integer orgId = Integer.parseInt(orgStrId);
		if (orgId == null)
			orgId = new Integer(-1);
		rs.setOrganizationId(orgId);

		boolean re = rolesResourcesMapper.insertSelective(rs) == 1 ? true
				: false;
		if (re) {
			// 同步系统常量
			init_ROLE_RESOURCE();
		}
		return re;
	}

	/**
	 * 1 获得指定resourcesId 的所有叶子节点 2 依次删除叶子节点
	 */
	@Transactional
	public boolean delete(String roleId, String resourceId) {

		if (roleId == null || "".equals(roleId) || resourceId == null
				|| "".equals(resourceId))
			return false;

		// todo1 根据resourceId 返回其所有的叶子节点
		List<SysResourcesTreeNode> childrenTreeNodes = SysConst.RESOURCESTREE_UNINCLUDE_BUSINESS
				.getLeafNodes(SysConst.RESOURCESTREE_UNINCLUDE_BUSINESS
						.getNode(Integer.parseInt(resourceId)));

		for (SysResourcesTreeNode node : childrenTreeNodes) {

			this.deleteLeafResource(Integer.parseInt(roleId), node.getResourceId());

		}
		init_ROLE_RESOURCE();
		return true;
	}

	/**
	 * 删除已分配的叶子节点资源
	 * 
	 * @param roleId
	 * @param resourceId
	 * @return
	 */
	private boolean deleteLeafResource(Integer roleId, Integer resourceId) {
		SysRolesResourcesExample example = new SysRolesResourcesExample();
		Criteria criteria = example.createCriteria();
		criteria.andRoleIdEqualTo(roleId);
		criteria.andResourcesIdEqualTo(resourceId);
		boolean re = rolesResourcesMapper.deleteByExample(example) < 1 ? true
				: false;

		if (re) {
			// 同步系统常量
			init_ROLE_RESOURCE();
		}
		return re;

	}

	/**
	 * 获得指定角色，指定资源id 已分配的组织架构
	 */
	@Override
	public List<SysOrganizationStructureTreeNode> getRolesResourcesOS(
			String roleId, String resourceId) {

		if (roleId == null || resourceId == null || "".equals(roleId)
				|| "".equals(resourceId))
			return null;

		SysRolesResourcesExample example = new SysRolesResourcesExample();

		Criteria criteria = example.createCriteria();

		criteria.andRoleIdEqualTo(Integer.parseInt(roleId));
		criteria.andResourcesIdEqualTo(Integer.parseInt(resourceId));

		List<SysRolesResources> rsList = rolesResourcesMapper
				.selectByExample(example);

		List<SysOrganizationStructure> osList = organizationStructureService
				.getOrganizationStructure();

		List<SysOrganizationStructureTreeNode> ostnList = new ArrayList<SysOrganizationStructureTreeNode>();
		for (SysOrganizationStructure os : osList) {

			SysOrganizationStructureTreeNode osNode = new SysOrganizationStructureTreeNode();

//			ReflectionUtils.parentToChild(os, osNode);

			BeanUtils.copyProperties(os, osNode);
			osNode.setChecked(this.isSelectedOrganizationStructure(osNode,
					rsList));
			osNode.setId(os.getOsId());
			osNode.setText(os.getName());
			ostnList.add(osNode);
		}
		return ostnList;
	}

	/**
	 * 判断指定的节点是否选中
	 * 
	 * @param rtNode
	 * @param rsList
	 * @return
	 */
	private boolean isSelectedOrganizationStructure(
			SysOrganizationStructureTreeNode osNode, List<SysRolesResources> rsList) {

		// 根据角色已分配的资源，设置资源树的节点是否选中
		for (SysRolesResources rs : rsList) {

			if (rs.getOrganizationId() == osNode.getOsId())
				return true;

		}

		return false;
	}

	@Override
	public boolean delete(String roleId, String resourceId, String orgStrId) {

		if (roleId == null || "".equals(roleId) || resourceId == null
				|| "".equals(resourceId) || orgStrId == null
				|| "".equals(orgStrId))
			return false;

		// TODO Auto-generated method stub
		SysRolesResourcesExample example = new SysRolesResourcesExample();
		Criteria criteria = example.createCriteria();
		criteria.andRoleIdEqualTo(Integer.parseInt(roleId));
		criteria.andResourcesIdEqualTo(Integer.parseInt(resourceId));
		criteria.andOrganizationIdEqualTo(Integer.parseInt(orgStrId));

		boolean re = rolesResourcesMapper.deleteByExample(example) == 1 ? true
				: false;
		if (re) {
			// 同步系统常量
			init_ROLE_RESOURCE();
		}
		return re;
	}

	@Override
	public void init_ROLE_RESOURCE() {
		SysRolesResourcesExample example = new SysRolesResourcesExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusIsNull();

		List<SysRolesResources> listRolesResources = rolesResourcesMapper
				.selectByExample(example);

		SysConst.ROLE_RESOURCE = new RoleResourceOrganization();
		SysConst.ROLE_RESOURCE.updateRRO(listRolesResources);
	}

	@Override
	public boolean delete(Integer roleId) {
		// TODO Auto-generated method stub

		SysRolesResourcesExample example = new SysRolesResourcesExample();
		example.or().andRoleIdEqualTo(roleId);

		rolesResourcesMapper.deleteByExample(example);

		init_ROLE_RESOURCE();

		return true;
	}

	@Override
	public String getResourcesIds(Integer userId) {

		List<Integer> resIdList = this.getResourcesIdList(userId);

		String resourceIds = "";
		// 将List 转为String
		for (Integer rId : resIdList) {

			resourceIds += "RESOURCE_" + rId + "||";
		}

		return resourceIds;
	}

	@Override
	public List<Integer> getResourcesIdList(Integer userId) {

		List<SysUsersRoles> urList = usersRolesService.getUserRoles(userId);

		if(urList== null || urList.size() == 0)
			return null;

		List<Integer> roleIdList = new ArrayList<Integer>();
		

		for (SysUsersRoles ur : urList) {
			roleIdList.add(ur.getRoleId());

		}

		SysRolesResourcesExample example = new SysRolesResourcesExample();
		
		
		
		example.setDistinct(true);
		example.or().andRoleIdIn(roleIdList);

		List<Integer> resIdList = new ArrayList<Integer>();

		List<SysRolesResources> rsList = rolesResourcesMapper
				.selectByExample(example);

		for (SysRolesResources rs : rsList) {

			if (!resIdList.contains(rs.getResourcesId()))
				resIdList.add(rs.getResourcesId());
		}

		return resIdList;
	}

	@Override
	public JSONArray getRolesResourcesOSTest(String roleId, String resourceId) {
		JSONArray jarray = new JSONArray();
		if (roleId == null || resourceId == null || "".equals(roleId)
				|| "".equals(resourceId))
			return null;

		SysRolesResourcesExample example = new SysRolesResourcesExample();

		Criteria criteria = example.createCriteria();

		criteria.andRoleIdEqualTo(Integer.parseInt(roleId));
		criteria.andResourcesIdEqualTo(Integer.parseInt(resourceId));

		List<SysRolesResources> rsList = rolesResourcesMapper
				.selectByExample(example);

		List<SysOrganizationStructure> osList = organizationStructureService
				.getOrganizationStructure();
		StringBuilder osIds = new StringBuilder();
		for (SysOrganizationStructure os : osList) {
			
			SysOrganizationStructureTreeNode osNode = new SysOrganizationStructureTreeNode();

//			ReflectionUtils.parentToChild(os, osNode);

			BeanUtils.copyProperties(os, osNode);
			if(this.isSelectedOrganizationStructure(osNode,
					rsList)){
				JSONObject json = new JSONObject();
				json.put("id",os.getOsId());
				jarray.add(json);
			}
		}
	/*	return osIds.toString().substring(0, osIds.toString().length()-1);*/
			return jarray;
	}

	@Override
	public JSONArray getRolesResourcesInitOS() {
		List<SysOrganizationStructure> osList = organizationStructureService
				.getOrganizationStructure();
		JSONArray jarray = new JSONArray();
		for (SysOrganizationStructure sos : osList) {
			JSONObject json = new JSONObject();
			json.put("id", sos.getOsId());
			json.put("text", sos.getName());
			jarray.add(json);
		}
		return jarray;
	}

}
