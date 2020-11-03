package com.slianOAsys.sysadmin.security;
/**
 * 
 * @author M
 *
 */
import java.util.Collection;

import java.util.Iterator;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

//In this method, need to compare authentication with configAttributes.
//  1, A object is a URL, a filter was find permission configuration by this URL, and pass to here.
//  2, Check authentication has attribute in permission configuration (configAttributes)
//  3, If not match corresponding authentication, throw a AccessDeniedException. 
public class MyAccessDecisionManager implements AccessDecisionManager {
	 /**
	      * Authentication autenticaion --->用户具有的角色权限 
	     * Collection<ConfigAttribute> GranAuthority --->访问该资源所需的角色权限
	     */
	public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {

		//不受控资源
		if(configAttributes == null) {  
            return;  
        } 
		//所请求的资源拥有的权限(一个资源对多个权限)  
        Iterator<ConfigAttribute> iterator = configAttributes.iterator();  
        while(iterator.hasNext()) {  
            ConfigAttribute configAttribute = iterator.next();  
            //访问所请求资源所需要的权限  
            String needPermission = configAttribute.getAttribute();  
           // System.out.println("needPermission is " + needPermission);  
            //用户所拥有的权限authentication  
            for(GrantedAuthority ga : authentication.getAuthorities()) {  
                if(needPermission.equals(ga.getAuthority())) {  
                    return;  
                }  
            }  
        }  
        //没有权限   
		throw new AccessDeniedException("未授权！");
	}

	public boolean supports(ConfigAttribute attribute) {
		return true;
	}

	public boolean supports(Class<?> clazz) {
		return true;
	}

}
