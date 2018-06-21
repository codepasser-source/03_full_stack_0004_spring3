package com.baishui.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration; 
import com.baishui.dao.UserDao;
import com.baishui.dao.impl.UserDaoForMySqlImpl;
import com.baishui.service.UserService;
import com.baishui.service.impl.UserServiceImpl;

@Configuration   //此注解是 CGlib 中的
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
