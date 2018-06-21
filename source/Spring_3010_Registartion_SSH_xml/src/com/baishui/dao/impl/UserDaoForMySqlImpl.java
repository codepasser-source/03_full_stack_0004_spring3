package com.baishui.dao.impl;

import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.baishui.dao.SuperDao;
import com.baishui.dao.UserDao;
import com.baishui.model.User;

//@Component(value="userDaoForMySqlImpl")
public class UserDaoForMySqlImpl extends SuperDao implements UserDao{

	 
 
	public boolean exists(User u){ 
		 String hql="from User u" +
	 		" where u.username = '" +u.getUsername()+
	 		"' and u.password = '"+u.getPassword()+"'";
	 List<User> users =  this.hibernateTemplate.find(hql);
		if (users.size() == 0) {
			return true;
		} else {
			return false;
		}
	}
	
     public void addUser(User u){ 
    	
		 this.getHibernateTemplate().save(u);
		 //throw new RuntimeException("error");
	}



	public void insert(Object model) {
		// TODO Auto-generated method stub
		
	}



	public Collection<Object> list() {
		// TODO Auto-generated method stub
		return null;
	}



	public Object select(Object model) {
		// TODO Auto-generated method stub
		return null;
	}



	public void update(Object model) {
		// TODO Auto-generated method stub
		
	}

}
