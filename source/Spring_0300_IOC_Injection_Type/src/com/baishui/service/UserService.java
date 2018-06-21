package com.baishui.service;


import com.baishui.dao.UserDao;
 
import com.baishui.model.User;

public class UserService {

	private UserDao userDao;
	private String s;
	
	
	public UserService(UserDao userDao,String s) { 
		this.userDao = userDao;
		this.s=s;
		System.out.println("String 类型 的第二个参数"+this.s);
	}
	
	


	public void addUser(User u){ 
		
		System.out.println(this.userDao.toString());
		this.userDao.saveUser(u); 
	}
	
}
