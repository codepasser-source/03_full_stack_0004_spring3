package com.baishui.dao.impl;

import java.util.Collection;

import org.hibernate.Session;

import com.baishui.dao.SuperDao;
import com.baishui.dao.UserDao;
import com.baishui.model.User;

public class UserDaoForMySqlImpl extends SuperDao implements UserDao{

	private static final UserDao userDaoForMySqlImpl = new UserDaoForMySqlImpl();
	
	public static UserDao getDaoInstance(){ 
		return userDaoForMySqlImpl;
	} 
	public boolean exists(User u){ 
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hql="select count (*) from User u where u.username = :username and u.password = :password";
		long c = (Long)session.createQuery(hql).setString("username", u.getUsername()).setString("password", u.getPassword()).uniqueResult();
        session.getTransaction().commit(); 
		if(c > 0){
			return false;
		}else{ 
			return true;
		} 
	}
	
     public void addUser(User u){ 
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
	    session.save(u);	
	    
        session.getTransaction().commit();  
        System.out.println("user save");
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
