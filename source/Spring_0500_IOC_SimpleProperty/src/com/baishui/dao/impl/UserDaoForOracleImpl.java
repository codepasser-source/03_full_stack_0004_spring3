package com.baishui.dao.impl;

import com.baishui.dao.UserDao;
import com.baishui.model.User;

public class UserDaoForOracleImpl implements UserDao {

	
	   private int id;
	   private String userDaoStatus; 
	   
	public void saveUser(User u) {
		// TODO Auto-generated method stub
		System.out.println("UserDaoForOracleImpl save user");
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserDaoStatus() {
		return userDaoStatus;
	}
	public void setUserDaoStatus(String userDaoStatus) {
		this.userDaoStatus = userDaoStatus;
	}

	
}
