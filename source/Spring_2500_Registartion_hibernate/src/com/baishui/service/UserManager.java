package com.baishui.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.baishui.model.User;
import com.baishui.util.HibernateUtil;

public class UserManager {
	
	private SessionFactory sessionFactory; 
	public UserManager() { 
		this.sessionFactory = HibernateUtil.getSessionFactory();
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

}
