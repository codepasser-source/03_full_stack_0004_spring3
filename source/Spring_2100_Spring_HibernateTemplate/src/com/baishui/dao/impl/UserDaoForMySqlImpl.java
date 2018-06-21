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
     *ע��HibernateTemplate����Session�ķ������з�װ 
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
