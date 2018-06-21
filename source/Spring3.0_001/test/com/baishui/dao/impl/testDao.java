package com.baishui.dao.impl; 

import javax.annotation.Resource; 
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration; 
import com.baishui.dao.UserDao; 

@ContextConfiguration("classpath:beans.xml")
public class testDao extends org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests{

	@Resource(name="userDao")
	private UserDao userDao;
	
	@Test
	public void testAddUser(){
		this.userDao.addUser();
	}
	
}
