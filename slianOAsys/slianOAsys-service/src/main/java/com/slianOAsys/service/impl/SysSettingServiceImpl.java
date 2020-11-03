package com.slianOAsys.service.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slianOAsys.dao.SysSettingMapper;
import com.slianOAsys.model.SysSetting;
import com.slianOAsys.model.SysSettingExample;
import com.slianOAsys.service.SysSettingService;
import com.slianOAsys.service.utils.SysConst;

@Service
public class SysSettingServiceImpl implements SysSettingService {

	@Autowired
	private SysSettingMapper systemSettingMapper;

	public List<SysSetting> getSystemSetting() {

		SysSettingExample example = new SysSettingExample();

		return systemSettingMapper.selectByExample(example);

	}

	public boolean insert(SysSetting st) {

		if (systemSettingMapper.insertSelective(st) != 1)
			return false;

		// this.init_RESOURCESTREE_UNINCLUDE_BUSINESS();

		return true;
	}

	public boolean update(SysSetting st) {

		if (systemSettingMapper.updateByPrimaryKey(st) != 1)
			return false;

		this.init_SYSTEMSETTING();
		
//		Const.initConstFor_QUERY("init_SYSTEMSETTING");

		return true;
	}

	@Override
	public void init_SYSTEMSETTING() {
		// TODO Auto-generated method stub

		SysConst.SYSTEMSETTING = new HashMap<String, String>();

		List<SysSetting> ssList = this.getSystemSetting();

		for (SysSetting ss : ssList) {

			SysConst.SYSTEMSETTING.put(ss.getStKey(), ss.getStValue());
		}


	}

	@Override
	public boolean insert(String jsonSt) {
		// TODO Auto-generated method stub
		if (jsonSt == null || "".equals(jsonSt))
			return false;

		JSONObject jSt = JSONObject.fromObject(jsonSt);
		SysSetting st  ;
		
		Iterator it = jSt.keys();
		while(it.hasNext()){
			
			String stKey = (String)it.next();
			
			st= new SysSetting();
			
			st.setStKey(stKey);
			st.setStValue(jSt.getString(stKey));
			
			if(!this.update(st))
				return false;
		}


		// 注销时间转换器
		// JSONUtils.getMorpherRegistry().deregisterMorpher(new
		// DateMorpherEx(new String[] { "yyyy-MM-dd" },(Date)null));
	

		return true;
	}

}
