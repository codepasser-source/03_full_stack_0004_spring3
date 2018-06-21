package com.baishui.service;

import org.junit.Assert;
import org.junit.Test;

import com.baishui.model.User;
 

public class UserManagerTest{
    
	
	@Test
	public void testExiset() { 
		UserManager userMG = UserManager.getMGInstance();
		User user = new User();
		user.setUsername("myxr");
		user.setPassword("baishui");
		boolean exists = userMG.exists(user) ;
		
		Assert.assertEquals(false, exists);//≤‚ ‘∑Ω∑®
	}

	@Test
	public void testAddUser() {
		try {
			UserManager userMG =  UserManager.getMGInstance();
			UserManager userMG2 =  UserManager.getMGInstance();
			System.out.println(userMG==userMG2);
			
			User user = new User();
			user.setUsername("myxro");
			user.setPassword("baishui");
		  if(userMG.exists(user)){
			  userMG.addUser(user);
		  } 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
