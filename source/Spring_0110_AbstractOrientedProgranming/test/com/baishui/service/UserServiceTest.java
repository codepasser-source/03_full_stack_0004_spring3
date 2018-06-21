package com.baishui.service;
 
import java.lang.reflect.Method; 
import org.junit.Test; 
import com.baishui.dao.impl.UserDaoForOracleImpl;
import com.baishui.model.User;
import com.baishui.spring.BeanFactory;
import com.baishui.spring.ClassPathXmlApplicationContext;

public class UserServiceTest {
	@Test
	public void testAdd() throws Exception { 
		BeanFactory applicationContext = new ClassPathXmlApplicationContext(); 
		UserService service = (UserService)applicationContext.getBean("service"); 
		User u = new User();
		u.setUsername("zhangsan");
		u.setPassword("zhangsan");
		service.addUser(u);
	}
	
	@Test
	/**
	 * 控制反转举例
	 * 动态调用 service 对象的 setUserDao 方法
	 */
	public void testInvoke(){
		
		UserService service = new UserService();
		Object beanObject = new UserDaoForOracleImpl();
		
		try {
			Method m = service.getClass().getMethod("setUserDao", beanObject.getClass().getInterfaces()[0]);
		    m.invoke(service, beanObject); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
