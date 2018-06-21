package com.baishui.dao.impl;

import java.util.Collection;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.baishui.dao.SuperDao;
import com.baishui.dao.UserDao;
import com.baishui.model.User;

@Component(value="userDaoForMySqlImpl")
public class UserDaoForMySqlImpl extends SuperDao implements UserDao{

	 
 
	public boolean exists(User u){ 
		Session session = this.getHibernateTemplate().getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql="select count (*) from User u where u.username = :username and u.password = :password";
		long c = (Long)session.createQuery(hql).setString("username", u.getUsername()).setString("password", u.getPassword()).uniqueResult();
        
		if(c > 0){
			return false;
		}else{ 
			return true;
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
