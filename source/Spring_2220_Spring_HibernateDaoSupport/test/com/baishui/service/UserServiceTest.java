package com.baishui.service;
 
import org.junit.Test; 
 
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
import com.baishui.model.User;
 
 

public class UserServiceTest {
	@Test
	public void testAdd() throws Exception { 
		//BeanFactory applicationContext = new ClassPathXmlApplicationContext("beans.xml");  
		//��֤init  destroy ����
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml"); //������ ApplicationContext ���ܸ�ǿ�� ���ӿ���BeanFactory
	    UserService service = (UserService)applicationContext.getBean("service");  
	    User user = new User();
	    user.setPassword("xr");
	    user.setUsername("xr");
	     service.addUser(user);  
	}
	
	 
}
