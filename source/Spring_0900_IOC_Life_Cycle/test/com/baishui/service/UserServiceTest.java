package com.baishui.service;
 
import org.junit.Test; 
 
 
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
 

public class UserServiceTest {
	@Test
	public void testAdd() throws Exception { 
		//BeanFactory applicationContext = new ClassPathXmlApplicationContext("beans.xml");  
		//��֤init  destroy ����
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml"); //������ ApplicationContext ���ܸ�ǿ�� ���ӿ���BeanFactory
	    UserService service = (UserService)applicationContext.getBean("service");   
	    applicationContext.destroy();
	 
	}
	
	 
}
