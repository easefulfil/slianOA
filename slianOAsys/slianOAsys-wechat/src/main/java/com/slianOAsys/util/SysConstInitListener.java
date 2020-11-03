/**
 * 
 */
package com.slianOAsys.util;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ServletContextAware;

import com.slianOAsys.service.CoreService;



/**
 * Copyright@瀹佹尝楂樻柊鍖烘晱鏅虹鎶�湁闄�www.mz3co.com Copyright@娴欐睙澶у杞欢瀛﹂櫌S309瀹為獙瀹� * 
 * @author chengxl Cteated time锟�015锟�锟�7锟�涓婂崍9:00:12
 * 
 */

public class SysConstInitListener implements InitializingBean,
		ServletContextAware {


	
	@Autowired
	private CoreService coreservice;
	
	
	@Override
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
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
		
	}
	
	
	
}
