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
		
		@Test
		public void testProxy() {
			//����һ����Ҫ����Ķ���
			UserDao userDAO = new UserDaoForOracleImpl();
			//����Ҫ����Ķ��󽻸���̬���������
			LogInterceptor li = new LogInterceptor();
			li.setTarget(userDAO);
			
			//�õ�һ����̬�������
			UserDao userDAOProxy = (UserDao)Proxy.newProxyInstance(userDAO.getClass().getClassLoader(), userDAO.getClass().getInterfaces(), li);
			System.out.println(userDAOProxy.getClass()); 
			
		   //ͨ����̬������� ִ����Ӧ�ķ���ʱ���ͻ������ ��ͬҪִ�еķ���
			userDAOProxy.saveUser(new User());
			userDAOProxy.deleteUser(new User());
		}
		
		
		/*ԭ��
		 * class $Proxy4 implements UserDAO 
		 * {
		 * 	save(User u) {
		 * 	Method m = UserDAO.getclass.getmethod 
		 * li.invoke(this, m, u)
		 * }
		 * }
		 */
}
