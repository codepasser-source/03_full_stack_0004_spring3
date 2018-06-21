package com.baishui.dao.impl;

import com.baishui.dao.UserDao;
import com.baishui.model.User;

public class UserDaoForOracleImpl3 implements UserDao { 
	 private UserDaoForOracleImpl userDaoForOracleImpl=new UserDaoForOracleImpl();
	 
	public void saveUser(User u) {
		 System.out.println("save user start...");
		userDaoForOracleImpl.saveUser(u);
		System.out.println("save user over...");
	} 
	public void deleteUser(User u) {
		System.out.println("UserDaoForMySqlImpl user delete ");
		
	}
}
