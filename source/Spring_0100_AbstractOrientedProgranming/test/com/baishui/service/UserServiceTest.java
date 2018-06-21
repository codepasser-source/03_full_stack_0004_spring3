package com.baishui.service;



import org.junit.Test;

import com.baishui.dao.UserDao;
import com.baishui.dao.impl.UserDaoForMySqlImpl;
import com.baishui.model.User;
import com.baishui.spring.BeanFactory;
import com.baishui.spring.ClassPathXmlApplicationContext;

public class UserServiceTest {

	   @Test
	   public void testAddUser() {
		UserService service = new UserService(); 
		service.setUserDao(new UserDaoForMySqlImpl()); 
		User user = new User();
		service.addUser(user);
	   }

 

		@Test
		public void testSpringAddUser() { 
			
			try { 
		    BeanFactory factory = new ClassPathXmlApplicationContext(); //����һ��BeanFactory 
		    
			UserService service = new UserService(); 
			UserDao userDao = (UserDao)factory.getBean("userdfo"); //��������� ��������ʵ�ֵ� dao 
			service.setUserDao(userDao);
			
			User user = new User();
			service.addUser(user);
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}
