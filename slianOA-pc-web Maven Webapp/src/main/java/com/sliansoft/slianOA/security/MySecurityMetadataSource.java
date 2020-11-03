package com.sliansoft.slianOA.security;
/**
 * 
 * @author M
 *
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import com.sliansoft.slianOA.dataaccess.dao.SysResourceMapper;
import com.sliansoft.slianOA.dataaccess.dao.SysRoleMapper;
import com.sliansoft.slianOA.dataaccess.dao.SysRoleResourceMapper;
import com.sliansoft.slianOA.dataaccess.model.SysResource;
import com.sliansoft.slianOA.dataaccess.model.SysResourceExample;
import com.sliansoft.slianOA.dataaccess.model.SysRole;
import com.sliansoft.slianOA.dataaccess.model.SysRoleExample;
import com.sliansoft.slianOA.dataaccess.model.SysRoleResource;
import com.sliansoft.slianOA.dataaccess.model.SysRoleResourceExample;
import com.sliansoft.slianOA.service.utils.Const;
import com.sliansoft.slianOA.service.utils.ResourcesTreeNode;

public class MySecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
	
	@Autowired
	private SysResourceMapper sysResourceMapper;
	
	@Autowired
	private SysRoleResourceMapper sysRoleResourceMapper;
	
	@Autowired
	private SysRoleMapper sysRoleMapper;
	

	public synchronized Collection<ConfigAttribute> getAttributes(Object object)	throws IllegalArgumentException {
		String requestUrl= ((FilterInvocation) object).getRequestUrl();
		if(requestUrl.contains("?"))
			requestUrl=requestUrl.substring(0, requestUrl.indexOf("?"));
		List<Integer> resourceId=Const.RESOURCESTREE.resourceMatching(requestUrl);
		Collection<ConfigAttribute> configAttributes = getConfigAttributes(resourceId);
		return configAttributes;
	}
	
	private Collection<ConfigAttribute>  getConfigAttributes(List<Integer> resourceIdList){
		Collection<ConfigAttribute> configAttributes =new ArrayList<ConfigAttribute>();
		if(resourceIdList.size()==0)
			configAttributes.add(new SecurityConfig("-1"));//开放权限
		else{
			for(Integer resourceId: resourceIdList){
				Map<Integer, ResourcesTreeNode> resTree=Const.RESOURCESTREE.getTree();
				Integer currentId=resourceId;
				do{
					Set<Integer> roles=Const.ROLE_RESOURCE.getRoles(currentId);
					if(roles!=null){
						for(Integer role:roles){
							configAttributes.add(new SecurityConfig(role.toString()));
						}
					}
					currentId=resTree.get(currentId).getParentid();
				}while(!currentId.equals(new Integer(0)));
			}
			configAttributes.add(new SecurityConfig("-999888"));//超级管理员
		}
		return configAttributes;
	}
	
//  仅会在第一次调用该类的时候执行一次，将所有资源与角色对应关系存入resourceMap
	private  void  loadResourceDefine() {
		//系统资源表已于系统初始化时加载
			/*resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
			ResourcesExample example = new ResourcesExample();
			example.or().andIdIsNotNull();
			List<Resources> resources = this.resourcesMapper.selectByExample(example);
			for (Resources resource : resources) {
				System.out.println(resource);
				Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();	
				getNeedRoleOfRs(resource.getId(),configAttributes,resource);			
			}
		   System.out.println("系统指定资源列表加载完毕");*/
	}
	
	
	
	
	/*private void getNeedRoleOfRs(Integer id,Collection<ConfigAttribute> configAttributes,Resources resource) {
		List<RolesResources> rolesResources = new ArrayList<RolesResources>();
		RolesResourcesExample example = new RolesResourcesExample();
		example.or().andResidEqualTo(id);
		rolesResources = rolesResourcesMapper.selectByExample(example);
		if(rolesResources.size()==0){
			configAttributes.add(new SecurityConfig("PUBLIC"));
			resourceMap.put(resource.getUrl(), configAttributes);
			return;
		}
		
		Iterator<RolesResources>  rri = rolesResources.iterator();

		while(rri.hasNext()){
			RolesExample exam = new RolesExample();
			exam.or().andIdEqualTo(rri.next().getRid());
			List<Roles> roles = rolesMapper.selectByExample(exam);
			configAttributes.add(new SecurityConfig(roles.get(0).getName()));
			resourceMap.put(resource.getUrl(), configAttributes);
		}
			return;
	}*/


	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	public boolean supports(Class<?> clazz) {
		return true;
	}

}
