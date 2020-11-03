package com.slianOAsys.sysadmin.security;
/**
 * 
 * @author M

 *
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import com.slianOAsys.service.utils.SysConst;
import com.slianOAsys.service.utils.SysResourcesTreeNode;

public class MySecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
	

	public synchronized Collection<ConfigAttribute> getAttributes(Object object)	throws IllegalArgumentException {
		
		String requestUrl= ((FilterInvocation) object).getRequestUrl();
		
		if(requestUrl.contains("?"))
			requestUrl=requestUrl.substring(0, requestUrl.indexOf("?"));
		
		List<Integer> resourceId=SysConst.RESOURCESTREE.resourceMatching(requestUrl);
		
		Collection<ConfigAttribute> configAttributes = getConfigAttributes(resourceId);
		
		return configAttributes;
	}
	
	private Collection<ConfigAttribute>  getConfigAttributes(List<Integer> resourceIdList){
		
		Collection<ConfigAttribute> configAttributes =new ArrayList<ConfigAttribute>();
		
		if(resourceIdList.size()==0)
			configAttributes.add(new SecurityConfig("-1"));///开放权限
		
		else{
			for(Integer resourceId: resourceIdList){
				Map<Integer, SysResourcesTreeNode> resTree=SysConst.RESOURCESTREE.getTree();
				
				Integer currentId=resourceId;
				
				do{
					Set<Integer> roles=SysConst.ROLE_RESOURCE.getRoles(currentId);
					if(roles!=null){
						for(Integer role:roles){
							configAttributes.add(new SecurityConfig(role.toString()));
						}
					}
					
					currentId=resTree.get(currentId).getParentId();
					
				}while(!currentId.equals(new Integer(0)));
			}
			configAttributes.add(new SecurityConfig("-999888"));//超级管理员
			
		}
		return configAttributes;
	}
	

	
	
	

	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}
//	判断是否使用当前的授权判断
	public boolean supports(Class<?> clazz) {
		return true;
	}

}
