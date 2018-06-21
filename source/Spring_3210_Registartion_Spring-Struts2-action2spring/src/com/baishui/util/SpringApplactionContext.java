package com.baishui.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringApplactionContext{

	private static final ApplicationContext app = new ClassPathXmlApplicationContext("beans.xml"); 
	 
	public static Object getBean(String bean){
		return app.getBean(bean); 
	}
}
