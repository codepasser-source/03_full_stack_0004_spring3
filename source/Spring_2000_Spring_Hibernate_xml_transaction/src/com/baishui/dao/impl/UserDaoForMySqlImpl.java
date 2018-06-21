package com.baishui.dao.impl;

 
 
 
import javax.annotation.Resource; 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component; 
import com.baishui.dao.UserDao;
import com.baishui.model.User;

@Component(value="userDaoForMySql")
public class UserDaoForMySqlImpl implements UserDao{  
	
	
	private SessionFactory sessionFactory; 
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
    @Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	} 
    
    
	public void saveUser(User u) { 
		System.out.println("UserDaoForMySqlImpl saveUser ...");
		Session session = sessionFactory.getCurrentSession(); 
		session.save(u);
	 
		 
	}

	public void list() {
		// TODO Auto-generated method stub
		
	}
	public User getUser(int id) {
		Session session = sessionFactory.getCurrentSession();
		User user = (User)session.get(User.class, id);
		return user;
	}
	
	 

}
