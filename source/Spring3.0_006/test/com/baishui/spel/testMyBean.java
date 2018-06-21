package com.baishui.spel; 

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
 
 
 

@ContextConfiguration("classpath:beans.xml")
public class testMyBean extends AbstractJUnit4SpringContextTests { 
	@Resource
	 private MyBean my;
	 
	 @Test
	 public void testSpEL(){
		 System.out.println(my.getRandomNumber());
		 System.out.println(my.getUserRegion());
		 
	 }
}
