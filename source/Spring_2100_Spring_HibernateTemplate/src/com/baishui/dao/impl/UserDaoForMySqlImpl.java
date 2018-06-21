package com.baishui.dao.impl; 
import javax.annotation.Resource;  
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component; 
import com.baishui.dao.UserDao;
import com.baishui.model.User;

@Component(value="userDaoForMySql")
public class UserDaoForMySqlImpl implements UserDao{  
	
	
	private HibernateTemplate hibernateTemplate;  
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	} 
    @Resource
    /*
     *注入HibernateTemplate，对Session的方法进行封装 
	 */
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public void saveUser(User u) { 
	  hibernateTemplate.save(u);
	}

	public void list() {
		// TODO Auto-generated method stub
		
	}
	public User getUser(int id) {
		 
		User user = (User)hibernateTemplate.get(User.class, id);
		return user;
	}
	
	 

}
