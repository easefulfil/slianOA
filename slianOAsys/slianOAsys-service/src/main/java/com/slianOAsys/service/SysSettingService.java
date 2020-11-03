package com.slianOAsys.service;

import java.util.List;

import com.slianOAsys.model.SysSetting;

public interface SysSettingService {
	
	public boolean insert(String jsonSt);

	public void init_SYSTEMSETTING();
	
	public List<SysSetting> getSystemSetting();

	public boolean insert(SysSetting st);


	public boolean update(SysSetting st);
}
