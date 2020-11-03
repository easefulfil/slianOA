package com.slianOAsys.service;

import java.util.Map;

import com.slianOAsys.model.InspectionRecord;

public  interface CoreService {
	
	//public final String processRequest(String msg);
	
	public String insert(InspectionRecord inspectionrecord,int imgnum);
	public Map getParameterById(int id);
	public Map getParam(String url);
	public String downloadMedia(String mediaId, String basePath);
	//public Map onload(String msg);
}
