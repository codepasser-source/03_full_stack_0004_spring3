package com.baishui.service; 
import javax.annotation.Resource; 
 
import org.springframework.stereotype.Component; 
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.baishui.dao.LogDao;
import com.baishui.dao.UserDao;  
import com.baishui.model.Log;
import com.baishui.model.User; 
@Component(value="service")
public class UserService {

	private UserDao userDao;
	private LogDao logDao;
	
	@Transactional(propagation=Propagation.REQUIRED) //REQUIRED 含义：如果当前有Transaction对象就用当前的对象，如果没有创建一个新的Transaction
	public void addUser(User u){  
		    System.out.println("service adduser method");
			this.userDao.saveUser(u); 
			Log log =  new Log();
			log.setMsg("a save user");
			this.logDao.saveLog(log); 
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
	@Resource(name="logDaoForMySql")
	public void setLogDao(LogDao logDao) {
		this.logDao = logDao;
	} 
	public LogDao getLogDao() {
		return logDao;
	}
}
