/**
 * 
 */
package com.slianOAsys.admin.utils;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ServletContextAware;

import com.slianOAsys.service.SysBasicDataSetService;
import com.slianOAsys.service.SysEmployeeService;
import com.slianOAsys.service.SysOrganizationStructureService;
import com.slianOAsys.service.SysResourcesService;
import com.slianOAsys.service.SysRolesResourcesService;
import com.slianOAsys.service.SysSettingService;

/**
 * Copyright@瀹佹尝楂樻柊鍖烘晱鏅虹鎶�湁闄�www.mz3co.com Copyright@娴欐睙澶у杞欢瀛﹂櫌S309瀹為獙瀹� * 
 * @author chengxl Cteated time锟�015锟�锟�7锟�涓婂崍9:00:12
 * 
 */

public class SysConstInitListener implements InitializingBean,
		ServletContextAware {


	
	@Autowired
	private SysResourcesService resourcesService;
	
	@Autowired
	private SysOrganizationStructureService organizationStructureService;
	
	@Autowired
	private SysBasicDataSetService basicDataSetService;

	
	@Autowired
	private SysRolesResourcesService rolesResourcesService;

	
	@Autowired
	private SysSettingService systemSettingService;
	
	@Autowired
	private SysEmployeeService employeeService;
	
/*	@Autowired
	private YearCheckQuartz yearCheckQuartz;
	
	@Autowired
	private JudgeIsInspected judgeIsInspected;
	
	@Autowired
	private RestoreStatusQuartz restoreStatusQuartz;*/
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.context.ServletContextAware#setServletContext
	 * (javax.servlet.ServletContext)
	 */
	public void setServletContext(ServletContext arg0) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 * spring绯荤粺鍚姩浠ュ悗锛屽姞杞藉熀锟�锟斤拷锟�
	 */
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
		resourcesService.init_RESOURCESTREE_UNINCLUDE_BUSINESS();
		
		resourcesService.init_RESOURCESTREE();
		
		organizationStructureService.init_ORGANIZATIONSTRUCTURE_TREE();
//
//		
		rolesResourcesService.init_ROLE_RESOURCE();
//
//		
		systemSettingService.init_SYSTEMSETTING();
		
		
		employeeService.init_EMPLOYEEMAP();
		
		
		basicDataSetService.init_BASICDATASET_TREE();


		
	}
	
	
	
}
