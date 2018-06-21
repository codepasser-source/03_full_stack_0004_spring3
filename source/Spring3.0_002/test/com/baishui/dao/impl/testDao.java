package com.baishui.dao.impl; 

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baishui.dao.UserDao;

 
public class testDao { 
	
	@Test
	public void testAddUser(){
		 ApplicationContext app = new ClassPathXmlApplicationContext("beans.xml");
	     UserDao userDao=app.getBean("userDao",UserDao.class); //新特性1:添加了泛型
	     userDao.addUser();
	}
	
}
