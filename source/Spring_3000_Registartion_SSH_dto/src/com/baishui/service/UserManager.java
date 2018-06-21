package com.baishui.service;
 

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.baishui.dao.UserDao; 
import com.baishui.model.User;
 
@Component("userManager")
public class UserManager {
	
	 
	private UserDao userDaoForMySqlImpl;
 

	public UserDao getUserDaoForMySqlImpl() {
		return userDaoForMySqlImpl;
	}
    @Resource(name="userDaoForMySqlImpl")
	public void setUserDaoForMySqlImpl(UserDao userDaoForMySqlImpl) {
		this.userDaoForMySqlImpl = userDaoForMySqlImpl;
	}

	public boolean exists(User u){
		boolean b = userDaoForMySqlImpl.exists(u);
		 return b;
	}
	
	public void addUser(User u){
		
		 
			userDaoForMySqlImpl.addUser(u); 
		 
		
	}
	
	

}
