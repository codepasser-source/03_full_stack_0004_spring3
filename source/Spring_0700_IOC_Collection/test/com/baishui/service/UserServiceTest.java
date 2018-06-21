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
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml"); //������ ApplicationContext ���ܸ�ǿ�� ���ӿ���BeanFactory
		
		
		UserService service = (UserService)applicationContext.getBean("service"); 
		 
	 
		User u = new User();
		u.setUsername("zhangsan");
		u.setPassword("zhangsan");
		service.addUser(u);
		
		UserDaoForOracleImpl userdfo =	(UserDaoForOracleImpl)service.getUserDao();
		//��֤ userdao �е�collection �����Ƿ�ע��
		System.out.println(userdfo.getLists().size());
		System.out.println(userdfo.getSets().isEmpty());
		System.out.println(userdfo.getMaps().get("1"));
		
	}
	
	 
}
