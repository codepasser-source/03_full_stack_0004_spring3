package com.baishui.dao.impl; 

import org.springframework.stereotype.Component; 

import com.baishui.dao.SupportDao;
import com.baishui.dao.UserDao;
import com.baishui.model.User;

@Component(value="userDaoForMySql")
public class UserDaoForMySqlImpl extends SupportDao implements UserDao{


	public User getUser(int id) {
 		return null;
	} 
	public void list() {
 	} 
	
	public void saveUser(User u) {
		 System.out.println("UserDaoForMySQL save user");
		 this.getHibernateTemplate().save(u); 
	}  
	
	
 
 
	 

}
