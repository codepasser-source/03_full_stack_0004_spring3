package com.baishui.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.baishui.dao.UserDao;
 
import com.baishui.model.User;

public class UserService {

	private UserDao userDao; 

	 

	public void addUser(User u){ 
		
		System.out.println(this.userDao.toString());
		this.userDao.saveUser(u); 
	} 
	
	@Autowired
	public void setUserDao(@Qualifier(value="userDao") UserDao userDao) {
		this.userDao = userDao;
	}
	public UserDao getUserDao() {
		return userDao;
	} 
}
