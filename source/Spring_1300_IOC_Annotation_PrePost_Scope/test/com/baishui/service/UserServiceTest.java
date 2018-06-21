package com.baishui.service;
 
import org.junit.Test; 
 
 
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baishui.dao.impl.UserDaoForOracleImpl;
import com.baishui.model.User;
 
 

public class UserServiceTest {
	@Test
	public void testAdd() throws Exception { 
		//BeanFactory applicationContext = new ClassPathXmlApplicationContext("beans.xml");  
		//验证init  destroy 方法
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml"); //建议用 ApplicationContext 功能更强大 父接口是BeanFactory
	    UserService service = (UserService)applicationContext.getBean("service");   //根据标注命名取出对象
		UserService service1 = (UserService)applicationContext.getBean("service");   //根据标注命名取出对象
		System.out.println(service==service1);
	     applicationContext.destroy();
	} 
}
