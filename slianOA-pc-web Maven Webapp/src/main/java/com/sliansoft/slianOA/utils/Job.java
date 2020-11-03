package com.sliansoft.slianOA.utils;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sliansoft.slianOA.dataaccess.dao.OaVehicleInsuranceMapper;
import com.sliansoft.slianOA.dataaccess.model.OaVehicleInsurance;
import com.sliansoft.slianOA.dataaccess.model.OaVehicleInsuranceExample;

public class Job {

	@Autowired
	private OaVehicleInsuranceMapper oaVehicleInsuranceMapper;
	/*
	 * 每天定时处理判断是否脱保；若当前日期不在保险日期范围内则脱保
	 */
	public void InsuranceExpire(){
		OaVehicleInsuranceExample example = new OaVehicleInsuranceExample();
		List<OaVehicleInsurance> oaVehicleInsurances = oaVehicleInsuranceMapper.selectByExample(example);
		Date currentDate = new Date();
		for(OaVehicleInsurance oaVehicleInsurance : oaVehicleInsurances){
			if(oaVehicleInsurance.getBeginTime().getTime()<= currentDate.getTime() && oaVehicleInsurance.getEndTime().getTime()>=currentDate.getTime()){
				oaVehicleInsurance.setInsuranceStatus("在保");
			}else{
				oaVehicleInsurance.setInsuranceStatus("脱保");
			}
			oaVehicleInsuranceMapper.updateByPrimaryKeySelective(oaVehicleInsurance);
		}
}
}
