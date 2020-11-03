package com.slianOAsys.service.utils;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

public class StringJsonValueProcessor  implements JsonValueProcessor{

	public StringJsonValueProcessor(){
		
	}
	

	@Override
	public Object processObjectValue(String arg0, Object arg1, JsonConfig arg2) {
		// TODO Auto-generated method stub
		if(arg1 == null)
			return "";
		return arg1;
	}


	@Override
	public Object processArrayValue(Object arg0, JsonConfig arg1) {
		// TODO Auto-generated method stub
		return arg0;
	}

	
}
