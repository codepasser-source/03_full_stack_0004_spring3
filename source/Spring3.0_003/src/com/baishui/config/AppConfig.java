package com.baishui.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration; 
import com.baishui.dao.UserDao;
import com.baishui.dao.impl.UserDaoForMySqlImpl;

@Configuration   //此注解是 CGlib 中的
public class AppConfig { 
	@Bean
	public UserDao userDao(){ 
		return new UserDaoForMySqlImpl();
	}
	/*xml
	 * <bean id="userDao" class="com.baishui.dao.impl.UserDaoForMySqlImpl"></bean>
	*/
}
