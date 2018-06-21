package com.baishui.service;


import javax.annotation.Resource;

 

import com.baishui.dao.UserDao;
 
import com.baishui.model.User;

public class UserService {

	private UserDao userDao; 

	 

	public void addUser(User u){ 
		
		System.out.println(this.userDao.toString());
		this.userDao.saveUser(u); 
	} 
	
    @Resource 
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public UserDao getUserDao() {
		return userDao;
	} 
}
