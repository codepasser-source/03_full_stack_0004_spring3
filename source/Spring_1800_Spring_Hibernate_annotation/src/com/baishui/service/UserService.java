package com.baishui.service;





import javax.annotation.Resource;
 
import org.springframework.stereotype.Component;

 

import com.baishui.dao.UserDao;
 
import com.baishui.model.User;

 
@Component(value="service")
public class UserService {

	private UserDao userDao;  
	public void addUser(User u){  
		 System.out.println("service adduser method");
		this.userDao.saveUser(u); 
	}  
	
	public void userList(){ 
		this.userDao.list();
	}
	
    @Resource(name="userDaoForMySql") 
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public UserDao getUserDao() {
		return userDao;
	} 
}
