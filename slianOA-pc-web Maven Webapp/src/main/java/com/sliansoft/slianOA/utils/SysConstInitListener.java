package com.sliansoft.slianOA.utils;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ServletContextAware;


import com.sliansoft.slianOA.service.InitServiceExcludedFromAop;



public class SysConstInitListener implements InitializingBean,
		ServletContextAware {


	
	@Autowired
	private InitServiceExcludedFromAop initServiceExcludedFromAop;


	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.context.ServletContextAware#setServletContext
	 * (javax.servlet.ServletContext)
	 */
	@Override
	public void setServletContext(ServletContext arg0) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 * spring系统启动以后，加载基础数据
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
		/*resourcesService.init_RESOURCESTREE_UNINCLUDE_BUSINESS();
		
		resourcesService.init_RESOURCESTREE();
		
		organizationStructureService.init_ORGANIZATIONSTRUCTURE_TREE();

		
		rolesResourcesService.init_ROLE_RESOURCE();

		
		systemSettingService.init_SYSTEMSETTING();
		
		
		employeeService.init_EMPLOYEEMAP();
		
		
		basicDataSetService.init_BASICDATASET_TREE();*/
		
		initServiceExcludedFromAop.init_RESOURCESTREE_UNINCLUDE_BUSINESS();
		initServiceExcludedFromAop.init_RESOURCESTREE();
		initServiceExcludedFromAop.init_ROLE_RESOURCE();
		initServiceExcludedFromAop.init_SYSTEMSETTING();
		initServiceExcludedFromAop.init_EMPLOYEEMAP();
		

		initServiceExcludedFromAop.init_ORGANIZATIONSTRUCTURE_TREE();
		initServiceExcludedFromAop.init_BASICDATASET_TREE();
		
		initServiceExcludedFromAop.init_WORKFLOWCUSTOMMAP();
		initServiceExcludedFromAop.init_OAASSET_TREE();
		
		initServiceExcludedFromAop.init_ATTENDANCE_RULE_MAP();
	}
	
	
	
}
