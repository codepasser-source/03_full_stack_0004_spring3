package com.baishui.service;

import org.junit.Assert;
import org.junit.Test;

import com.baishui.action.UserAction;
import com.baishui.model.User;
import com.baishui.util.SpringApplactionContext;
 

public class UserManagerTest{
    
	
	 @Test
	 public void testAction()throws Exception{ 
		 
		 UserAction userAction=new UserAction();
		 userAction.setUsername("sss");
		 userAction.setPassword("password");
		 String s = userAction.execute();
		 Assert.assertEquals("success", s);
		 
		 
	 }
}
