package com.baishui.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration; 
import com.baishui.dao.UserDao;
import com.baishui.dao.impl.UserDaoForMySqlImpl;
import com.baishui.service.UserService;
import com.baishui.service.impl.UserServiceImpl;

@Configuration   //��ע���� CGlib �е�
public class AppConfig { 
	@Bean
	public UserDao userDao(){ 
		return new UserDaoForMySqlImpl();
	}
	
	@Bean
	public UserService userService(){
		UserServiceImpl userService = new UserServiceImpl();
		userService.setUserDao(userDao());
		return userService;
		
	}
	/*xml
	 * <bean id="userDao" class="com.baishui.dao.impl.UserDaoForMySqlImpl"></bean>
	*/
}
