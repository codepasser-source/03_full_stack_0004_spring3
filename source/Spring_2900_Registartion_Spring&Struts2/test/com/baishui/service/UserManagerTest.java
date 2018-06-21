package com.baishui.service;

import org.junit.Assert;
import org.junit.Test;

import com.baishui.action.UserAction;
import com.baishui.dao.impl.UserDaoForMySqlImpl;
 
import com.baishui.util.SpringApplactionContext;
 

public class UserManagerTest{
    
	
	 @Test
	 public void testAction()throws Exception{ 
		 
		UserAction userAction =(UserAction) SpringApplactionContext.getBean("userAction"); 
		 userAction.setUsername("sssss");
		 userAction.setPassword("password");
		 String s = userAction.execute();
		 Assert.assertEquals("success", s); 
	 }
	 
	 @Test
	 public void testBeanScope(){
		 
			UserAction userAction =(UserAction) SpringApplactionContext.getBean("userAction"); 
			UserAction userAction1=(UserAction) SpringApplactionContext.getBean("userAction");
			
			UserManager userMG = (UserManager) SpringApplactionContext.getBean("userManager");
			UserManager userMG1 = (UserManager) SpringApplactionContext.getBean("userManager");
			
			UserDaoForMySqlImpl userDao = (UserDaoForMySqlImpl) SpringApplactionContext.getBean("userDaoForMySqlImpl");
			UserDaoForMySqlImpl userDao1 = (UserDaoForMySqlImpl) SpringApplactionContext.getBean("userDaoForMySqlImpl");
			
			System.out.println(userAction==userAction1);
			System.out.println(userMG==userMG1); 
			System.out.println(userDao==userDao1);
			
	 }
}
