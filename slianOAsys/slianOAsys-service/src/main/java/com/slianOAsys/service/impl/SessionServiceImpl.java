package com.slianOAsys.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.slianOAsys.model.ex.SysUsersEx;
import com.slianOAsys.service.SessionService;
import com.slianOAsys.util.DataAuthorityRegister;

public class SessionServiceImpl implements SessionService {

	@Autowired
	HttpSession session;

	@Override
	public Integer getUserDetailId() {
		// TODO Auto-generated method stub

		SysUsersEx user = this.getSessionHttpUser();

		if (user == null || user.getUserDetailId() == null)
			return -1;

		return user.getUserDetailId();
	}

	@Override
	public List<String> getDataAccessGroup() {
		// TODO Auto-generated method stub

		DataAuthorityRegister dataAuthorityRegister = session
				.getAttribute("dataAuthorityRegister") == null ? null
				: (DataAuthorityRegister) session
						.getAttribute("dataAuthorityRegister");

		if (dataAuthorityRegister == null)
			return null;

		Thread currentTh = Thread.currentThread();
		if (dataAuthorityRegister.isDataUnderControl(currentTh.getId())) {

		}
		Set<Integer> orgSet = dataAuthorityRegister.getOrgList(currentTh
				.getId());

		List<String> orgList = new ArrayList<String>();

		for (Integer org : orgSet) {
			orgList.add(org.toString());
		}

		return orgList;
	}

	@Override
	public synchronized SysUsersEx getSessionHttpUser() {
		// TODO Auto-generated method stub

		return session.getAttribute("loginingUser") == null ? null
				: (SysUsersEx) session.getAttribute("loginingUser");

	}



	@Override
	public void invalidateSession() {
		// TODO Auto-generated method stub
		session.invalidate();
	}

}
