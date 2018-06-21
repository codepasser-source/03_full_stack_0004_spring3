package com.baishui.service;



import java.lang.reflect.Proxy;

import org.junit.Test;

import com.baishui.aop.LogInterceptor;
import com.baishui.dao.UserDao;
import com.baishui.dao.impl.UserDaoForOracleImpl;
 
import com.baishui.model.User;
import com.baishui.spring.BeanFactory;
import com.baishui.spring.ClassPathXmlApplicationContext;

public class UserServiceTest {

	  

		@Test
		public void testSpringAddUser() {  
			try { 
		    BeanFactory factory = new ClassPathXmlApplicationContext(); //创建一个BeanFactory  
			UserService service = new UserService(); 
			UserDao userDao = (UserDao)factory.getBean("userdfo"); //面向抽象编程 设置哪种实现的 dao 
			service.setUserDao(userDao); 
			User user = new User();
			service.addUser(user); 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		@Test
		public void testProxy() {
			//创建一个需要代理的对象
			UserDao userDAO = new UserDaoForOracleImpl();
			//把需要代理的对象交给动态代理控制器
			LogInterceptor li = new LogInterceptor();
			li.setTarget(userDAO);
			
			//得到一个动态代理对象
			UserDao userDAOProxy = (UserDao)Proxy.newProxyInstance(userDAO.getClass().getClassLoader(), userDAO.getClass().getInterfaces(), li);
			System.out.println(userDAOProxy.getClass()); 
			
		   //通过动态代理对象 执行相应的方法时，就会添加上 共同要执行的方法
			userDAOProxy.saveUser(new User());
			userDAOProxy.deleteUser(new User());
		}
		
		
		/*原理
		 * class $Proxy4 implements UserDAO 
		 * {
		 * 	save(User u) {
		 * 	Method m = UserDAO.getclass.getmethod 
		 * li.invoke(this, m, u)
		 * }
		 * }
		 */
}
