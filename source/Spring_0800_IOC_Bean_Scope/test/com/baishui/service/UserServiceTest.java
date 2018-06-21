package com.baishui.service;
 
import org.junit.Test; 
 
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
 

public class UserServiceTest {
	@Test
	public void testAdd() throws Exception { 
		//BeanFactory applicationContext = new ClassPathXmlApplicationContext("beans.xml");  
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml"); //建议用 ApplicationContext 功能更强大 父接口是BeanFactory
	    UserService service = (UserService)applicationContext.getBean("service"); 
	 
		
		System.out.println(service.getUserDao());
	 
	}
	
	 
}
