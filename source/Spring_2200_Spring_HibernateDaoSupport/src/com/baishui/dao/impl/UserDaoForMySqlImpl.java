package com.baishui.dao.impl; 
import javax.annotation.Resource;  
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component; 
import com.baishui.dao.UserDao;
import com.baishui.model.User;

//@Component(value="userDaoForMySql")
public class UserDaoForMySqlImpl extends HibernateDaoSupport implements UserDao{


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
