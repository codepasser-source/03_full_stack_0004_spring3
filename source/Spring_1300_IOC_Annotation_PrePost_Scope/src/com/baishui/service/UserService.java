package com.baishui.service;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

 

import com.baishui.dao.UserDao;
 
import com.baishui.model.User;

@Scope(value="prototype")
@Component(value="service")
public class UserService {

	private UserDao userDao;  
	public void addUser(User u){  
		this.userDao.saveUser(u); 
	} 
	
    @Resource(name="userDao")
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public UserDao getUserDao() {
		return userDao;
	} 
	
	@PostConstruct
	public void init(){ 
		System.out.println("UserService @PostConstruct init method...");
	} 
	@PreDestroy
	public void destroy(){
		
		System.out.println("UserService @PreDestroy destroy method...");
	}
}
