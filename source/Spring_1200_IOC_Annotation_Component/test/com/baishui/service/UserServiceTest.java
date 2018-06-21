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
		//��֤init  destroy ����
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml"); //������ ApplicationContext ���ܸ�ǿ�� ���ӿ���BeanFactory
	    
		UserService service = (UserService)applicationContext.getBean("service");   //���ݱ�ע����ȡ������
		
	    UserDaoForOracleImpl u1 = (UserDaoForOracleImpl)applicationContext.getBean("userDao");  //���ݱ�ע����ȡ������
	    
	    System.out.println(u1.toString());
	    service.addUser(new User());
	    System.out.println(service.getUserDao()); 
	} 
}
