package com.baishui.service;
 

import com.baishui.dao.UserDao;
import com.baishui.dao.impl.UserDaoForMySqlImpl;
import com.baishui.model.User;
 

public class UserManager {
	
	 
	private UserDao userDaoForMySqlImpl=(UserDaoForMySqlImpl)UserDaoForMySqlImpl.getDaoInstance();
	
	private static final UserManager userManager = new UserManager();
	
	public static UserManager getMGInstance(){ 
		return userManager;
	} 

	public boolean exists(User u){
		boolean b = userDaoForMySqlImpl.exists(u);
		 return b;
	}
	
	public void addUser(User u){
		userDaoForMySqlImpl.addUser(u); 
	}

}
