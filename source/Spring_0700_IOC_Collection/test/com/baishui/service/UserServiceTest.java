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
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml"); //建议用 ApplicationContext 功能更强大 父接口是BeanFactory
		
		
		UserService service = (UserService)applicationContext.getBean("service"); 
		 
	 
		User u = new User();
		u.setUsername("zhangsan");
		u.setPassword("zhangsan");
		service.addUser(u);
		
		UserDaoForOracleImpl userdfo =	(UserDaoForOracleImpl)service.getUserDao();
		//验证 userdao 中的collection 属性是否被注入
		System.out.println(userdfo.getLists().size());
		System.out.println(userdfo.getSets().isEmpty());
		System.out.println(userdfo.getMaps().get("1"));
		
	}
	
	 
}
