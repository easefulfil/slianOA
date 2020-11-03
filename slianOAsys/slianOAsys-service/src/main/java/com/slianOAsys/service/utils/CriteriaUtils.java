package com.slianOAsys.service.utils;
/**
 * 
 */


import java.util.List;
import java.util.Map;



/**
 * Copyright@宁波高新区敏智科技有限公司 www.mz3co.com Copyright@浙江大学软件学院S309实验室
 * 
 * @author chengxl Cteated time：2015年1月17日 下午3:01:23
 * 
 */

//set mybaits criteria
public class CriteriaUtils {

	public static void setCriteria(Object o, List<Map<?,?>> list) {

		String criteriaMethodName ="";
		
		for (Map map : list) {
			
			
			
			//parameters type,ex: class java.lang.Integer
			String type = (String)map.get("type");
			Object value = map.get("value");
			
		
			
			if("class java.lang.String".equals(type)){// String 类型采用模糊匹配
				criteriaMethodName =  getCriteriaMethodName((String)map.get("name"),"LIKE");
				value = "%"+value.toString() +"%";
			}
			else
				criteriaMethodName =  getCriteriaMethodName((String)map.get("name"),"EQUAL");
		
			
			
			
			ReflectionUtils.setObjectValues(o, criteriaMethodName, type,value);
		}

	}

	private static String getCriteriaMethodName(String modelFiedName, String type) {

		if("EQUAL".equals(type))
			return "and"+CommonUtils.upperHeadChar(modelFiedName)+"EqualTo";
		
		if("LIKE".equals(type))
			return "and"+CommonUtils.upperHeadChar(modelFiedName)+"Like";
		

		return "";
	}
}
