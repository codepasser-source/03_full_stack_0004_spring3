package com.baishui.service;


import com.baishui.dao.UserDao;
 
import com.baishui.model.User;

public class UserService {

	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}  
	public void setUserDao(UserDao userDao) {
		
		System.out.println("do setUserDao");
		this.userDao = userDao;
	} 


	public void addUser(User u){ 
		
		System.out.println(this.userDao.toString());
		this.userDao.saveUser(u); 
	}
	
}
