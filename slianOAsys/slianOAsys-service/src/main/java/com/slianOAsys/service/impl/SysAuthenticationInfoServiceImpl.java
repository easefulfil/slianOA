package com.slianOAsys.service.impl;

import java.util.List;




import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.slianOAsys.dao.SysAuthenticationInfoMapper;
import com.slianOAsys.model.SysAuthenticationInfo;
import com.slianOAsys.model.SysAuthenticationInfoExample;
import com.slianOAsys.model.SysAuthenticationInfoExample.Criteria;
import com.slianOAsys.service.SmsService;
import com.slianOAsys.service.SysAuthenticationInfoService;
import com.slianOAsys.service.utils.CommonUtils;

public class SysAuthenticationInfoServiceImpl implements
		SysAuthenticationInfoService {

	@Autowired
	private SysAuthenticationInfoMapper authenticationInfoMapper;
	
	@Autowired
	private SmsService smsService;


	public SysAuthenticationInfoServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean insert(SysAuthenticationInfo authInfo) {
		// TODO Auto-generated method stub

		return authenticationInfoMapper.insertSelective(authInfo) == 1 ? true
				: false;
	}

	@Override
	public boolean delete(String ids) {
		// TODO Auto-generated method stub
		SysAuthenticationInfoExample example = new SysAuthenticationInfoExample();

		example.or().andAuthenticationIdIn(CommonUtils.idsArrayToList(ids));

		try {

			authenticationInfoMapper.deleteByExample(example);

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;

	}

	@Override
	public boolean update(SysAuthenticationInfo authInfo) {
		// TODO Auto-generated method stub

			return authenticationInfoMapper.updateByPrimaryKeySelective(authInfo) == 1 ? true
					: false;
//		else {
//			SysAuthenticationInfoExample example = new SysAuthenticationInfoExample();
//			CriteriaUtils.setCriteria(example, ReflectionUtils.getFiledValues(authInfo, false));
//			
//			return authenticationInfoMapper.updateByExampleSelective(authInfo,
//					example) ==1? true :false;

//		}
	}

	@Override
	public List<SysAuthenticationInfo> getAuthenticationInfo(String uId) {

		if (uId == null || "".equals(uId))
			return null;

		SysAuthenticationInfoExample example = new SysAuthenticationInfoExample();

		example.or().andUserIdEqualTo(Integer.parseInt(uId));// andAccountEqualTo(account);//

		// TODO Auto-generated method stub
		return authenticationInfoMapper.selectByExample(example);
	}

	@Override
	public boolean deleteByUserId(Integer uId) {
		// TODO Auto-generated method stub
		SysAuthenticationInfoExample example = new SysAuthenticationInfoExample();

		example.or().andUserIdEqualTo(uId);

		try {

			authenticationInfoMapper.deleteByExample(example);

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	@Override
	public String resetPassword(String account) {

		SysAuthenticationInfoExample example = new SysAuthenticationInfoExample();

		example.or().andAccountEqualTo(account);
		
	
		String randomPassword = CommonUtils.getRandomPassword(6); 
		
		
		SysAuthenticationInfo authInfo = new SysAuthenticationInfo();
	
		
		authInfo.setPassword(randomPassword);
		
		if( authenticationInfoMapper.updateByExampleSelective(authInfo, example) >0){
			
			//todo
			JSONObject jo = smsService.sendSMS(account,randomPassword + "为您重置后的密码，请登陆后及时修改！");
			
			if(!"短信发送成功".equals(jo.getString("result")))
				return "密码重置失败，"+jo.getString("result")+"！";
			
			return "新密码已发您手机！";
		}
		else
		
			return "密码重置失败，数据库访问异常！";

	}
	
	@Override
	public List<SysAuthenticationInfo> getAuthenticationInfo(String account,
			String password,String type) {

		if(StringUtils.isEmpty(account) || StringUtils.isEmpty(password))
			return null;
		
		SysAuthenticationInfoExample example = new SysAuthenticationInfoExample();
		
		Criteria criteria = example.createCriteria();
		

		criteria.andAccountEqualTo(account);
		criteria.andPasswordEqualTo(password);
		criteria.andTypeEqualTo(type);

		// TODO Auto-generated method stub
		return authenticationInfoMapper.selectByExample(example);
		
	}

	@Override
	public List<SysAuthenticationInfo> getAuthenticationInfo(String account,
			String password) {

		if(StringUtils.isEmpty(account) || StringUtils.isEmpty(password))
			return null;
		
		SysAuthenticationInfoExample example = new SysAuthenticationInfoExample();
		
		Criteria criteria = example.createCriteria();
		

		criteria.andAccountEqualTo(account);
		criteria.andPasswordEqualTo(password);

		// TODO Auto-generated method stub
		return authenticationInfoMapper.selectByExample(example);
		
	}

	@Override
	public boolean isExistAccount(String account) {
		// TODO Auto-generated method stub
		
		SysAuthenticationInfoExample example = new SysAuthenticationInfoExample();
		example.or().andAccountEqualTo(account);
		
		return authenticationInfoMapper.selectByExample(example).size() == 0?false:true;
	}

	@Override
	public String updatePassword(String account, String password,
			String newPassword) {
		// TODO Auto-generated method stub
		
		if(StringUtils.isEmpty(account))
			return "修改失败，帐号不能为空！";
		System.out.println(".....................................");

		List<SysAuthenticationInfo>  authInfoList = this.getAuthenticationInfo(account, password);
		
		if(authInfoList == null || authInfoList.size() == 0)
			return "修改失败，原密码输入不正确!";
		
		int i = 0;
		for(SysAuthenticationInfo authInfo:authInfoList){
			
			authInfo.setPassword( newPassword);
			i += authenticationInfoMapper.updateByPrimaryKeySelective(authInfo);
			
		}
	
		return i > 0 ?"密码修改成功！":"密码修改失败，数据库访问异常！";
	}

}
