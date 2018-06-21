package com.baishui.service.impl;

import com.baishui.dao.UserDao;
import com.baishui.service.UserService;

public class UserServiceImpl implements UserService{

	private  UserDao userDao;
	
	
	public UserDao getUserDao() {
		return userDao;
	}


	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


 
	public void addUser() {
		 
		this.userDao.addUser();
	}

	
}
