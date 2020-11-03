package com.slianOAsys.service.utils;
/**
 * 
 */


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright@宁波高新区敏智科技有限公司 www.mz3co.com Copyright@浙江大学软件学院S309实验室
 * 
 * @author chengxl Cteated time：2015年1月17日 上午10:17:59
 * 
 */
public class ReflectionUtils {


	/**
	 * 根据对象方法名称，设置对象的属性值
	 * @param o 
	 * @param method ,is method name
	 * @param type ,is parameter type name,ex:class java.lant.Integer 
	 * @param value ,is parameter value
	 */

	public static void setObjectValues(Object o, String method, String type,Object value) {
			
			try {
				
				Class<?> ParameterType  = Class.forName(type.split(" ")[1]);
				Method m = o.getClass().getMethod(method,ParameterType);
				m.invoke(o,value);
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	/**
	 * 获取属性类型(type)，属性名(name)，属性值(value)的map组成的list
	 * 
	 */

	public static List<Map<?,?>> getFiledValues(Object o, boolean isContainNullValue) {
		List<Map<?,?>> list = new ArrayList<Map<?,?>>();

		Class<?> clazz = o.getClass();
		Field[] fields = clazz.getDeclaredFields();

		setMapByFields(o, list, fields, isContainNullValue);

		// 获取父类属性信息
		clazz = clazz.getSuperclass();
		if (clazz == Object.class)
			return list;

		fields = clazz.getDeclaredFields();

		// 设父类的属性
		setMapByFields(o, list, fields, isContainNullValue);

		return list;

	}

	private static void setMapByFields(Object o,List<Map<?,?>> list,
			Field[] fields, boolean isContainNullValue) {

		Map<String, Object> infoMap = null;
		Object value = null;
		// for (int i = 0; i < fields.length; i++) {
		for (Field field : fields) {
			infoMap = new HashMap<String, Object>();
			infoMap.put("type", field.getType().toString());

			infoMap.put("name", field.getName());

			value = getFieldValueByName(field.getName(), o);
			if (!isContainNullValue && (value == null || "".equals(value.toString())))
				continue;

			infoMap.put("value", value);
			list.add(infoMap);
		}

	}

	/**
	 * 根据属性名获取属性值
	 * */
	private static Object getFieldValueByName(String fieldName, Object o) {
		try {
			String firstLetter = fieldName.substring(0, 1).toUpperCase();
			String getter = "get" + firstLetter + fieldName.substring(1);
			Method method = o.getClass().getMethod(getter, new Class[] {});
			Object value = method.invoke(o, new Object[] {});

			return value;
		} catch (Exception e) {

			return null;
		}
	}

	


}
