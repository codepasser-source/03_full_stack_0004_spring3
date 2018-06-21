package com.baishui.dao.impl;

import com.baishui.model.User;

public class UserDaoForOracleImpl2 extends UserDaoForOracleImpl{ 
	@Override
	public void saveUser(User u) {  
		System.out.println("save start...");
		super.saveUser(u);
		System.out.println("save over...");
	}
}
